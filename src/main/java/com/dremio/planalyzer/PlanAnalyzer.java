package com.dremio.planalyzer;

import com.dremio.plananalyzer.ExpressionParser;
import com.dremio.plananalyzer.PlanParser;

import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PlanAnalyzer {
    static Logger logger = java.util.logging.Logger.getLogger(PlanAnalyzer.class.getName());

    private List<AnalyzerRule> rules = new ArrayList<AnalyzerRule>();

    int depth = 0;

    private Map<String, ReflectionDefinition> reflectionMap = new HashMap<String, ReflectionDefinition>();
    private Map<List<Long>, Map<String, Metrics>> metrics;

    public PlanAnalyzer(){
        this(new HashMap<String, ReflectionDefinition>(), new HashMap<List<Long>, Map<String, Metrics>>());
    }

    public PlanAnalyzer(Map<String, ReflectionDefinition> reflectionDefinitionMap, Map<List<Long>, Map<String, Metrics>> metricMap){
        reflectionMap = reflectionDefinitionMap;
        metrics = metricMap;
        rules.add(new ResolveRule("condition", "conditionStr"));
        rules.add(new ExchangeResolveRule());
        rules.add(new JoinAnalysis());
        rules.add(new ProjectAnalyzer());
        rules.add(new TableAnalyzer());
        rules.add(new MetricAnalyzer());
        rules.add(new AggregateRule());
        rules.add(new CopyingRule("SelectionVectorRemover", Collections.singleton("columns")));
        rules.add(new CopyingRule("Filter", Collections.singleton("columns")));
        rules.add(new CopyingRule("Union", Collections.singleton("columns")));
        rules.add(new CopyingRule("Expansion", Collections.singleton("columns")));
        rules.add(new CopyingRule("Expansion", Collections.singleton("columns")));
        rules.add(new CopyingRule("Exchange", Collections.singleton("columns")));
        rules.add(new CopyingRule("Sort", Collections.singleton("columns")));
        rules.add(new CopyingRule("Limit", Collections.singleton("columns")));
        rules.add(new CopyingRule("JdbcCrel", Collections.singleton("columns")));
        rules.add(new CopyingRule("WriterCommitter", Collections.singleton("columns")));
        rules.add(new CopyingRule("WriterPrel", Collections.singleton("columns")));
        rules.add(new CopyingRule("Screen", Collections.singleton("columns")));
        rules.add(new CostAnalyzer());
        rules.add(new MultiJoinAnalyzer());

    }


    public Void process(PlanLine parent, int childIdx, PlanLine planLine, AnalysisOption option) {
        PlanParser.PlanLineContext ctx = planLine.getNode();
        Map newContextMap = new HashMap<String, String>();

        for (int i = 0; i<planLine.getChildren().size(); i++){
            depth += 1;
            logger.fine("Checking child " + planLine.getChildren().get(i).getId() + "(depth=" + depth + ")");
                    process(planLine, childIdx, planLine.getChildren().get(i), option);
            depth -= 1;
        }

        logger.fine("Analyzing " + planLine.getId() + " (depth=" + depth + ")");
        String planName = ctx.planName().ID().toString();
        //some common processing
        Map<String, String> attrMap = planLine.getAttrMap();
        int matches = 0;
        for (AnalyzerRule r: rules){
            if (r.match(planLine, attrMap)){
//                System.out.println("Use rule " + r + " on " + planLine.getId());
                r.process(parent, childIdx , planLine, attrMap, metrics, newContextMap, reflectionMap, option);
                matches += 1;
            }
        }
        if (matches==0){
            logger.info("no analysis rule found on " + planLine.getId());
        } else {
            if (logger.isLoggable(Level.FINE)){
                logger.fine("Returning context with " + planLine.getId() + " " + PlanUtils.mkString(newContextMap));
            }
        }
        Column[] columns = (Column[])newContextMap.get("columns");
        if (columns==null){
            logger.warning("No columns information for " + planLine.getId() + "\n" + planLine.getNode().getText());
        } else {
            for (int i = 0; i<columns.length; i++){
                if (columns[i]==null){
//                    throw new RuntimeException("Found null column information for " + planLine.getId());
                }
            }
        }
        planLine.getInfo().putAll(newContextMap);

        return null;
    }

    public static String resolveVariables(String eqValue, Column[] columns, String planId, boolean withTableName){
        String expressionStr = eqValue;
        String trimmedExpression = expressionStr.substring(1, expressionStr.length() - 1);
        logger.fine("Examining expression " + trimmedExpression + " on " + planId);
        String resolvedExpr = parseAndResolve(trimmedExpression, columns, withTableName);
        logger.fine("Resolved expression " + resolvedExpr);
        return resolvedExpr;
        //TODO: find variables in join
    }

    public static String parseAndResolve(String expressionStr, Column[] columns, boolean printTableName) {
        try {
            ExpressionParser.ExprContext expr = PlanUtils.parseExpression(expressionStr);
            ConditionVariableResolver resolver = new ConditionVariableResolver(columns, printTableName);
            String resolvedExpr = resolver.visitExpr(expr);
            return resolvedExpr;
        } catch (Exception e){
            logger.warning("Cannot fully resolve expression '" + expressionStr + "': " + e.getMessage());
            e.printStackTrace();
            return expressionStr;
        }
    }

    public static void addColumnsToMap(Column[] columns, Map<String, Column> map){
        for (int i = 0; i<columns.length; i++){
            Column c=columns[i];
            if (c!=null) {
                if (map.containsKey(c.getName())) {
                    logger.warning("Found duplicate column " + c.getName());
                }
                map.put(c.getName(), c);
            }
        }
    }
    public static void main(String[] args) throws IOException {
        if (args.length>0){
            PlanLine context = PlanUtils.parsePlan(args[0]);
            PlanAnalyzer analyzer = new PlanAnalyzer();
            String outputFile = null;
            if (args.length>1) {
                outputFile = args[1];
            }
            analyzer.process(context, new AnalysisOption(), outputFile);

        }
    }

    public void process(PlanLine context, AnalysisOption option, String outputFile) throws IOException {
        process(null, 0, context, option);
        PlanPrinter printer = new PlanPrinter(option);
        printer.process(context);
        if (outputFile!=null) {
            logger.info("Writing output " + outputFile);
            new FileOutputStream(outputFile).write(printer.getString().getBytes(StandardCharsets.UTF_8));
        }
    }
}


