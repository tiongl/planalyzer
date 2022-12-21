package com.dremio.planalyzer;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.logging.Logger;

public class PlanAnalyzer {
    Logger logger = java.util.logging.Logger.getLogger(PlanAnalyzer.class.getName());
    int depth = 0;


    public Void process(PlanLine planLine) {
        PlanParser.PlanLineContext ctx = planLine.getNode();
        PlanParser.EqListContext list = ctx.planName().eqList();
        String[] tableName = null;
        String[] columnName = null;
        Map newContextMap = new HashMap<String, String>();

        for (int i = 0; i<planLine.getChildren().size(); i++){
            depth += 1;
            logger.fine("Checking child " + planLine.getChildren().get(i).getId() + "(depth=" + depth + ")");
                    process(planLine.getChildren().get(i));
            depth -= 1;
        }
        if (list!=null) {
            logger.info("Analyzing " + planLine.getId() + " (depth=" + depth + ")");
            String planName = ctx.planName().ID().toString();
            if (planName.equals("HashJoin") || planName.equals("NestedLoopJoin")) {
                Column[] leftColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
                Column[] rightColumns = (Column[]) planLine.getChildren().get(1).getInfo().get("columns");
                if (rightColumns == null) {
                    logger.warning("Not columns from right upstream " + planLine.getChildren().get(0).getId());
                } else if (leftColumns == null) {
                    logger.warning("Not columns from left upstream " + planLine.getChildren().get(1).getId());
                } else {
                    Map<String, Column> allKnownColumns = new HashMap();
                    addColumnsToMap(leftColumns, allKnownColumns);
                    addColumnsToMap(rightColumns, allKnownColumns);

                    List<PlanParser.TypePairContext> columns = planLine.getNode().rowType().recordType().typeList().typePair();
                    Column[] newColumns = new Column[columns.size()];
                    for (int i = 0; i < columns.size(); i++) {
                        String name = columns.get(i).typeID().getText();
                        if (!allKnownColumns.containsKey(name)) {
                            logger.warning("Cannot find column '" + name + "' in " + planLine.getId());
                        } else {
                            newColumns[i] = allKnownColumns.get(name);
                        }
                    }
                    Map<String, PlanParser.EqValueContext> eqPairMap = getMap(list.eqPair());
                    PlanParser.EqValueContext condition = eqPairMap.get("condition");
                    String conditionStr = condition.BRACKET_STUFF().toString();
                    try {
                        String trimmedCondition = conditionStr.substring(1, conditionStr.length() - 1);
                        logger.info("Examining condition " + trimmedCondition + " on " + planLine.getId());
                        String resolvedCond = resolveCondition(trimmedCondition, newColumns);
                        logger.info("Resolved condition of " + conditionStr + " = " + resolvedCond);
                        newContextMap.put("conditionStr", resolvedCond);
                        //TODO: find variables in join
                    } catch (IOException e) {
                        throw new RuntimeException("Unable to parse condition " + conditionStr, e);
                    }
                    newContextMap.put("columns", newColumns);
                }
            } else if (planName.equals("Project")) {
                logger.info("Analyze projection");
                Column[] sourceColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
                Column[] newColumns = new Column[list.eqPair().size()];
                for (int i = 0; i < list.eqPair().size(); i++) {
                    String name = getEqId(list.eqPair(i));
                    String[] values = PlanUtils.parseBracketString(list.eqPair(i).eqValue().BRACKET_STUFF().toString(), ",");
                    if (values[0].startsWith("$")) {
                        int num = Integer.parseInt(values[0].substring(1));
                        if (num < sourceColumns.length) {
                            newColumns[i] = new Column(name, sourceColumns[num]);
                        } else {

                            logger.warning("Unable to resolve column " + values[0] + " in " + planLine.getId());
                        }
                    } else {
                        //complicate expression
                        String str = list.eqPair(i).eqValue().BRACKET_STUFF().toString();
                        String trimmed = str.substring(1, str.length() - 1);
                        try {
                            logger.info("Resolving projected column " + trimmed);
                            String resolvedColumns = resolveCondition(trimmed, sourceColumns);
                            if (resolvedColumns.length()>=trimmed.length()){
                                logger.info("Resolved projected column " + resolvedColumns);
                                newColumns[i] = new Column(name, new Column(resolvedColumns, null));
                            } else {
                                logger.warning("Fail to resolve projected column " + resolvedColumns);
                                newColumns[i] = new Column(name, new Column(values[0], null));
                            }
                        } catch (IOException e){
                            throw new RuntimeException("Unable to resolve columns");
                        }
                    }
                }
                newContextMap.put("columns", newColumns);
            } else if (planName.equals("Filter")){
                logger.info("Analyze filter");
                Column[] sourceColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
                Map<String, PlanParser.EqValueContext> eqPairMap =  getMap(list.eqPair());
                PlanParser.EqValueContext value = eqPairMap.get("condition");
                String conditionStr = value.BRACKET_STUFF().toString();
                String trimmedCondition = conditionStr.substring(1, conditionStr.length() - 1);
                try {
                    logger.info("Examining condition " + trimmedCondition + " on " + planLine.getId());
                    String resolvedCond = resolveCondition(trimmedCondition, sourceColumns);
                    logger.info("Resolved condition of " + conditionStr + " = " + resolvedCond);
                    newContextMap.put("conditionStr", resolvedCond);
                } catch (IOException e){
                    throw new RuntimeException("Unable to parse filter " + conditionStr, e);
                }
            } else { //maybe its plan1.txt table
                logger.info("Maybe its table");
                Map<String, PlanParser.EqValueContext> eqPairMap =  getMap(list.eqPair());
                String tbName = null;
                if (eqPairMap.containsKey("filters")){ //this must be first, the table analysis depends on it
                    String condition = eqPairMap.get("filters").BRACKET_STUFF().toString();
                    newContextMap.put("filters", condition);
                }
                if (eqPairMap.containsKey("table")) {
                    tableName = PlanUtils.parseBracketString(eqPairMap.get("table").BRACKET_STUFF().toString(),
                            "\\.");
                    newContextMap.put("table", tableName);
                    boolean isReflectionTable = tableName[0].indexOf("__accelerator")!=-1;
                    if (isReflectionTable){
                        tbName = "ref-" + tableName[1].split("-")[0].replaceAll("\"", "");
                        if (newContextMap.containsKey("filters")){
                            tbName = "ref-" + newContextMap.get("filters").hashCode();
                        }
                    } else {
                        tbName = tableName[tableName.length-1];
                    }
                    newContextMap.put("tableName", tbName);
                }
                if (eqPairMap.containsKey("columns") && tableName!=null) {
                    columnName = PlanUtils.parseBracketString(eqPairMap.get("columns").BRACKET_STUFF().toString(), ",");
                    Column[] columns = new Column[columnName.length];
                    boolean addTablePrefix = true;
                    for (int j = 0; j < columnName.length; j++) {
                        columns[j] = (addTablePrefix)? new Column(tbName + "." + columnName[j], null): new Column(columnName[j], null);
                    }
                    newContextMap.put("columns", columns);
                }
                if (eqPairMap.containsKey("condition")){
                    String condition = eqPairMap.get("condition").BRACKET_STUFF().toString();
                    newContextMap.put("condition", condition);
                }

                if (eqPairMap.containsKey("Values")){
                    columnName = PlanUtils.parseBracketString(eqPairMap.get("Values").BRACKET_STUFF().toString(), ",");
                    Column[] columns = new Column[columnName.length];
                    for (int j = 0; j < columnName.length; j++) {
                        columns[j] = new Column(columnName[j], null);
                    }
                    newContextMap.put("columns", columns);
                }
            }
        }
        if (planLine.getChildren().size()==1 || planLine.getNode().planName().ID().getText().equals("UnionAll")){
          //always copy in this case
          planLine.getInfo().putAll(planLine.getChildren().get(0).getInfo());
        }
        planLine.getInfo().putAll(newContextMap);
        logger.info("Returning context with " + planLine.getId() + " " + PlanUtils.mkString(planLine.getInfo()));
        return null;
    }

