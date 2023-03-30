
package com.dremio.planalyzer.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    "inputProfile",
    "operatorId",
    "operatorType",
    "setupNanos",
    "processNanos",
    "peakLocalMemoryAllocated",
    "metric",
    "waitNanos",
    "details"
})
@Generated("jsonschema2pojo")
public class OperatorProfile {

    @JsonProperty("inputProfile")
    private List<InputProfile> inputProfile = new ArrayList<InputProfile>();
    @JsonProperty("operatorId")
    private long operatorId;
    @JsonProperty("operatorType")
    private long operatorType;
    @JsonProperty("setupNanos")
    private long setupNanos;
    @JsonProperty("processNanos")
    private long processNanos;
    @JsonProperty("peakLocalMemoryAllocated")
    private long peakLocalMemoryAllocated;
    @JsonProperty("metric")
    private List<Metric> metric = new ArrayList<Metric>();
    @JsonProperty("waitNanos")
    private long waitNanos;
    @JsonProperty("details")
    private Details details;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("inputProfile")
    public List<InputProfile> getInputProfile() {
        return inputProfile;
    }

    @JsonProperty("inputProfile")
    public void setInputProfile(List<InputProfile> inputProfile) {
        this.inputProfile = inputProfile;
    }

    public OperatorProfile withInputProfile(List<InputProfile> inputProfile) {
        this.inputProfile = inputProfile;
        return this;
    }

    @JsonProperty("operatorId")
    public long getOperatorId() {
        return operatorId;
    }

    @JsonProperty("operatorId")
    public void setOperatorId(long operatorId) {
        this.operatorId = operatorId;
    }

    public OperatorProfile withOperatorId(long operatorId) {
        this.operatorId = operatorId;
        return this;
    }

    @JsonProperty("operatorType")
    public long getOperatorType() {
        return operatorType;
    }

    @JsonProperty("operatorType")
    public void setOperatorType(long operatorType) {
        this.operatorType = operatorType;
    }

    public OperatorProfile withOperatorType(long operatorType) {
        this.operatorType = operatorType;
        return this;
    }

    @JsonProperty("setupNanos")
    public long getSetupNanos() {
        return setupNanos;
    }

    @JsonProperty("setupNanos")
    public void setSetupNanos(long setupNanos) {
        this.setupNanos = setupNanos;
    }

    public OperatorProfile withSetupNanos(long setupNanos) {
        this.setupNanos = setupNanos;
        return this;
    }

    @JsonProperty("processNanos")
    public long getProcessNanos() {
        return processNanos;
    }

    @JsonProperty("processNanos")
    public void setProcessNanos(long processNanos) {
        this.processNanos = processNanos;
    }

    public OperatorProfile withProcessNanos(long processNanos) {
        this.processNanos = processNanos;
        return this;
    }

    @JsonProperty("peakLocalMemoryAllocated")
    public long getPeakLocalMemoryAllocated() {
        return peakLocalMemoryAllocated;
    }

    @JsonProperty("peakLocalMemoryAllocated")
    public void setPeakLocalMemoryAllocated(long peakLocalMemoryAllocated) {
        this.peakLocalMemoryAllocated = peakLocalMemoryAllocated;
    }

    public OperatorProfile withPeakLocalMemoryAllocated(long peakLocalMemoryAllocated) {
        this.peakLocalMemoryAllocated = peakLocalMemoryAllocated;
        return this;
    }

    @JsonProperty("metric")
    public List<Metric> getMetric() {
        return metric;
    }

    @JsonProperty("metric")
    public void setMetric(List<Metric> metric) {
        this.metric = metric;
    }

    public OperatorProfile withMetric(List<Metric> metric) {
        this.metric = metric;
        return this;
    }

    @JsonProperty("waitNanos")
    public long getWaitNanos() {
        return waitNanos;
    }

    @JsonProperty("waitNanos")
    public void setWaitNanos(long waitNanos) {
        this.waitNanos = waitNanos;
    }

    public OperatorProfile withWaitNanos(long waitNanos) {
        this.waitNanos = waitNanos;
        return this;
    }

    @JsonProperty("details")
    public Details getDetails() {
        return details;
    }

    @JsonProperty("details")
    public void setDetails(Details details) {
        this.details = details;
    }

    public OperatorProfile withDetails(Details details) {
        this.details = details;
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

    public OperatorProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OperatorProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("inputProfile");
        sb.append('=');
        sb.append(((this.inputProfile == null)?"<null>":this.inputProfile));
        sb.append(',');
        sb.append("operatorId");
        sb.append('=');
        sb.append(this.operatorId);
        sb.append(',');
        sb.append("operatorType");
        sb.append('=');
        sb.append(this.operatorType);
        sb.append(',');
        sb.append("setupNanos");
        sb.append('=');
        sb.append(this.setupNanos);
        sb.append(',');
        sb.append("processNanos");
        sb.append('=');
        sb.append(this.processNanos);
        sb.append(',');
        sb.append("peakLocalMemoryAllocated");
        sb.append('=');
        sb.append(this.peakLocalMemoryAllocated);
        sb.append(',');
        sb.append("metric");
        sb.append('=');
        sb.append(((this.metric == null)?"<null>":this.metric));
        sb.append(',');
        sb.append("waitNanos");
        sb.append('=');
        sb.append(this.waitNanos);
        sb.append(',');
        sb.append("details");
        sb.append('=');
        sb.append(((this.details == null)?"<null>":this.details));
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
        result = ((result* 31)+((int)(this.waitNanos^(this.waitNanos >>> 32))));
        result = ((result* 31)+((int)(this.setupNanos^(this.setupNanos >>> 32))));
        result = ((result* 31)+((this.metric == null)? 0 :this.metric.hashCode()));
        result = ((result* 31)+((this.inputProfile == null)? 0 :this.inputProfile.hashCode()));
        result = ((result* 31)+((int)(this.processNanos^(this.processNanos >>> 32))));
        result = ((result* 31)+((int)(this.peakLocalMemoryAllocated^(this.peakLocalMemoryAllocated >>> 32))));
        result = ((result* 31)+((this.details == null)? 0 :this.details.hashCode()));
        result = ((result* 31)+((int)(this.operatorType^(this.operatorType >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.operatorId^(this.operatorId >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OperatorProfile) == false) {
            return false;
        }
        OperatorProfile rhs = ((OperatorProfile) other);
        return ((((((((((this.waitNanos == rhs.waitNanos)&&(this.setupNanos == rhs.setupNanos))&&((this.metric == rhs.metric)||((this.metric!= null)&&this.metric.equals(rhs.metric))))&&((this.inputProfile == rhs.inputProfile)||((this.inputProfile!= null)&&this.inputProfile.equals(rhs.inputProfile))))&&(this.processNanos == rhs.processNanos))&&(this.peakLocalMemoryAllocated == rhs.peakLocalMemoryAllocated))&&((this.details == rhs.details)||((this.details!= null)&&this.details.equals(rhs.details))))&&(this.operatorType == rhs.operatorType))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.operatorId == rhs.operatorId));
    }

}
