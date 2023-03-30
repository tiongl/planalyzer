
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
    "state",
    "startTime"
})
@Generated("jsonschema2pojo")
public class State {

    @JsonProperty("state")
    private long state;
    @JsonProperty("startTime")
    private long startTime;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("state")
    public long getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(long state) {
        this.state = state;
    }

    public State withState(long state) {
        this.state = state;
        return this;
    }

    @JsonProperty("startTime")
    public long getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public State withStartTime(long startTime) {
        this.startTime = startTime;
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

    public State withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(State.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("state");
        sb.append('=');
        sb.append(this.state);
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(this.startTime);
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
        result = ((result* 31)+((int)(this.startTime^(this.startTime >>> 32))));
        result = ((result* 31)+((int)(this.state^(this.state >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof State) == false) {
            return false;
        }
        State rhs = ((State) other);
        return (((this.startTime == rhs.startTime)&&(this.state == rhs.state))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
