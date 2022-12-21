package com.dremio.planalyzer;


import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;

import static com.dremio.planalyzer.PlanParser.COMMA;
import static com.dremio.planalyzer.PlanParser.PHASE;

public class PlanPrinter {


    PrintOption options = new PrintOption();
    private class Printer extends PlanBaseVisitor<Void>{

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
            if (type==PHASE){
                if (options.showPhase){
                    sb.append(node.getText());
                } else {
                    StringBuffer sb1 = new StringBuffer();
                    for (int i = 0; i<depth; i++){
                        sb1.append("  ");
                    }
                    String phaseName = node.getSymbol().getText().trim();
                    sb.append(phaseName + sb1.substring(phaseName.length()-5));
                }
            } else {
                sb.append(node.getText());
            }
            if (type==COMMA){
                sb.append(" ");
            }
            return super.visitTerminal(node);
        }
    }

    private Printer p = new Printer();
    private StringBuffer sb = new StringBuffer();

    private int depth = 0;

    public PlanPrinter(){
    }

    public PlanPrinter(PrintOption options){
        this.options = options;
    }

    public void process(PlanLine planLine){
        boolean metaTableFunction = false;
        if (planLine.getNode().planName().ID().getText().equals("TableFunction")){
            PlanAnalyzer.Column[] columns = (PlanAnalyzer.Column[])planLine.getInfo().get("columns");
            if (columns[0].getName().indexOf("splitsIdentity")!=-1){
                metaTableFunction = true;
            }
        }
        String[] keys = options.isShowingPlan(planLine.getNode().planName().ID().getText());
        boolean showing = !metaTableFunction && (options.showEverything() || keys!=null);
        if (showing) {
            planLine.getNode().accept(p);
            if (keys!=null) {
                if (keys.length == 0) {
                    sb.append(planLine.getInfo().toString());
                } else {
                    for (int i = 0; i <keys.length; i++) {
                        Object obj = planLine.getInfo().get(keys[i]);
                        if (obj!=null){
                            if (obj instanceof Object[]){
                                sb.append(keys[i] + "=[" + PlanUtils.mkString((Object[])obj) + "]");
                            } else {
                                sb.append(keys[i] + "=" + obj);
                            }
                            if (i<keys.length-1){
                                sb.append(", ");
                            }
                        }
                    }
                }
            }
            sb.append("\n");
            depth += 1;
        }
        for (int i = 0; i<planLine.getChildren().size(); i++){
            process(planLine.getChildren().get(i));
        }
        if (showing){
            depth -= 1;
        }
    }

    public String getString() {
        return sb.toString();
    }

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            PrintOption options = new PrintOption();
            options.addStage("HashJoin", new String[]{});
            PlanLine pl = PlanUtils.parsePlan(args[0]);
            PlanPrinter printer = new PlanPrinter(options);
            printer.process(pl);
            System.out.println(printer.getString());
        }
    }


}
