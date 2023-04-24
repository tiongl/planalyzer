package com.dremio.planalyzer;

import com.dremio.planalyzer.model.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.text.DecimalFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ProfileAnalyzer {
    static DecimalFormat NUMBER_FORMAT = new DecimalFormat("###,###,###,###");

    static Logger logger = java.util.logging.Logger.getLogger(PlanAnalyzer.class.getName());
    
    static List metricSet = Arrays.asList(new String[]{ "RECORD", "CACHE", "EVALUATE", "GROUP"});

    public static void main(String[] args) throws IOException {
        if (args.length > 1) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            logger.info("Input file = " + args[0]);
            //JSON file to Java object
            Profile profile = mapper.readValue(new File(args[0]), Profile.class);
            Map<String, ReflectionDefinition> reflectionMap = getReflectionIdMap(profile);
            Map<List<Long>, Map<String, Metrics>> metrics = getMetrics(profile, metricSet);

            String outputFile = null;
            if (args.length > 1) {
                outputFile = args[1];
            }

            processPlans(profile, outputFile, reflectionMap, metrics, Collections.<String>emptyList(), new AnalysisOption()); //analyze all phases

        } else {
            System.out.println("ProfileAnalyzer <profile json> [<output>]");
        }
    }

    private static List<String> skipPhase = Arrays.asList(new String[]{
            "CACHED_METADATA", "PERMISSION_CACHE_HIT", "Plan Cache Used", "validation", "Executor Selection"
    });

    public static boolean containSubstring(String str, List<String> substrings){
        for (int k=0; k<substrings.size(); k++){
            if (str.contains(substrings.get(k))){
                return true;
            }
        }
        return false;
    }

    public static void processPlans(Profile profile, String outputFile, Map<String, ReflectionDefinition> reflectionMap, 
                                    Map<List<Long>, Map<String, Metrics>> metrics, List<String> targetPhases, AnalysisOption option) throws IOException {
        List<PlanPhase> phases = profile.getPlanPhases();
        for (PlanPhase p : phases) {
            String phaseName = p.getPhaseName().replaceAll(" ", "").toLowerCase();
            if (!containSubstring(p.getPhaseName(), skipPhase)
                    && p.getPlan()!=null && p.getPlan().trim().length() > 0 //not empty
                    && (targetPhases.size() == 0 || containSubstring(phaseName, targetPhases))) {
                String outFile = outputFile + "." + phaseName;
                try {
                    logger.info("Analyzing phase '" + p.getPhaseName() + "'");
                    analyzeAndWriteOutput(p.getPlan(), outFile, reflectionMap, metrics, option);
                    logger.info("Successfully analyze phase '" + p.getPhaseName() + "'");
                } catch (Exception e) {
                    e.printStackTrace();
                    logger.severe("Failed to analyze phase '" + p.getPhaseName());
                }
            }
        }
    }

    private static void analyzeAndWriteOutput(String plan, String outputFile, Map reflectionMap, Map metrics, AnalysisOption option) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile + ".input"));
        writer.write(plan);
        writer.close();
        try {
            PlanLine context = PlanUtils.parsePlan(new ByteArrayInputStream(plan.getBytes()), option.strictParsing);
            PlanAnalyzer analyzer = new PlanAnalyzer(reflectionMap, metrics);
            analyzer.process(context, option, outputFile);
        } catch (Exception e){
            logger.warning("Problem analyzing plan: " + e.getMessage() + "\n" + plan);
        }
    }

    private static String getPlanByName(Profile profile, String name) {
        List<PlanPhase> phases = profile.getPlanPhases();
        for (PlanPhase p : phases) {
            if (p.getPhaseName().equals(name)) {
                return p.getPlan();
            }
        }
        return "";
    }


    private static Map<List<Long>, Map<String, Metrics>> getMetrics(Profile profile, List<String> metricSet) {
        Map<List<Long>, Map<String, Metrics>> metrics = new HashMap();
        List<MetricsDef> metricDefs = profile.getOperatorTypeMetricsMap().getMetricsDef();
        int i = 0;
        StringBuffer sb = new StringBuffer();
        for (MetricsDef mDefs : metricDefs) {
            sb.append("MetricDef #" + i + ": ");
            Iterator<MetricDef> defs = mDefs.getMetricDef().iterator();
            while (defs.hasNext()) {
                MetricDef d = defs.next();
                sb.append(d.getName());
                if (defs.hasNext()) sb.append(", ");
            }
            i += 1;
            sb.append("\n");
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Metric definitions\n" + sb.toString());
        }
        List<FragmentProfile> fragments = profile.getFragmentProfile();
        for (FragmentProfile majorFrag : fragments) {
            for (MinorFragmentProfile minorFrag : majorFrag.getMinorFragmentProfile()) {
                for (OperatorProfile opProf : minorFrag.getOperatorProfile()) {
                    List<Long> id = Arrays.asList(majorFrag.getMajorFragmentId(), opProf.getOperatorId());
                    List<MetricDef> mDefs = metricDefs.get((int) opProf.getOperatorType()).getMetricDef();
                    Map<String, Metrics> collected = metrics.get(id);
                    if (collected == null) {
                        collected = new HashMap<String, Metrics>();
                        metrics.put(id, collected);
                    }

                    int profileNum = 0;
                    //Collecting input profile records
                    List<InputProfile> ips = opProf.getInputProfile();
                    for (InputProfile inputProf : ips) {
                        String name = "input_record" + profileNum;
                        addMetric(collected, name, minorFrag.getEndpoint().getAddress(), inputProf.getRecords());
                        profileNum += 1;
                    }

//                    addMetric(collected, "finish_duration", minorFrag.getEndpoint().getAddress(), minorFrag.getFinishDuration());
//                    addMetric(collected, "duration", minorFrag.getEndpoint().getAddress(), minorFrag.getRunDuration());
                    addMetric(collected, "thread", minorFrag.getEndpoint().getAddress(), 1);
                    //Collecting metrics on ops
                    addMetric(collected, "processing_nanos", minorFrag.getEndpoint().getAddress(), opProf.getProcessNanos());
                    addMetric(collected, "wait_nanos", minorFrag.getEndpoint().getAddress(), opProf.getWaitNanos());
                    addMetric(collected, "setup_nanos", minorFrag.getEndpoint().getAddress(), opProf.getSetupNanos());
                    addMetric(collected, "peak_memory_allocation", minorFrag.getEndpoint().getAddress(), opProf.getPeakLocalMemoryAllocated());


                    //Collecting metrics
                    sb = new StringBuffer();
                    for (Metric m : opProf.getMetric()) {
                        if (m.getMetricId() < mDefs.size()) {
                            MetricDef mDef = mDefs.get((int) m.getMetricId());
                            if (logger.isLoggable(Level.FINE)) {
                                sb.append(mDef.getName() + " ");
                            }
                            boolean collecting = false;
                            for (int k=0; k<metricSet.size(); k++){
                                if (mDef.getName().contains(metricSet.get(k))){
                                    collecting = true;
                                }
                            }
                            if (mDef.getName().contains("RECORD") || mDef.getName().contains("CACHE") || mDef.getName().contains("EVALUATE")) {
                                if (logger.isLoggable(Level.FINE)) logger.fine("Found metric " + mDef.getName());
                                addMetric(collected, mDef.getName().toLowerCase(), minorFrag.getEndpoint().getAddress(), m.getLongValue());
                            } else {
                                if (logger.isLoggable(Level.FINE)) logger.fine("Skipping " + mDef.getName());
                            }
                        } else {
//                            logger.warning("Cannot find metric definition " + m.getMetricId() + " for operator type " + opProf.getOperatorType() );
                        }
                    }
                    if (logger.isLoggable(Level.FINE)) {
                        logger.fine("Found metrics " + sb.toString() + " on fragment " + majorFrag.getMajorFragmentId() + " " + minorFrag.getMinorFragmentId() + " " + opProf.getOperatorId());
                    }
                }
            }
        }
        return metrics;
    }

    private static void addMetric(Map<String, Metrics> metrics, String key, String endpoint, long value) {
        Metrics currentValue = metrics.get(key);
        if (currentValue == null) {
            currentValue = new Metrics(key);
            metrics.put(key, currentValue);
        }
        currentValue.add(endpoint, value);
    }

    private static Map<String, ReflectionDefinition> getReflectionIdMap(Profile profile) throws IOException {
        List<LayoutProfile> layoutProfiles = profile.getAccelerationProfile().getLayoutProfiles();
        Map<String, ReflectionDefinition> reflections = new HashMap<String, ReflectionDefinition>();
        StringBuffer sb = new StringBuffer();
        for (LayoutProfile lp : layoutProfiles) {
            String layoutId = lp.getLayoutId();
            logger.fine("Checking reflection Id " + layoutId);
            String plan = lp.getPlan();
            String reflectionName = (lp.getPlan().trim().length() == 0) ? layoutId : getReflectionViewName(lp.getPlan());
            ReflectionDefinition def = new ReflectionDefinition();
            def.reflectionId = layoutId;
            def.materializationId = lp.getMaterializationId();
            if (reflectionName==null){
                System.out.println("Cannot get reflection name from:\n" + plan);
            }
            String[] splits = reflectionName.split("\\.");
            def.fullName = reflectionName;
            def.viewName = splits[splits.length - 1];
            reflections.put(layoutId, def);
            sb.append("Reflection " + layoutId + " = " + def.fullName + "\n");
        }
        if (logger.isLoggable(Level.FINE)) {
            logger.fine("Reflection definitions\n" + sb.toString());
        }
        return reflections;
    }

    private static String getReflectionViewName(String planString) throws IOException {
        try {
            PlanLine plan = PlanUtils.parsePlan(new ByteArrayInputStream(planString.getBytes()));
            while (!plan.getNode().planName().ID().getText().equals("ExpansionNode")) {
                if (plan.getChildren().size() != 1) {
                    return null;
                } else {
                    plan = plan.getChildren().get(0);
                }
            }
            String path = plan.getAttrMap().get("path");
            return path.substring(1, path.length() - 1);
        } catch (Exception e){
            logger.warning("Unable to resolve relflection name: " + e.getMessage() + "\n" + planString);
            return "Unresolved";
        }
    }


}