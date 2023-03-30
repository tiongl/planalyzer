
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
    "resource",
    "category",
    "duration"
})
@Generated("jsonschema2pojo")
public class PerResourceBlockedDuration {

    @JsonProperty("resource")
    private String resource;
    @JsonProperty("category")
    private long category;
    @JsonProperty("duration")
    private long duration;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("resource")
    public String getResource() {
        return resource;
    }

    @JsonProperty("resource")
    public void setResource(String resource) {
        this.resource = resource;
    }

    public PerResourceBlockedDuration withResource(String resource) {
        this.resource = resource;
        return this;
    }

    @JsonProperty("category")
    public long getCategory() {
        return category;
    }

    @JsonProperty("category")
    public void setCategory(long category) {
        this.category = category;
    }

    public PerResourceBlockedDuration withCategory(long category) {
        this.category = category;
        return this;
    }

    @JsonProperty("duration")
    public long getDuration() {
        return duration;
    }

    @JsonProperty("duration")
    public void setDuration(long duration) {
        this.duration = duration;
    }

    public PerResourceBlockedDuration withDuration(long duration) {
        this.duration = duration;
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

    public PerResourceBlockedDuration withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(PerResourceBlockedDuration.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("resource");
        sb.append('=');
        sb.append(((this.resource == null)?"<null>":this.resource));
        sb.append(',');
        sb.append("category");
        sb.append('=');
        sb.append(this.category);
        sb.append(',');
        sb.append("duration");
        sb.append('=');
        sb.append(this.duration);
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
        result = ((result* 31)+((int)(this.duration^(this.duration >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.category^(this.category >>> 32))));
        result = ((result* 31)+((this.resource == null)? 0 :this.resource.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PerResourceBlockedDuration) == false) {
            return false;
        }
        PerResourceBlockedDuration rhs = ((PerResourceBlockedDuration) other);
        return ((((this.duration == rhs.duration)&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.category == rhs.category))&&((this.resource == rhs.resource)||((this.resource!= null)&&this.resource.equals(rhs.resource))));
    }

}
