package com.dremio.planalyzer;

import com.dremio.planalyzer.model.*;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class ProfileAnalyzer {
    static Logger logger = java.util.logging.Logger.getLogger(PlanAnalyzer.class.getName());

    public static void main(String[] args) throws IOException {
        if (args.length>0) {
            ObjectMapper mapper = new ObjectMapper();
            mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

            //JSON file to Java object
            Profile profile = mapper.readValue(new File(args[0]), Profile.class);
            Map<String, ReflectionDefinition> reflectionMap = getReflectionIdMap(profile);
            Map<List<Long>, Map<String, AtomicLong>> metrics = getMetrics(profile);

            String outputFile = null;
            if (args.length > 1) {
                outputFile = args[1];
            }

            processPlans(profile, outputFile, reflectionMap, metrics, Collections.singleton("Multi-Join analysis"));
//            processPlans(profile, outputFile, reflectionMap, metrics, Collections.<String>emptySet()); //analyze all phases

        } else {
            System.out.println("ProfileAnalyzer <profile json> [<output>]");
        }
    }

    private static Set<String> skipPhase = new HashSet<String>(Arrays.asList(new String[]{
        "validation", "Execution Plan: Executor Selection"
    }));
    public static void processPlans(Profile profile, String outputFile, Map<String, ReflectionDefinition> reflectionMap, Map<List<Long>, Map<String, AtomicLong>>metrics, Set<String> sets) throws IOException{
        List< PlanPhase> phases =  profile.getPlanPhases();
        for (PlanPhase p: phases){
            String phaseName = p.getPhaseName().replaceAll(" ", "").toLowerCase();
            if (p.getPhaseName().indexOf("CACHED_METADATA")==-1  && p.getPhaseName().indexOf("PERMISSION_CACHE_HIT") == -1
                    && p.getPlan()!=null && p.getPlan().length()>10 && !skipPhase.contains(p.getPhaseName())
                    && sets.size()==0 || sets.contains(p.getPhaseName()) || sets.contains(phaseName)) {
                String outFile = outputFile + "." + phaseName;
                try {
                    analyzeAndWriteOutput(p.getPlan(), outFile, reflectionMap, metrics);
                    logger.info("Successfully analyze phase '" + p.getPhaseName() + "'");
                } catch (Exception e) {
                    logger.severe("Failed to analyze phase '" + p.getPhaseName() + "': " + e.getMessage() + "\n" + p.getPlan());
                }
            }
        }
    }

    private static void processPhysical(Profile profile, String outputFile, Map reflectionMap, Map metrics) throws IOException {
        PlanLine context = PlanUtils.parsePlan(new ByteArrayInputStream(getPlanByName(profile, "Final Physical Transformation").getBytes()));
        PlanAnalyzer analyzer = new PlanAnalyzer(reflectionMap, metrics);
        analyzer.process(context, PrintOption.EVERYTHING(), outputFile);
    }

    private static void analyzeAndWriteOutput(String plan, String outputFile, Map reflectionMap, Map metrics) throws IOException{
        PlanLine context = PlanUtils.parsePlan(new ByteArrayInputStream(plan.getBytes()));
        PlanAnalyzer analyzer = new PlanAnalyzer(reflectionMap, metrics);
        analyzer.process(context, PrintOption.EVERYTHING(), outputFile);
        BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile + ".input"));
        writer.write(plan);
        writer.close();
    }

    private static String getPlanByName(Profile profile, String name){
        List< PlanPhase> phases =  profile.getPlanPhases();
        for (PlanPhase p: phases){
            if (p.getPhaseName().equals(name)){
                return p.getPlan();
            }
        }
        return "";
    }


    private static Map<List<Long>, Map<String, AtomicLong>> getMetrics(Profile profile){
        Map<List<Long>, Map<String, AtomicLong>> metrics = new HashMap();
        List<MetricsDef> metricDefs = profile.getOperatorTypeMetricsMap().getMetricsDef();
        int i = 0;
        logger.info("Metric definitions\n");
        StringBuffer sb = new StringBuffer();
        for (MetricsDef mDefs: metricDefs){
            sb.append("MetricDef #" + i + ": ");
            Iterator<MetricDef> defs = mDefs.getMetricDef().iterator();
            while (defs.hasNext()){
                MetricDef d = defs.next();
                sb.append(d.getName());
                if (defs.hasNext()) sb.append(", ");
            }
            i += 1;
            sb.append("\n");
        }
        logger.info(sb.toString());
        List<FragmentProfile> fragments = profile.getFragmentProfile();
        logger.info("Metric preparation");
        for (FragmentProfile majorFrag: fragments){
            for (MinorFragmentProfile minorFrag: majorFrag.getMinorFragmentProfile()){
                for (OperatorProfile opProf : minorFrag.getOperatorProfile()){
                    List<Long> id = Arrays.asList(majorFrag.getMajorFragmentId(), opProf.getOperatorId());
                    List<MetricDef> mDefs = metricDefs.get((int)opProf.getOperatorType()).getMetricDef();
                    Map<String, AtomicLong> collected = metrics.get(id);
                    if (collected==null){
                        collected = new HashMap<String, AtomicLong>();
                        metrics.put(id, collected);
                    }

                    int profileNum = 0;
                    //Collecting input profile records
                    List<InputProfile> ips = opProf.getInputProfile();
                    for (InputProfile inputProf: ips){
                        String name = "input_record" + profileNum;
                        addMetric(collected, name, inputProf.getRecords());
                        profileNum += 1;
                    }

                    //Collecting processing Nanos
                    addMetric(collected, "processing_nanos", opProf.getProcessNanos());

                    //Collecting metrics
                    sb = new StringBuffer();
                    for (Metric m: opProf.getMetric()){

                        if (m.getMetricId()<mDefs.size()) {
                            MetricDef mDef = mDefs.get((int)m.getMetricId());
                            sb.append(mDef.getName() + " " );
                            if (mDef.getName().contains("RECORD")){
                                logger.fine("Found metric " + mDef.getName());
                                addMetric(collected, mDef.getName().toLowerCase(), m.getLongValue());
                            }

                        } else {
//                            logger.warning("Cannot find metric definition " + m.getMetricId() + " for operator type " + opProf.getOperatorType() );
                        }
                    }
                    logger.fine("Found metrics " + sb.toString() + " on fragment "  + majorFrag.getMajorFragmentId() + " " + minorFrag.getMinorFragmentId() + " " + opProf.getOperatorId());
                }
            }
        }
        return metrics;
    }

    private static void addMetric(Map<String, AtomicLong> metrics, String key, long value){
        AtomicLong currentValue = metrics.get(key);
        if (currentValue==null){
            currentValue = new AtomicLong();
            metrics.put(key, currentValue);
        }
        currentValue.addAndGet(value);
    }

    private static Map<String, ReflectionDefinition> getReflectionIdMap(Profile profile) throws IOException {
        List<LayoutProfile> layoutProfiles = profile.getAccelerationProfile().getLayoutProfiles();
        Map<String, ReflectionDefinition> reflections = new HashMap<String, ReflectionDefinition>();
        StringBuffer sb = new StringBuffer();
        for (LayoutProfile lp: layoutProfiles){
            String layoutId = lp.getLayoutId();
            logger.fine("Checking reflection Id " + layoutId);
            String plan = lp.getPlan();
            String reflectionName = (lp.getPlan().trim().length()==0)? layoutId: getReflectionViewName(lp.getPlan());
            ReflectionDefinition def = new ReflectionDefinition();
            def.reflectionId = layoutId;
            def.materializationId = lp.getMaterializationId();
            String[] splits = reflectionName.split("\\.");
            def.fullName = reflectionName;
            def.viewName = splits[splits.length-1];
            reflections.put(layoutId, def);
            sb.append("Reflection " + layoutId + " = " + def.fullName + "\n");
        }
        logger.info("Reflection definitions");
        logger.info(sb.toString());
        return reflections;
    }

    private static String getReflectionViewName(String planString) throws IOException {
        PlanLine plan = PlanUtils.parsePlan(new ByteArrayInputStream(planString.getBytes()));
        while (!plan.getNode().planName().ID().getText().equals("ExpansionNode")){
            if (plan.getChildren().size()!=1){
                return null;
            } else {
                plan = plan.getChildren().get(0);
            }
        }
        String path = plan.getAttrMap().get("path");
        return path.substring(1, path.length() - 1);
    }
}