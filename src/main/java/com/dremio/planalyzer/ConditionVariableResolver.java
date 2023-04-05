package com.dremio.planalyzer;

import com.dremio.plananalyzer.ExpressionBaseVisitor;
import com.dremio.plananalyzer.ExpressionParser;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.tree.TerminalNode;

public class ConditionVariableResolver extends ExpressionBaseVisitor<String> {
    private StringBuffer sb = new StringBuffer();

    private boolean withTableName;

    private Column[] columns;

    ConditionVariableResolver(Column[] columns, boolean withTableName) {
        this.columns = columns;
        this.withTableName = withTableName;
    }

    @Override
    public String visitExpr(ExpressionParser.ExprContext ctx) {
        super.visitExpr(ctx);
        return sb.toString();
    }

    @Override
    public String visitExpression(ExpressionParser.ExpressionContext ctx) {
        super.visitExpression(ctx);
        return sb.toString();
    }

    @Override
    public String visitTerminal(TerminalNode node) {
        Token t = node.getSymbol();
        if (t.getType() != Token.EOF){
            if (t.getType()== ExpressionParser.DOLLARV){
                try {
                    int num = Integer.parseInt(t.getText().substring(1));
                    if (num < columns.length) {
                        sb.append(columns[num].root().getName(withTableName || true));
                    } else {
                        sb.append(t.getText() + "!");
                    }
                } catch (NumberFormatException e){
                    sb.append(t.getText());
                }
            } else {
                sb.append(node.getText());
            }
        }
        return super.visitTerminal(node);
    }
}
