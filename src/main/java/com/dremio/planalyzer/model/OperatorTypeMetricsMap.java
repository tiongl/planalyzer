
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
    "metricsDef"
})
@Generated("jsonschema2pojo")
public class OperatorTypeMetricsMap {

    @JsonProperty("metricsDef")
    private List<MetricsDef> metricsDef = new ArrayList<MetricsDef>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("metricsDef")
    public List<MetricsDef> getMetricsDef() {
        return metricsDef;
    }

    @JsonProperty("metricsDef")
    public void setMetricsDef(List<MetricsDef> metricsDef) {
        this.metricsDef = metricsDef;
    }

    public OperatorTypeMetricsMap withMetricsDef(List<MetricsDef> metricsDef) {
        this.metricsDef = metricsDef;
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

    public OperatorTypeMetricsMap withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(OperatorTypeMetricsMap.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("metricsDef");
        sb.append('=');
        sb.append(((this.metricsDef == null)?"<null>":this.metricsDef));
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
        result = ((result* 31)+((this.metricsDef == null)? 0 :this.metricsDef.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof OperatorTypeMetricsMap) == false) {
            return false;
        }
        OperatorTypeMetricsMap rhs = ((OperatorTypeMetricsMap) other);
        return (((this.metricsDef == rhs.metricsDef)||((this.metricsDef!= null)&&this.metricsDef.equals(rhs.metricsDef)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
