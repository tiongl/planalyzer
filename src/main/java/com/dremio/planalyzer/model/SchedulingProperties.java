
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
    "queryCost",
    "queryType"
})
@Generated("jsonschema2pojo")
public class SchedulingProperties {

    @JsonProperty("queryCost")
    private double queryCost;
    @JsonProperty("queryType")
    private String queryType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("queryCost")
    public double getQueryCost() {
        return queryCost;
    }

    @JsonProperty("queryCost")
    public void setQueryCost(double queryCost) {
        this.queryCost = queryCost;
    }

    public SchedulingProperties withQueryCost(double queryCost) {
        this.queryCost = queryCost;
        return this;
    }

    @JsonProperty("queryType")
    public String getQueryType() {
        return queryType;
    }

    @JsonProperty("queryType")
    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public SchedulingProperties withQueryType(String queryType) {
        this.queryType = queryType;
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

    public SchedulingProperties withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SchedulingProperties.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("queryCost");
        sb.append('=');
        sb.append(this.queryCost);
        sb.append(',');
        sb.append("queryType");
        sb.append('=');
        sb.append(((this.queryType == null)?"<null>":this.queryType));
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
        result = ((result* 31)+((int)(Double.doubleToLongBits(this.queryCost)^(Double.doubleToLongBits(this.queryCost)>>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.queryType == null)? 0 :this.queryType.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SchedulingProperties) == false) {
            return false;
        }
        SchedulingProperties rhs = ((SchedulingProperties) other);
        return (((Double.doubleToLongBits(this.queryCost) == Double.doubleToLongBits(rhs.queryCost))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.queryType == rhs.queryType)||((this.queryType!= null)&&this.queryType.equals(rhs.queryType))));
    }

}
