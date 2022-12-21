package com.dremio.planalyzer;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlanLine {
    private Map<String, Object> info = new HashMap<String, Object>();
    private PlanParser.PlanLineContext node;
    private List<PlanLine> children = new ArrayList();

    public PlanLine(PlanParser.PlanLineContext node) {
        this.node = node;
    }

    public List<PlanLine> getChildren() {
        return children;
    }

    public PlanParser.PlanLineContext getNode() {
        return node;
    }

    public String getId() {
        return node.PHASE().toString().trim() + ' ' + node.planName().ID();
    }

    public Map<String, Object> getInfo() {
        return info;
    }
}
