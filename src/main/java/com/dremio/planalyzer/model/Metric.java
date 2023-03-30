
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
    "metricId",
    "longValue",
    "doubleValue"
})
@Generated("jsonschema2pojo")
public class Metric {

    @JsonProperty("metricId")
    private long metricId;
    @JsonProperty("longValue")
    private long longValue;
    @JsonProperty("doubleValue")
    private double doubleValue;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("metricId")
    public long getMetricId() {
        return metricId;
    }

    @JsonProperty("metricId")
    public void setMetricId(long metricId) {
        this.metricId = metricId;
    }

    public Metric withMetricId(long metricId) {
        this.metricId = metricId;
        return this;
    }

    @JsonProperty("longValue")
    public long getLongValue() {
        return longValue;
    }

    @JsonProperty("longValue")
    public void setLongValue(long longValue) {
        this.longValue = longValue;
    }

    public Metric withLongValue(long longValue) {
        this.longValue = longValue;
        return this;
    }

    @JsonProperty("doubleValue")
    public double getDoubleValue() {
        return doubleValue;
    }

    @JsonProperty("doubleValue")
    public void setDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
    }

    public Metric withDoubleValue(double doubleValue) {
        this.doubleValue = doubleValue;
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

    public Metric withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Metric.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("metricId");
        sb.append('=');
        sb.append(this.metricId);
        sb.append(',');
        sb.append("longValue");
        sb.append('=');
        sb.append(this.longValue);
        sb.append(',');
        sb.append("doubleValue");
        sb.append('=');
        sb.append(this.doubleValue);
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.doubleValue)^(Double.doubleToLongBits(this.doubleValue)>>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.metricId^(this.metricId >>> 32))));
        result = ((result* 31)+((int)(this.longValue^(this.longValue >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Metric) == false) {
            return false;
        }
        Metric rhs = ((Metric) other);
        return ((((Double.doubleToLongBits(this.doubleValue) == Double.doubleToLongBits(rhs.doubleValue))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.metricId == rhs.metricId))&&(this.longValue == rhs.longValue));
    }

}
