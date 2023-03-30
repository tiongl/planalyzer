
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
    "sizePerNode",
    "fragments",
    "minorSpecificAttrs",
    "sharedAttrs"
})
@Generated("jsonschema2pojo")
public class SizeStats {

    @JsonProperty("sizePerNode")
    private long sizePerNode;
    @JsonProperty("fragments")
    private List<Fragment> fragments = new ArrayList<Fragment>();
    @JsonProperty("minorSpecificAttrs")
    private List<MinorSpecificAttr> minorSpecificAttrs = new ArrayList<MinorSpecificAttr>();
    @JsonProperty("sharedAttrs")
    private List<SharedAttr> sharedAttrs = new ArrayList<SharedAttr>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sizePerNode")
    public long getSizePerNode() {
        return sizePerNode;
    }

    @JsonProperty("sizePerNode")
    public void setSizePerNode(long sizePerNode) {
        this.sizePerNode = sizePerNode;
    }

    public SizeStats withSizePerNode(long sizePerNode) {
        this.sizePerNode = sizePerNode;
        return this;
    }

    @JsonProperty("fragments")
    public List<Fragment> getFragments() {
        return fragments;
    }

    @JsonProperty("fragments")
    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
    }

    public SizeStats withFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        return this;
    }

    @JsonProperty("minorSpecificAttrs")
    public List<MinorSpecificAttr> getMinorSpecificAttrs() {
        return minorSpecificAttrs;
    }

    @JsonProperty("minorSpecificAttrs")
    public void setMinorSpecificAttrs(List<MinorSpecificAttr> minorSpecificAttrs) {
        this.minorSpecificAttrs = minorSpecificAttrs;
    }

    public SizeStats withMinorSpecificAttrs(List<MinorSpecificAttr> minorSpecificAttrs) {
        this.minorSpecificAttrs = minorSpecificAttrs;
        return this;
    }

    @JsonProperty("sharedAttrs")
    public List<SharedAttr> getSharedAttrs() {
        return sharedAttrs;
    }

    @JsonProperty("sharedAttrs")
    public void setSharedAttrs(List<SharedAttr> sharedAttrs) {
        this.sharedAttrs = sharedAttrs;
    }

    public SizeStats withSharedAttrs(List<SharedAttr> sharedAttrs) {
        this.sharedAttrs = sharedAttrs;
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

    public SizeStats withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SizeStats.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sizePerNode");
        sb.append('=');
        sb.append(this.sizePerNode);
        sb.append(',');
        sb.append("fragments");
        sb.append('=');
        sb.append(((this.fragments == null)?"<null>":this.fragments));
        sb.append(',');
        sb.append("minorSpecificAttrs");
        sb.append('=');
        sb.append(((this.minorSpecificAttrs == null)?"<null>":this.minorSpecificAttrs));
        sb.append(',');
        sb.append("sharedAttrs");
        sb.append('=');
        sb.append(((this.sharedAttrs == null)?"<null>":this.sharedAttrs));
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
        result = ((result* 31)+((int)(this.sizePerNode^(this.sizePerNode >>> 32))));
        result = ((result* 31)+((this.fragments == null)? 0 :this.fragments.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.minorSpecificAttrs == null)? 0 :this.minorSpecificAttrs.hashCode()));
        result = ((result* 31)+((this.sharedAttrs == null)? 0 :this.sharedAttrs.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SizeStats) == false) {
            return false;
        }
        SizeStats rhs = ((SizeStats) other);
        return (((((this.sizePerNode == rhs.sizePerNode)&&((this.fragments == rhs.fragments)||((this.fragments!= null)&&this.fragments.equals(rhs.fragments))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.minorSpecificAttrs == rhs.minorSpecificAttrs)||((this.minorSpecificAttrs!= null)&&this.minorSpecificAttrs.equals(rhs.minorSpecificAttrs))))&&((this.sharedAttrs == rhs.sharedAttrs)||((this.sharedAttrs!= null)&&this.sharedAttrs.equals(rhs.sharedAttrs))));
    }

}
