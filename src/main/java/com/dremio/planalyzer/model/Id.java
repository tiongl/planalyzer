
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
    "part1",
    "part2"
})
@Generated("jsonschema2pojo")
public class Id {

    @JsonProperty("part1")
    private long part1;
    @JsonProperty("part2")
    private long part2;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("part1")
    public long getPart1() {
        return part1;
    }

    @JsonProperty("part1")
    public void setPart1(long part1) {
        this.part1 = part1;
    }

    public Id withPart1(long part1) {
        this.part1 = part1;
        return this;
    }

    @JsonProperty("part2")
    public long getPart2() {
        return part2;
    }

    @JsonProperty("part2")
    public void setPart2(long part2) {
        this.part2 = part2;
    }

    public Id withPart2(long part2) {
        this.part2 = part2;
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

    public Id withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Id.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("part1");
        sb.append('=');
        sb.append(this.part1);
        sb.append(',');
        sb.append("part2");
        sb.append('=');
        sb.append(this.part2);
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
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.part1 ^(this.part1 >>> 32))));
        result = ((result* 31)+((int)(this.part2 ^(this.part2 >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Id) == false) {
            return false;
        }
        Id rhs = ((Id) other);
        return ((((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties)))&&(this.part1 == rhs.part1))&&(this.part2 == rhs.part2));
    }

}
