
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
    "splitInfos",
    "slowIoInfos",
    "slowMetadataIoInfos"
})
@Generated("jsonschema2pojo")
public class Details {

    @JsonProperty("splitInfos")
    private List<SplitInfo> splitInfos = new ArrayList<SplitInfo>();
    @JsonProperty("slowIoInfos")
    private List<Object> slowIoInfos = new ArrayList<Object>();
    @JsonProperty("slowMetadataIoInfos")
    private List<Object> slowMetadataIoInfos = new ArrayList<Object>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("splitInfos")
    public List<SplitInfo> getSplitInfos() {
        return splitInfos;
    }

    @JsonProperty("splitInfos")
    public void setSplitInfos(List<SplitInfo> splitInfos) {
        this.splitInfos = splitInfos;
    }

    public Details withSplitInfos(List<SplitInfo> splitInfos) {
        this.splitInfos = splitInfos;
        return this;
    }

    @JsonProperty("slowIoInfos")
    public List<Object> getSlowIoInfos() {
        return slowIoInfos;
    }

    @JsonProperty("slowIoInfos")
    public void setSlowIoInfos(List<Object> slowIoInfos) {
        this.slowIoInfos = slowIoInfos;
    }

    public Details withSlowIoInfos(List<Object> slowIoInfos) {
        this.slowIoInfos = slowIoInfos;
        return this;
    }

    @JsonProperty("slowMetadataIoInfos")
    public List<Object> getSlowMetadataIoInfos() {
        return slowMetadataIoInfos;
    }

    @JsonProperty("slowMetadataIoInfos")
    public void setSlowMetadataIoInfos(List<Object> slowMetadataIoInfos) {
        this.slowMetadataIoInfos = slowMetadataIoInfos;
    }

    public Details withSlowMetadataIoInfos(List<Object> slowMetadataIoInfos) {
        this.slowMetadataIoInfos = slowMetadataIoInfos;
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

    public Details withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Details.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("splitInfos");
        sb.append('=');
        sb.append(((this.splitInfos == null)?"<null>":this.splitInfos));
        sb.append(',');
        sb.append("slowIoInfos");
        sb.append('=');
        sb.append(((this.slowIoInfos == null)?"<null>":this.slowIoInfos));
        sb.append(',');
        sb.append("slowMetadataIoInfos");
        sb.append('=');
        sb.append(((this.slowMetadataIoInfos == null)?"<null>":this.slowMetadataIoInfos));
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
        result = ((result* 31)+((this.slowMetadataIoInfos == null)? 0 :this.slowMetadataIoInfos.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.splitInfos == null)? 0 :this.splitInfos.hashCode()));
        result = ((result* 31)+((this.slowIoInfos == null)? 0 :this.slowIoInfos.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Details) == false) {
            return false;
        }
        Details rhs = ((Details) other);
        return (((((this.slowMetadataIoInfos == rhs.slowMetadataIoInfos)||((this.slowMetadataIoInfos!= null)&&this.slowMetadataIoInfos.equals(rhs.slowMetadataIoInfos)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.splitInfos == rhs.splitInfos)||((this.splitInfos!= null)&&this.splitInfos.equals(rhs.splitInfos))))&&((this.slowIoInfos == rhs.slowIoInfos)||((this.slowIoInfos!= null)&&this.slowIoInfos.equals(rhs.slowIoInfos))));
    }

}
