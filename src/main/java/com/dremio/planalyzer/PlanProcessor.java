package com.dremio.planalyzer;

import com.dremio.plananalyzer.PlanBaseVisitor;

public abstract class PlanProcessor<T> extends PlanBaseVisitor<T> {
    public abstract T process(PlanLine planLine);
}
