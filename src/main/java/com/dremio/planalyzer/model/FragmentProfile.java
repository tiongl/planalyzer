
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
    "majorFragmentId",
    "minorFragmentProfile",
    "nodePhaseProfile"
})
@Generated("jsonschema2pojo")
public class FragmentProfile {

    @JsonProperty("majorFragmentId")
    private long majorFragmentId;
    @JsonProperty("minorFragmentProfile")
    private List<MinorFragmentProfile> minorFragmentProfile = new ArrayList<MinorFragmentProfile>();
    @JsonProperty("nodePhaseProfile")
    private List<NodePhaseProfile> nodePhaseProfile = new ArrayList<NodePhaseProfile>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("majorFragmentId")
    public long getMajorFragmentId() {
        return majorFragmentId;
    }

    @JsonProperty("majorFragmentId")
    public void setMajorFragmentId(long majorFragmentId) {
        this.majorFragmentId = majorFragmentId;
    }

    public FragmentProfile withMajorFragmentId(long majorFragmentId) {
        this.majorFragmentId = majorFragmentId;
        return this;
    }

    @JsonProperty("minorFragmentProfile")
    public List<MinorFragmentProfile> getMinorFragmentProfile() {
        return minorFragmentProfile;
    }

    @JsonProperty("minorFragmentProfile")
    public void setMinorFragmentProfile(List<MinorFragmentProfile> minorFragmentProfile) {
        this.minorFragmentProfile = minorFragmentProfile;
    }

    public FragmentProfile withMinorFragmentProfile(List<MinorFragmentProfile> minorFragmentProfile) {
        this.minorFragmentProfile = minorFragmentProfile;
        return this;
    }

    @JsonProperty("nodePhaseProfile")
    public List<NodePhaseProfile> getNodePhaseProfile() {
        return nodePhaseProfile;
    }

    @JsonProperty("nodePhaseProfile")
    public void setNodePhaseProfile(List<NodePhaseProfile> nodePhaseProfile) {
        this.nodePhaseProfile = nodePhaseProfile;
    }

    public FragmentProfile withNodePhaseProfile(List<NodePhaseProfile> nodePhaseProfile) {
        this.nodePhaseProfile = nodePhaseProfile;
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

    public FragmentProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(FragmentProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("majorFragmentId");
        sb.append('=');
        sb.append(this.majorFragmentId);
        sb.append(',');
        sb.append("minorFragmentProfile");
        sb.append('=');
        sb.append(((this.minorFragmentProfile == null)?"<null>":this.minorFragmentProfile));
        sb.append(',');
        sb.append("nodePhaseProfile");
        sb.append('=');
        sb.append(((this.nodePhaseProfile == null)?"<null>":this.nodePhaseProfile));
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
        result = ((result* 31)+((this.nodePhaseProfile == null)? 0 :this.nodePhaseProfile.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.minorFragmentProfile == null)? 0 :this.minorFragmentProfile.hashCode()));
        result = ((result* 31)+((int)(this.majorFragmentId^(this.majorFragmentId >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof FragmentProfile) == false) {
            return false;
        }
        FragmentProfile rhs = ((FragmentProfile) other);
        return (((((this.nodePhaseProfile == rhs.nodePhaseProfile)||((this.nodePhaseProfile!= null)&&this.nodePhaseProfile.equals(rhs.nodePhaseProfile)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.minorFragmentProfile == rhs.minorFragmentProfile)||((this.minorFragmentProfile!= null)&&this.minorFragmentProfile.equals(rhs.minorFragmentProfile))))&&(this.majorFragmentId == rhs.majorFragmentId));
    }

}
