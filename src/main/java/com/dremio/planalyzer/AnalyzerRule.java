package com.dremio.planalyzer;

import com.dremio.plananalyzer.ExpressionParser;
import com.dremio.plananalyzer.PlanParser;
import com.dremio.plananalyzer.ProjectFieldLexer;
import com.dremio.plananalyzer.ProjectFieldParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface AnalyzerRule {
    public boolean match(PlanLine line, Map<String, String> attrMap);

    public void process(PlanLine line, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap);
}

class ResolveRule implements AnalyzerRule {
    Logger logger = java.util.logging.Logger.getLogger(ResolveRule.class.getName());

    private String inputAttr;
    private String outputAttr;

    public ResolveRule(String inputAttr, String outAttr) {
        this.inputAttr = inputAttr;
        this.outputAttr = outAttr;
    }

    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        return attrMap.containsKey(inputAttr) && line.getChildren().size() == 1;
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
       Column[] sourceColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
        if (sourceColumns != null) {
            String condition = attrMap.get(inputAttr);
            String resolvedCond = PlanAnalyzer.resolveVariables(condition, sourceColumns, planLine.getId(), true);
            newContextMap.put(outputAttr, resolvedCond);
        } else {
            logger.warning("Cannot find source columns from upstream of " + planLine.getId() + ", " + planLine.getChildren().get(0).getId());
        }
    }

}

class JoinAnalysis implements AnalyzerRule {
    static Logger logger = java.util.logging.Logger.getLogger(JoinAnalysis.class.getName());

    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        String planName = line.getPlanName();
        return planName.indexOf("Join") != -1 && !planName.equals("MultiJoin");
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
        Column[] leftColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
        Column[] rightColumns = (Column[]) planLine.getChildren().get(1).getInfo().get("columns");
        if (rightColumns == null) {
            logger.warning("No columns info from right upstream " + planLine.getChildren().get(0).getId());
        } else if (leftColumns == null) {
            logger.warning("No columns info from left upstream " + planLine.getChildren().get(1).getId());
        } else {
            Column[] newColumns = null;
            if (planLine.getNode().rowType()!=null && leftColumns.length + rightColumns.length != planLine.getNode().rowType().recordType().typeList().typePair().size()){
                throw new IllegalStateException("Left + Right != projected in join");
            }
            newColumns = new Column[leftColumns.length + rightColumns.length];
            System.arraycopy(leftColumns, 0, newColumns, 0, leftColumns.length);
            System.arraycopy(rightColumns, 0, newColumns, leftColumns.length, rightColumns.length);

            newContextMap.put("columns", newColumns);
            String condition = attrMap.get("condition");
            String resolvedCond = PlanAnalyzer.resolveVariables(condition, newColumns, planLine.getId(), true);
            newContextMap.put("conditionStr", resolvedCond);
        }

    }
}

class ProjectAnalyzer implements AnalyzerRule {
    static Logger logger = java.util.logging.Logger.getLogger(ProjectAnalyzer.class.getName());

    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        String planName = line.getPlanName();
        return planName.indexOf("Project")!=-1;
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
        Column[] sourceColumns = (Column[]) planLine.getChildren().get(0).getInfo().get("columns");
        Column[] newColumns = new Column[attrMap.size()];
        StringBuffer projectionStr = new StringBuffer();
        int i = 0;
        if (sourceColumns != null) {
            for (Map.Entry<String, String> entry : attrMap.entrySet()) {
                String name = entry.getKey();
                String[] values = PlanUtils.parseBracketString(entry.getValue(), ",");
                if (values[0].startsWith("$")) {
                    int num = Integer.parseInt(values[0].substring(1));
                    if (num < sourceColumns.length && sourceColumns[num]!=null) {
                        newColumns[i] = new Column(name, sourceColumns[num]);
                        if (!name.equals(sourceColumns[num].getName().replaceAll("`", ""))) {
                            if (projectionStr.length() > 0) {
                                projectionStr.append(", ");
                            }
                            projectionStr.append(name + "=" + sourceColumns[num].getName(true));
                        }
                    } else {
                        logger.warning("Unable to resolve column " + values[0] + " in " + planLine.getId());
                    }
                } else {
                    //complicate expression
                    String resolvedExpression = PlanAnalyzer.resolveVariables(entry.getValue(), sourceColumns, planLine.getId(), true);
                    String resolvedExpressionTableless = PlanAnalyzer.resolveVariables(entry.getValue(), sourceColumns, planLine.getId(), false);
                    String newName = name + "_" + Math.abs(resolvedExpressionTableless.hashCode());
                    newColumns[i] = new Column(name, new Column(newName, null, resolvedExpression));
                    if (projectionStr.length() > 0) {
                        projectionStr.append(", ");
                    }
                    projectionStr.append(newName + "=" + resolvedExpression);
                }
                i += 1;
            }
            if (projectionStr.length() > 0) newContextMap.put("projectionStr", projectionStr.toString());
            newContextMap.put("columns", newColumns);
        } else {
            logger.warning("Cannot find source columns from upstream of " + planLine.getId() + ", " + planLine.getChildren().get(0).getId());
        }
    }
}

