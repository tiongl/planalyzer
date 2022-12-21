package com.dremio.planalyzer;

import java.util.HashMap;
import java.util.Map;

class PrintOption {
    static PrintOption EVERYTHING() {
        return new PrintOption();
    };

    static PrintOption JOIN_ANALYSIS() {
        PrintOption options = new PrintOption();
        options.addStage("HashJoin", new String[]{"conditionStr"});
        options.addStage("NestedLoopJoin", new String[]{"conditionStr"});
        options.addStage("Filter", new String[]{ "conditionStr" });
        options.addStage("ParquetScan", new String[]{ "tableName", "filters"});
        options.addStage("BroadcastExchange", new String[]{"-"});
        options.addStage("HashAgg", new String[]{"-"});
        options.addStage("TableFunction", new String[]{"tableName", "filters"});
        options.addStage("Values", new String[]{});
        return options;
    }



    private Map<String, String[]> planToShow = new HashMap<>();
    boolean showRowType = false;
    boolean showCost = false;
    boolean showPhase = false;
    boolean showEqList = false;

    boolean showCharacterSet = false;

    public void addStage(String stageName, String[] infoKeys) {
        planToShow.put(stageName, infoKeys);
    }

    public String[] isShowingPlan(String planName) {
        return planToShow.get(planName);
    }

    public boolean showEverything(){
        return planToShow.isEmpty();
    }
}