    public String resolveCondition(String conditionStr, Column[] columns) throws IOException {
        ExpressionParser.ExprContext cond = PlanUtils.parseCondition(conditionStr);
        ConditionVariableResolver resolver = new ConditionVariableResolver(columns);
        String resolvedCond = resolver.visitExpr(cond);
        return resolvedCond;
    }

    class Column{
        private String name;
        private Column source;

        Column(String name, Column source){
            this.name = name;
            this.source = source;
        }

        public Column root(){
            if (source==null){
                return this;
            } else {
                return source.root();
            }
        }

        public String getName() {
            return name;
        }

        @Override
        public String toString() {
            return name;
        }
    }


    private String mkString(PlanParser.EqIDContext ctx){
        StringBuffer sb = new StringBuffer();
        int n = ctx.getChildCount();
        for (int i = 0; i< n; i++){
            sb.append(ctx.getChild(i).toString());
        }
        return sb.toString();
    }


    private Map<String, PlanParser.EqValueContext> getMap(List<PlanParser.EqPairContext> pairs){
        Map<String, PlanParser.EqValueContext> m = new HashMap<>();
        for (int i = 0; i < pairs.size(); i++) {
            PlanParser.EqPairContext pair = pairs.get(i);
            String name = getEqId(pair);
            m.put(name, pair.eqValue());
        }
        return m;
    }

    private void addColumnsToMap(Column[] columns, Map<String, Column> map){
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

    private String getEqId(PlanParser.EqPairContext pair) {
        String name = mkString(pair.eqID());
        if (pair.children.size()==2){
            if (!name.endsWith("=")) throw new IllegalStateException("Expecting '=' in name but get '" + name + "'");
            return name.substring(0, name.length()-1);
        } else {
            return name;
        }
    }

    public static void main(String[] args) throws IOException {
        if (args.length>0){
            PlanLine context = PlanUtils.parsePlan(new FileInputStream(args[0]));
            PlanAnalyzer analyzer = new PlanAnalyzer();
            analyzer.process(context);
            PrintOption options = PrintOption.JOIN_ANALYSIS();
            PlanPrinter printer = new PlanPrinter(options);
            printer.process(context);
            System.out.println(printer.getString());
            if (args.length>1) {
                new FileOutputStream(args[1]).write(printer.getString().getBytes(StandardCharsets.UTF_8));
            }
        }
    }
}


