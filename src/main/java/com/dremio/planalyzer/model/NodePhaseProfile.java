
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
    "endpoint",
    "maxMemoryUsed"
})
@Generated("jsonschema2pojo")
public class NodePhaseProfile {

    @JsonProperty("endpoint")
    private Endpoint__1 endpoint;
    @JsonProperty("maxMemoryUsed")
    private long maxMemoryUsed;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("endpoint")
    public Endpoint__1 getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(Endpoint__1 endpoint) {
        this.endpoint = endpoint;
    }

    public NodePhaseProfile withEndpoint(Endpoint__1 endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @JsonProperty("maxMemoryUsed")
    public long getMaxMemoryUsed() {
        return maxMemoryUsed;
    }

    @JsonProperty("maxMemoryUsed")
    public void setMaxMemoryUsed(long maxMemoryUsed) {
        this.maxMemoryUsed = maxMemoryUsed;
    }

    public NodePhaseProfile withMaxMemoryUsed(long maxMemoryUsed) {
        this.maxMemoryUsed = maxMemoryUsed;
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

    public NodePhaseProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(NodePhaseProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("endpoint");
        sb.append('=');
        sb.append(((this.endpoint == null)?"<null>":this.endpoint));
        sb.append(',');
        sb.append("maxMemoryUsed");
        sb.append('=');
        sb.append(this.maxMemoryUsed);
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
        result = ((result* 31)+((this.endpoint == null)? 0 :this.endpoint.hashCode()));
        result = ((result* 31)+((int)(this.maxMemoryUsed^(this.maxMemoryUsed >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof NodePhaseProfile) == false) {
            return false;
        }
        NodePhaseProfile rhs = ((NodePhaseProfile) other);
        return ((((this.endpoint == rhs.endpoint)||((this.endpoint!= null)&&this.endpoint.equals(rhs.endpoint)))&&(this.maxMemoryUsed == rhs.maxMemoryUsed))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
