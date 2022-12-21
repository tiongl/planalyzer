package com.dremio.planalyzer;

public abstract class PlanProcessor<T> extends PlanBaseVisitor<T> {
    public abstract T process(PlanLine planLine);
}
