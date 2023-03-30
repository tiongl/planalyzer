
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
    "majorId",
    "majorPortionSize",
    "minorPortionSize"
})
@Generated("jsonschema2pojo")
public class Fragment {

    @JsonProperty("majorId")
    private long majorId;
    @JsonProperty("majorPortionSize")
    private long majorPortionSize;
    @JsonProperty("minorPortionSize")
    private long minorPortionSize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("majorId")
    public long getMajorId() {
        return majorId;
    }

    @JsonProperty("majorId")
    public void setMajorId(long majorId) {
        this.majorId = majorId;
    }

    public Fragment withMajorId(long majorId) {
        this.majorId = majorId;
        return this;
    }

    @JsonProperty("majorPortionSize")
    public long getMajorPortionSize() {
        return majorPortionSize;
    }

    @JsonProperty("majorPortionSize")
    public void setMajorPortionSize(long majorPortionSize) {
        this.majorPortionSize = majorPortionSize;
    }

    public Fragment withMajorPortionSize(long majorPortionSize) {
        this.majorPortionSize = majorPortionSize;
        return this;
    }

    @JsonProperty("minorPortionSize")
    public long getMinorPortionSize() {
        return minorPortionSize;
    }

    @JsonProperty("minorPortionSize")
    public void setMinorPortionSize(long minorPortionSize) {
        this.minorPortionSize = minorPortionSize;
    }

    public Fragment withMinorPortionSize(long minorPortionSize) {
        this.minorPortionSize = minorPortionSize;
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

    public Fragment withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Fragment.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("majorId");
        sb.append('=');
        sb.append(this.majorId);
        sb.append(',');
        sb.append("majorPortionSize");
        sb.append('=');
        sb.append(this.majorPortionSize);
        sb.append(',');
        sb.append("minorPortionSize");
        sb.append('=');
        sb.append(this.minorPortionSize);
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
        result = ((result* 31)+((int)(this.majorPortionSize^(this.majorPortionSize >>> 32))));
        result = ((result* 31)+((int)(this.minorPortionSize^(this.minorPortionSize >>> 32))));
        result = ((result* 31)+((int)(this.majorId^(this.majorId >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Fragment) == false) {
            return false;
        }
        Fragment rhs = ((Fragment) other);
        return ((((this.majorPortionSize == rhs.majorPortionSize)&&(this.minorPortionSize == rhs.minorPortionSize))&&(this.majorId == rhs.majorId))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
