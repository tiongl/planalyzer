package com.dremio.planalyzer;


import com.dremio.plananalyzer.PlanBaseVisitor;
import com.dremio.plananalyzer.PlanParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Map;

import static com.dremio.plananalyzer.ExpressionLexer.COMMA;
import static com.dremio.plananalyzer.PlanLexer.PHASE;

public class PlanPrinter {


    PrintOption options = new PrintOption();
    private class Printer extends PlanBaseVisitor<Void> {

        @Override
        public Void visitCharacterset(PlanParser.CharactersetContext ctx) {
            if (options.showCharacterSet) {
                return super.visitCharacterset(ctx);
            } else {
                return null;
            }
        }

        @Override
        public Void visitEqList(PlanParser.EqListContext ctx) {
            if (options.showEqList) {
                return super.visitEqList(ctx);
            } else {
                return null;
            }
        }

        @Override
        public Void visitRowType(PlanParser.RowTypeContext ctx) {
            if (options.showRowType) {
                return super.visitRowType(ctx);
            } else {
                return null;
            }
        }

        @Override
        public Void visitCostList(PlanParser.CostListContext ctx) {
            if (options.showCost){
                return super.visitCostList(ctx);
            } else {
                return null;
            }
        }

        @Override
        public Void visitTerminal(TerminalNode node) {
            int type = node.getSymbol().getType();
            if (type!=PHASE){
                sb.append(node.getText());
            }
            if (type==COMMA){
                sb.append(" ");
            }
            return super.visitTerminal(node);
        }
    }

    private Printer p = new Printer();
    private StringBuffer output = new StringBuffer();
    private StringBuffer sb = new StringBuffer();

    private int depth = 0;

    public PlanPrinter(){
    }

    public void flush(){
        output.append(sb);
        sb.delete(0, sb.length());
    }

    public void clear(){
        sb.delete(0, sb.length());
    }

    public PlanPrinter(PrintOption options){
        this.options = options;
    }

    public void process(PlanLine planLine){
        boolean showing = true;

        if (showing) {
            String indent = getIndent(depth, planLine.getNode().PHASE()==null? "": planLine.getNode().PHASE().getText());
            String[] keys = new String[0]; //lineOpts==null? new String[0]: lineOpts.attrsToPrint;
            sb.append(indent);
            planLine.getNode().accept(p);

            for (Map.Entry<String, Object> entry: planLine.getInfo().entrySet()) {
                String key = entry.getKey();
                Object obj = entry.getValue();
                if (obj!=null){
                    sb.append("\n");
                    sb.append(indent);
                    sb.append("--    ");
                    if (obj instanceof Object[]){
                        sb.append(key + " = [" + PlanUtils.mkString((Object[])obj) + "]");
                    } else if (obj instanceof Column[]){
                        sb.append(key + " = [" + PlanUtils.mkString((Column[])obj) + "]");
                    } else  {
                        sb.append(key + " = " + obj);
                    }
                }
            }


            sb.append("\n");

            if (!options.showEverything() && sb.toString().contains("E_X_P_R_H_A_S_H_F_I_E_L_D")){
                clear();
                showing = false;
            } else {
                flush();
                depth += 1;
            }
        }

        for (int i = 0; i<planLine.getChildren().size(); i++){
            process(planLine.getChildren().get(i));
        }
        if (showing){
            depth -= 1;
        }
    }

    private String getIndent(int depth, String phaseName){
        StringBuffer sb1 = new StringBuffer(phaseName);
        for (int i = 0; i<depth; i++){
            sb1.append("  ");
        }
        return sb1.toString();
    }


    public String getString() {
        return output.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            PrintOption options = new PrintOption();
            PlanLine pl = PlanUtils.parsePlan(args[0]);
            PlanPrinter printer = new PlanPrinter(options);
            printer.process(pl);
            System.out.println(printer.getString());
        }
    }


}
