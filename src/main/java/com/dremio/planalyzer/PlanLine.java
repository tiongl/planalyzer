package com.dremio.planalyzer;

import com.dremio.plananalyzer.PlanParser;

import java.util.*;

public class PlanLine {
    private Map<String, Object> info = new HashMap<String, Object>();

    private LinkedHashMap<String, String> attrMap = null;
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

    public String getPlanName() {
        return node.planName().ID().getText();
    }

    public String getId() {
        if (node.PHASE()==null){
            return getPlanName() + "#" + node.planName().ID().getSymbol().getLine();
        } else {
            return "" + node.PHASE() + ' ' + getPlanName() + "#" + node.planName().ID().getSymbol().getLine();
        }
    }

    public Map<String, Object> getInfo() {
        return info;
    }


    public LinkedHashMap<String, String> getAttrMap() {
        if (attrMap ==null){
            attrMap = new LinkedHashMap<>();
            if (node.planName().eqList()!=null) {
                List<PlanParser.EqPairContext> pairs = node.planName().eqList().eqPair();
                for (int i = 0; i < pairs.size(); i++) {
                    PlanParser.EqPairContext pair = pairs.get(i);
                    String name = getEqId(pair);
                    if (pair.eqValue()!=null) attrMap.put(name, pair.eqValue().BRACKET_STUFF().getText()); //TOD: maybe add null
                }
            }
        }
        return attrMap;
    }

    private String mkString(PlanParser.EqIDContext ctx){
        StringBuffer sb = new StringBuffer();
        int n = ctx.getChildCount();
        for (int i = 0; i< n; i++){
            sb.append(ctx.getChild(i).toString());
        }
        return sb.toString();
    }

    private String getEqId(PlanParser.EqPairContext pair) {
        String name = mkString(pair.eqID());
        if (pair.children.size()==2){
            if (!name.endsWith("=")) throw new IllegalStateException("Expecting '=' in name but get '" + name + "'");
            return name.substring(0, name.length()-1);
        } else {
            return name;
        }
    }

    public PlanLine getChild(int i){
        return children.get(i);
    }

    public int getChildCount(){
        return children.size();
    }

    public Map<String, Metrics> getMetrics(Map<List<Long>, Map<String, Metrics>> metrics) {
        String[] strIds = getNode().PHASE().getText().split("-");
        Long[] ids = {Long.parseLong(strIds[0]), Long.parseLong(strIds[1])};
        return metrics.get(Arrays.asList(ids));
    }
}
