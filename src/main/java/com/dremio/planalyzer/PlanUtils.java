package com.dremio.planalyzer;

import com.dremio.plananalyzer.ExpressionLexer;
import com.dremio.plananalyzer.ExpressionParser;
import com.dremio.plananalyzer.PlanLexer;
import com.dremio.plananalyzer.PlanParser;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;

import java.io.*;
import java.util.*;
import java.util.logging.Logger;

public class PlanUtils {

    public static ExpressionParser.ExprContext parseExpression(final String s) throws IOException {
        ANTLRErrorListener errListener = new BaseErrorListener(){
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
//                if (strict)
                    throw new RuntimeException("Cannot parse " + s + ":" + e.getMessage());
            }
        };

        Lexer lexer = new ExpressionLexer(CharStreams.fromStream(new ByteArrayInputStream(s.getBytes())));
        TokenStream tokenStream = new CommonTokenStream(lexer);
        ExpressionParser parser = new ExpressionParser(tokenStream);
        lexer.addErrorListener(errListener);
        parser.addErrorListener(errListener);
        return parser.expr();
    }

    static Logger logger = java.util.logging.Logger.getLogger(PlanUtils.class.getName());
    public static PlanLine fixHierarchy(List<PlanParser.PlanLineContext> planLines) {
        Stack<PlanLine> stack = new Stack();
        int n = planLines.size();
        PlanLine root = new PlanLine(planLines.get(0));
        stack.push(root);
        int currentLevel = planLines.get(0).planName().ID().getSymbol().getCharPositionInLine(); //TODO: see if we need adjustment with phase name
        PlanPrinter printer = new PlanPrinter();
        for (int i = 1; i<n; i++){
            PlanParser.PlanLineContext line = planLines.get(i);
            PlanLine pl = new PlanLine(line);
            logger.fine("Checking line " + i + " " + line.PHASE() + " " + line.planName().ID());
            int level = line.planName().ID().getSymbol().getCharPositionInLine();
            while (level<=currentLevel){
                stack.pop();
                currentLevel = stack.peek().getNode().planName().ID().getSymbol().getCharPositionInLine();
            }
            logger.fine("Adding " + line.planName().ID() + " into " + stack.peek().getNode().planName().ID() + " depth = " + stack.size());
            stack.peek().getChildren().add(pl);
            stack.push(pl);
            currentLevel = level;
        }
        return root;
    }

    public static PlanLine parsePlan(String fileName) throws IOException {
        try {
            PlanParser.ExprContext context = getPlanLine(new FileInputStream(fileName), true);
            BufferedReader input = new BufferedReader(new InputStreamReader(new FileInputStream(fileName)));
            int rowCount = 0;
            while (input.readLine() != null) {
                rowCount++;
            }
            if (rowCount != context.planLine().size())
                throw new IllegalStateException("Parsed plan doesn't match the line count (" + rowCount + "!=" + context.planLine().size() + ")");
            return fixHierarchy(context.planLine());
        } catch (Exception e){
            logger.severe("Error parsing " + fileName + ": " + e.getMessage());
            throw e;
        }
    }

    private static PlanParser.ExprContext getPlanLine(InputStream inputStream, final boolean strict) throws IOException {
        ANTLRErrorListener errListener = new BaseErrorListener(){
            @Override
            public void syntaxError(Recognizer<?, ?> recognizer, Object offendingSymbol, int line, int charPositionInLine, String msg, RecognitionException e) {
                if (strict) throw new RuntimeException(e);
            }
        };
        Lexer lexer = new PlanLexer(CharStreams.fromStream(inputStream));
        lexer.addErrorListener(errListener);
        TokenStream tokenStream = new CommonTokenStream(lexer);
        PlanParser parser = new PlanParser(tokenStream);
        parser.addErrorListener(errListener);
        return parser.expr();
    }

    public static PlanLine parsePlan(InputStream inputStream) throws IOException {
        return parsePlan(inputStream, true);
    }

    public static PlanLine parsePlan(InputStream inputStream, boolean strict) throws IOException {
        PlanParser.ExprContext context = getPlanLine(inputStream, strict);
        return fixHierarchy(context.planLine());
    }

    public static String mkString(Map<String, Object> map, Set<String> excludes){
        StringBuffer sb = new StringBuffer();
        Iterator<Map.Entry<String, Object>> entries = map.entrySet().iterator();
        while (entries.hasNext()){
            Map.Entry e = entries.next();
            if (!excludes.contains(e.getKey())) {
                sb.append(e.getKey());
                sb.append("=");
                if (e.getValue() instanceof Map) {
                    sb.append("{");
                    sb.append(mkString(((Map) e.getValue())));
                    sb.append("}");
                } else if (e.getValue().getClass().isArray()) {
                    sb.append("[");
                    sb.append(mkString((Object[]) e.getValue()));
                    sb.append("]");
                } else sb.append(e.getValue());
                if (entries.hasNext()) sb.append(", ");
            }
        }
        return sb.toString();
    }

    public static String mkString(Map<String, Object> map){
        return mkString(map, Collections.EMPTY_SET);
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