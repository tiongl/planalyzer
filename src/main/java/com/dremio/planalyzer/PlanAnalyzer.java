package com.dremio.planalyzer;

import com.dremio.plananalyzer.ExpressionParser;
import com.dremio.plananalyzer.PlanParser;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

public class PlanAnalyzer {
    static Logger logger = java.util.logging.Logger.getLogger(PlanAnalyzer.class.getName());

    private List<AnalyzerRule> rules = new ArrayList<AnalyzerRule>();

    int depth = 0;

    private Map<String, ReflectionDefinition> reflectionMap = new HashMap<String, ReflectionDefinition>();
    private Map<List<Long>, Map<String, AtomicLong>> metrics;

    public PlanAnalyzer(){
        this(new HashMap<String, ReflectionDefinition>(), new HashMap<List<Long>, Map<String, AtomicLong>>());
    }

    public PlanAnalyzer(Map<String, ReflectionDefinition> reflectionDefinitionMap, Map<List<Long>, Map<String, AtomicLong>> metricMap){
        reflectionMap = reflectionDefinitionMap;
        metrics = metricMap;
        rules.add(new ResolveRule("condition", "conditionStr"));
        rules.add(new ResolveRule("dist0", "dist"));
        rules.add(new JoinAnalysis());
        rules.add(new ProjectAnalyzer());
        rules.add(new TableAnalyzer());
        rules.add(new MetricAnalyzer());
        rules.add(new CopyingRule("SelectionVectorRemover", Collections.singleton("columns")));
        rules.add(new CopyingRule("Agg", Collections.singleton("columns")));
        rules.add(new CopyingRule("Filter", Collections.singleton("columns")));
        rules.add(new CopyingRule("Union", Collections.singleton("columns")));
        rules.add(new CopyingRule("Expansion", Collections.singleton("columns")));
        rules.add(new CopyingRule("Exchange", Collections.singleton("columns")));
        rules.add(new MultiJoinAnalyzer());

    }


    public Void process(PlanLine planLine) {
        PlanParser.PlanLineContext ctx = planLine.getNode();
        Map newContextMap = new HashMap<String, String>();

        for (int i = 0; i<planLine.getChildren().size(); i++){
            depth += 1;
            logger.fine("Checking child " + planLine.getChildren().get(i).getId() + "(depth=" + depth + ")");
                    process(planLine.getChildren().get(i));
            depth -= 1;
        }

        logger.fine("Analyzing " + planLine.getId() + " (depth=" + depth + ")");
        String planName = ctx.planName().ID().toString();
        //some common processing
        Map<String, String> attrMap = planLine.getAttrMap();
        int matches = 0;
        for (AnalyzerRule r: rules){
            if (r.match(planLine, attrMap)){
                r.process(planLine, attrMap, metrics, newContextMap, reflectionMap);
                matches += 1;
            }
        }
        if (matches==0){
            logger.info("no analysis rule found on " + planLine.getId());
        } else {
            logger.fine("Returning context with " + planLine.getId() + " " + PlanUtils.mkString(planLine.getInfo()));
        }
        planLine.getInfo().putAll(newContextMap);

        return null;
    }

    public static String resolveVariables(String eqValue, Column[] columns, String planId, boolean withTableName){
        String expressionStr = eqValue;
        try {
            String trimmedExpression = expressionStr.substring(1, expressionStr.length() - 1);
            logger.fine("Examining expression " + trimmedExpression + " on " + planId);
            String resolvedExpr = parseAndResolve(trimmedExpression, columns, withTableName);
            logger.fine("Resolved expression " + resolvedExpr);
            return resolvedExpr;
            //TODO: find variables in join
        } catch (IOException e) {
            throw new RuntimeException("Unable to parse expression " + expressionStr, e);
        }
    }

    public static String parseAndResolve(String expressionStr, Column[] columns, boolean printTableName) throws IOException {
        ExpressionParser.ExprContext expr = PlanUtils.parseExpression(expressionStr);
        ConditionVariableResolver resolver = new ConditionVariableResolver(columns, printTableName);
        String resolvedExpr = resolver.visitExpr(expr);
        if (resolvedExpr.length()<expressionStr.length()){
            logger.warning("Cannot fully resolve expression " + expressionStr + ". Parse error maybe");
            return expressionStr;
        } else {
            return resolvedExpr;
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
            PlanLine context = PlanUtils.parsePlan(new FileInputStream(args[0]));
            PlanAnalyzer analyzer = new PlanAnalyzer();
            String outputFile = null;
            if (args.length>1) {
                outputFile = args[1];
            }
            analyzer.process(context, PrintOption.JOIN_ANALYSIS(), outputFile);

        }
    }

    public void process(PlanLine context, PrintOption printOptions, String outputFile) throws IOException {
        process(context);
        PlanPrinter printer = new PlanPrinter(printOptions);
        printer.process(context);
        System.out.println(printer.getString());
        if (outputFile!=null) {
            new FileOutputStream(outputFile).write(printer.getString().getBytes(StandardCharsets.UTF_8));
        }
    }
}