class TableAnalyzer implements AnalyzerRule {
    static Logger logger = java.util.logging.Logger.getLogger(TableAnalyzer.class.getName());

    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        String planName = line.getPlanName();
        return planName.indexOf("Scan")!=-1 || planName.indexOf("Values")!=-1 || planName.equals("BridgeReader") ||
                planName.equals("TableFunction") || planName.equals("BridgeReader") ||
                planName.indexOf("IcebergManifest")!=-1 || planName.indexOf("Empty") != -1 || planName.equals("Writer");
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>,
            Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap,
                        Map<String, ReflectionDefinition> reflectionMap) {
        String planName = planLine.getPlanName();
        String[] tableName = null;
        String tbName = null;
        if (attrMap.containsKey("filters")) { //this must be first, the table analysis depends on it
            String condition = attrMap.get("filters");
            newContextMap.put("filters", condition);
        }

        //resolve the table name so we can use it for column definitions
        if (attrMap.containsKey("table")) {
            tableName = PlanUtils.parseBracketString(attrMap.get("table"),
                    "\\.");
            newContextMap.put("table", tableName);
            boolean isReflectionTable = tableName[0].indexOf("__accelerator") != -1;
            if (isReflectionTable) {//resolve table name
                tbName = tableName[1].replaceAll("\"", "");
                if (reflectionMap.containsKey(tbName)) {
                    tbName = reflectionMap.get(tbName).viewName;
                } else {
                    logger.warning("Cannot find reflection definition for " + tbName);
                }
                if (newContextMap.containsKey("filters")) {
                    tbName = tbName + "-filter-" + newContextMap.get("filters").hashCode();
                }
            } else {
                tbName = tableName[tableName.length - 1];
            }
            newContextMap.put("tableName", tbName);
        }
        if (planName.equals("BridgeReader")) {
            tbName = attrMap.get("bridgeSetId");
        }

        //resolve the columns
        if (attrMap.containsKey("columns")) {
            String[] columnNames = PlanUtils.parseBracketString((String) attrMap.get("columns"), ",");
            Column[] columns = new Column[columnNames.length];
            for (int j = 0; j < columnNames.length; j++) {
                columns[j] = new Column(columnNames[j], null, null, tbName);
            }
            newContextMap.put("columns", columns);
        } else if (attrMap.containsKey("Values")) {
            String[] columnName = PlanUtils.parseBracketString(attrMap.get("Values"), ",");
            Column[] columns = new Column[columnName.length];
            for (int j = 0; j < columnName.length; j++) {
                columns[j] = new Column(columnName[j], null);
            }
            newContextMap.put("columns", columns);
        } else if (attrMap.containsKey("tuples")) {
            String[] columnName = PlanUtils.parseBracketString(attrMap.get("tuples"), ",");
            Column[] columns = new Column[columnName.length];
            for (int j = 0; j < columnName.length; j++) {
                columns[j] = new Column(columnName[j], null);
            }
            newContextMap.put("columns", columns);
        } else if (planLine.getNode().rowType()!=null){
            List<PlanParser.TypePairContext> types = planLine.getNode().rowType().recordType().typeList().typePair();
            Column[] columns = new Column[types.size()];
            for (int j = 0; j < types.size(); j++) {
                columns[j] = new Column(types.get(j).typeID().getText(), null, null, tbName);
            }
            newContextMap.put("columns", columns);
        } else {
            logger.warning("Unable to resolve column from source " + planLine.getId());
        }
    }
}

class MetricAnalyzer implements AnalyzerRule {
    static Logger logger = java.util.logging.Logger.getLogger(MetricAnalyzer.class.getName());

    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        return line.getNode().PHASE() != null;
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics,
                        Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
        String[] strIds = planLine.getNode().PHASE().getText().split("-");
        Long[] ids = {Long.parseLong(strIds[0]), Long.parseLong(strIds[1])};
        Map<String, ProfileAnalyzer.Metrics> metric = metrics.get(Arrays.asList(ids));
        if (metric != null && metric.size() > 0) {
            if (logger.isLoggable(Level.FINE)){
                logger.fine("Found metrics for " + planLine.getId() + " " + PlanUtils.mkString(metric.entrySet().toArray()));
            }
            newContextMap.put("metric", metric);
            if (metric.containsKey("input_record1") && metric.containsKey("output_records")) {//a join
                long input0 = metric.get("input_record0").sum();
                long input1 = metric.get("input_record1").sum();
                long output = metric.get("output_records").sum();
                double input = Math.max(input0, input1);
                if (input == 0) {
                    newContextMap.put("JoinRatio", 0);
                } else {
                    newContextMap.put("JoinRatio", output / input);
                }
            }
        }

    }
}

class CopyingRule implements AnalyzerRule {

    private String name;
    private Set<String> keys;

    public CopyingRule(String name, Set<String> keys){
        this.name = name;
        this.keys  = keys;
    }

