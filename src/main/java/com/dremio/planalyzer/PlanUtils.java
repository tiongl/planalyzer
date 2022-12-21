package com.dremio.planalyzer;

import org.antlr.v4.runtime.*;

import java.io.*;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.logging.Logger;

public class PlanUtils {

    public static ExpressionParser.ExprContext parseExpression(String s) throws IOException {
        Lexer lexer = new ExpressionLexer(CharStreams.fromStream(new ByteArrayInputStream(s.getBytes())));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokenStream);
        return parser.expr();
    }

    static Logger logger = java.util.logging.Logger.getLogger(PlanUtils.class.getName());
    public static PlanLine fixHierarchy(List<PlanParser.PlanLineContext> planLines) {
        Stack<PlanLine> stack = new Stack();
        int n = planLines.size();
        PlanLine root = new PlanLine(planLines.get(0));
        stack.push(root);
        int currentLevel = planLines.get(0).PHASE().toString().length();
        PlanPrinter printer = new PlanPrinter();
        for (int i = 1; i<n; i++){
            PlanParser.PlanLineContext line = planLines.get(i);
            PlanLine pl = new PlanLine(line);
            logger.fine("Checking line " + i + " " + line.PHASE().toString().trim() + " " + line.planName().ID());
            int level = line.PHASE().toString().length();
            while (level<=currentLevel){
                stack.pop();
                currentLevel = stack.peek().getNode().PHASE().toString().length();
            }
            logger.fine("Adding " + line.planName().ID() + " into " + stack.peek().getNode().planName().ID() + " depth = " + stack.size());
            stack.peek().getChildren().add(pl);
            stack.push(pl);
            currentLevel = level;
        }
        return root;
    }

    public static PlanLine parsePlan(String fileName) throws IOException {
        PlanParser.ExprContext context = getPlanLine(new FileInputStream(fileName));
        BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
        int rowCount = 0;
        while (input.readLine()!=null){
            rowCount ++;
        }
        if (rowCount!=context.planLine().size()) throw new IllegalStateException("Parsed plan doesn't match the line count (" + rowCount + "!=" + context.planLine().size() + ")");
        return fixHierarchy(context.planLine());
    }

    private static PlanParser.ExprContext getPlanLine(InputStream inputStream) throws IOException {
        Lexer lexer = new PlanLexer(CharStreams.fromStream(inputStream));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        PlanParser parser = new PlanParser(tokenStream);
        return parser.expr();
    }

    public static PlanLine parsePlan(InputStream inputStream) throws IOException {
        PlanParser.ExprContext context = getPlanLine(inputStream);
        return fixHierarchy(context.planLine());
    }

    public static String mkString(Map<String, Object> map){
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry e = entries.next();
            sb.append(e.getKey());
            sb.append("=");
            if (e.getValue() instanceof Map){
                sb.append("{");
                sb.append(mkString(((Map)e.getValue())));
                sb.append("}");
            } else if (e.getValue().getClass().isArray()){
                sb.append("[");
                sb.append(mkString((Object[])e.getValue()));
                sb.append("]");
            } else sb.append(e.getValue());
            if (entries.hasNext()) sb.append(", ");
        }
        return sb.toString();
    }

    public static String mkString(Object[] str){
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i<str.length; i++){
            sb.append(str[i]);
            if (i<str.length-1){
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String[] parseBracketString(String str, String separator){
        String[] results = str.substring(1, str.length()-1).split(separator);
        for (int i = 0; i<results.length; i++){
            results[i] = results[i].trim();
        }
        return results;
    }
}