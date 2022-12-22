package com.dremio.planalyzer;

import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConditionVariableResolver extends ExpressionBaseVisitor<String> {
    private StringBuffer sb = new StringBuffer();

    private boolean withTableName;

    private PlanAnalyzer.Column[] columns;

    ConditionVariableResolver(PlanAnalyzer.Column[] columns, boolean withTableName) {
        this.columns = columns;
        this.withTableName = withTableName;
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
                    sb.append(columns[num].root().getName(withTableName));
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
