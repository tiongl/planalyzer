package com.dremio.planalyzer;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConditionVariableResolver extends ExpressionBaseVisitor<String> {
    StringBuffer sb = new StringBuffer();

    private PlanAnalyzer.Column[] columns;

    ConditionVariableResolver(PlanAnalyzer.Column[] columns) {
        this.columns = columns;
    }

    @Override
    public String visitExpr(ExpressionParser.ExprContext ctx) {
        super.visitExpr(ctx);
        return sb.toString();
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        Token t = node.getSymbol();
        if (t.getType() != Token.EOF){
            if (t.getType()== ExpressionParser.DOLLARV){
                int num = Integer.parseInt(t.getText().substring(1));
                if (num<columns.length){
                    sb.append(columns[num].root().getName());
                } else {
                    sb.append(t.getText() + "!");
                }
            } else {
                sb.append(node.getText());
            }
        }
        return super.visitTerminal(node);
    }
}