    @Override
    public boolean match(PlanLine planLine, Map<String, String> attrMap) {
        return planLine.getPlanName().indexOf(name)!=-1;
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>,
            Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String,
            ReflectionDefinition> reflectionDefinitionMap) {
        Map<String, Object> childInfo = planLine.getChildren().get(0).getInfo();
        for (Map.Entry<String, Object> entry: childInfo.entrySet()){
            if (keys.size()==0 || keys.contains(entry.getKey())) {
                newContextMap.put(entry.getKey(), entry.getValue());
            }
        }
    }
}


class MultiJoinAnalyzer implements AnalyzerRule {
    static Logger logger = java.util.logging.Logger.getLogger(MultiJoinAnalyzer.class.getName());
    public MultiJoinAnalyzer(){
    }

    @Override
    public boolean match(PlanLine planLine, Map<String, String> attrMap) {
        return planLine.getPlanName().equals("MultiJoin");
    }

    @Override
    public void process(PlanLine planLine, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
        try {
            List<int[]> projectFields = parseProjectionFields(attrMap.get("projFields"));
            ArrayList<Column> outColumns = new ArrayList<Column>();
            for (int i = 0; i<projectFields.size(); i++){
                Column[] columns = (Column[])planLine.getChildren().get(i).getInfo().get("columns");
                if (columns==null){
                    logger.warning("Cannot find source column from " + planLine.getChildren().get(i).getId() + ", skip multijoin analysis");
                    return;
                }
                for (int fieldNum: projectFields.get(i)){
                    outColumns.add(columns[fieldNum]);
                }
            }
            Column[] outColumnsArray = outColumns.toArray(new Column[0]);

            //all columns
            ArrayList<Column> columns = new ArrayList<Column>();
            for (PlanLine c: planLine.getChildren()){
                Column[] childCols = (Column[])c.getInfo().get("columns");
                columns.addAll(Arrays.asList(childCols));
            }
            Column[] columnsArray = columns.toArray(new Column[0]);
            newContextMap.put("columns", columnsArray);

            assert(projectFields.size()==planLine.getChildren().size());
            //joinFilter processing
            String joinFilter = attrMap.get("joinFilter");
            ExpressionParser.ExpressionContext expr = PlanUtils.parseExpression(joinFilter).expression();

            for (int i = 0; i< expr.expression().size(); i++){
                ConditionVariableResolver resolver = new ConditionVariableResolver(columnsArray, true);
                String str = resolver.visitExpression(expr.expression(i));
                newContextMap.put("joinFilter" + i, str);
            }
        } catch (Exception e){
            logger.warning("Cannot parse joinFilter " + attrMap.get("joinFilter") + ": "  + e.getMessage());
        }
    }

    public List<int[]> parseProjectionFields(String fields) throws IOException {
        fields = fields.substring(1, fields.length() - 1); //remove the extra brackets
        ProjectFieldLexer lexer = new ProjectFieldLexer(CharStreams.fromStream(new ByteArrayInputStream(fields.getBytes())));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ProjectFieldParser parser = new ProjectFieldParser(tokenStream);
        ProjectFieldParser.FieldsetsContext fieldSets = parser.expr().fieldsets();
        ArrayList<int[]> results = new ArrayList<int[]>();
        for (ProjectFieldParser.FieldsetContext set: fieldSets.fieldset()){
            int[] numbers = new int[set.NUMBER().size()];
            for (int i = 0; i < numbers.length; i++){
                numbers[i] = Integer.parseInt(set.NUMBER(i).getText());
            }
            results.add(numbers);
        }
        return results;
    }
}

class AggregateRule implements AnalyzerRule{
    static Logger logger = java.util.logging.Logger.getLogger(AggregateRule.class.getName());
    @Override
    public boolean match(PlanLine line, Map<String, String> attrMap) {
        return line.getPlanName().indexOf("Agg") != -1;
    }

    @Override
    public void process(PlanLine line, Map<String, String> attrMap, Map<List<Long>, Map<String, ProfileAnalyzer.Metrics>> metrics, Map newContextMap, Map<String, ReflectionDefinition> reflectionDefinitionMap) {
        PlanLine child = line.getChild(0);

        Column[] sourceColumns = (Column[])child.getInfo().get("columns");
        Iterator<Map.Entry<String, String>> entries = attrMap.entrySet().iterator();
        Map.Entry<String, String> groupEntry = entries.next();
        assert(groupEntry.getKey().equals("group"));
        String groupStr = groupEntry.getValue(); //example: group=[{0}]
        if (groupStr!=null) {
            String[] groups = groupStr.substring(2, groupStr.length() - 2).split(",");
            ArrayList<Column> cols = new ArrayList<Column>();
            for (int i = 0; i < groups.length; i++) {
                if (groups[i].trim().length()==0) break;
                int idx = Integer.parseInt(groups[i].trim());
                cols.add(sourceColumns[idx]);
            }

            while (entries.hasNext()){
                Map.Entry<String, String> e = entries.next();
                String key = e.getKey();
                String value = e.getValue();
                String expr = PlanAnalyzer.parseAndResolve(value.substring(1, value.length()-1), sourceColumns, true);
                cols.add(new Column(key, null, expr));
            }
            newContextMap.put("columns", cols.toArray(new Column[0]));
        } else {
            logger.warning("Cannot find 'group' attribute for " + line.getId());
        }


    }
}