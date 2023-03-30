
package com.dremio.planalyzer.model;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "phaseName",
    "durationMillis",
    "plan",
    "plannerDump",
    "sizeStats"
})
@Generated("jsonschema2pojo")
public class PlanPhase {

    @JsonProperty("phaseName")
    private String phaseName;
    @JsonProperty("durationMillis")
    private long durationMillis;
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("plannerDump")
    private String plannerDump;
    @JsonProperty("sizeStats")
    private SizeStats sizeStats;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("phaseName")
    public String getPhaseName() {
        return phaseName;
    }

    @JsonProperty("phaseName")
    public void setPhaseName(String phaseName) {
        this.phaseName = phaseName;
    }

    public PlanPhase withPhaseName(String phaseName) {
        this.phaseName = phaseName;
        return this;
    }

    @JsonProperty("durationMillis")
    public long getDurationMillis() {
        return durationMillis;
    }

    @JsonProperty("durationMillis")
    public void setDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
    }

    public PlanPhase withDurationMillis(long durationMillis) {
        this.durationMillis = durationMillis;
        return this;
    }

    @JsonProperty("plan")
    public String getPlan() {
        return plan;
    }

    @JsonProperty("plan")
    public void setPlan(String plan) {
        this.plan = plan;
    }

    public PlanPhase withPlan(String plan) {
        this.plan = plan;
        return this;
    }

    @JsonProperty("plannerDump")
    public String getPlannerDump() {
        return plannerDump;
    }

    @JsonProperty("plannerDump")
    public void setPlannerDump(String plannerDump) {
        this.plannerDump = plannerDump;
    }

    public PlanPhase withPlannerDump(String plannerDump) {
        this.plannerDump = plannerDump;
        return this;
    }

    @JsonProperty("sizeStats")
    public SizeStats getSizeStats() {
        return sizeStats;
    }

    @JsonProperty("sizeStats")
    public void setSizeStats(SizeStats sizeStats) {
        this.sizeStats = sizeStats;
    }

    public PlanPhase withSizeStats(SizeStats sizeStats) {
        this.sizeStats = sizeStats;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public PlanPhase withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PlanPhase.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("phaseName");
        sb.append('=');
        sb.append(((this.phaseName == null)?"<null>":this.phaseName));
        sb.append(',');
        sb.append("durationMillis");
        sb.append('=');
        sb.append(this.durationMillis);
        sb.append(',');
        sb.append("plan");
        sb.append('=');
        sb.append(((this.plan == null)?"<null>":this.plan));
        sb.append(',');
        sb.append("plannerDump");
        sb.append('=');
        sb.append(((this.plannerDump == null)?"<null>":this.plannerDump));
        sb.append(',');
        sb.append("sizeStats");
        sb.append('=');
        sb.append(((this.sizeStats == null)?"<null>":this.sizeStats));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.plannerDump == null)? 0 :this.plannerDump.hashCode()));
        result = ((result* 31)+((int)(this.durationMillis^(this.durationMillis >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.sizeStats == null)? 0 :this.sizeStats.hashCode()));
        result = ((result* 31)+((this.plan == null)? 0 :this.plan.hashCode()));
        result = ((result* 31)+((this.phaseName == null)? 0 :this.phaseName.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PlanPhase) == false) {
            return false;
        }
        PlanPhase rhs = ((PlanPhase) other);
        return (((((((this.plannerDump == rhs.plannerDump)||((this.plannerDump!= null)&&this.plannerDump.equals(rhs.plannerDump)))&&(this.durationMillis == rhs.durationMillis))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.sizeStats == rhs.sizeStats)||((this.sizeStats!= null)&&this.sizeStats.equals(rhs.sizeStats))))&&((this.plan == rhs.plan)||((this.plan!= null)&&this.plan.equals(rhs.plan))))&&((this.phaseName == rhs.phaseName)||((this.phaseName!= null)&&this.phaseName.equals(rhs.phaseName))));
    }

}
