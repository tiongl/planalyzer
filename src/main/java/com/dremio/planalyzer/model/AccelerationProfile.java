
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
    "accelerated",
    "numSubstitutions",
    "millisTakenGettingMaterializations",
    "millisTakenNormalizing",
    "millisTakenSubstituting",
    "layoutProfiles",
    "normalizedQueryPlans",
    "accelerationDetails"
})
@Generated("jsonschema2pojo")
public class AccelerationProfile {

    @JsonProperty("accelerated")
    private boolean accelerated;
    @JsonProperty("numSubstitutions")
    private long numSubstitutions;
    @JsonProperty("millisTakenGettingMaterializations")
    private long millisTakenGettingMaterializations;
    @JsonProperty("millisTakenNormalizing")
    private long millisTakenNormalizing;
    @JsonProperty("millisTakenSubstituting")
    private long millisTakenSubstituting;
    @JsonProperty("layoutProfiles")
    private List<LayoutProfile> layoutProfiles = new ArrayList<LayoutProfile>();
    @JsonProperty("normalizedQueryPlans")
    private List<String> normalizedQueryPlans = new ArrayList<String>();
    @JsonProperty("accelerationDetails")
    private String accelerationDetails;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("accelerated")
    public boolean isAccelerated() {
        return accelerated;
    }

    @JsonProperty("accelerated")
    public void setAccelerated(boolean accelerated) {
        this.accelerated = accelerated;
    }

    public AccelerationProfile withAccelerated(boolean accelerated) {
        this.accelerated = accelerated;
        return this;
    }

    @JsonProperty("numSubstitutions")
    public long getNumSubstitutions() {
        return numSubstitutions;
    }

    @JsonProperty("numSubstitutions")
    public void setNumSubstitutions(long numSubstitutions) {
        this.numSubstitutions = numSubstitutions;
    }

    public AccelerationProfile withNumSubstitutions(long numSubstitutions) {
        this.numSubstitutions = numSubstitutions;
        return this;
    }

    @JsonProperty("millisTakenGettingMaterializations")
    public long getMillisTakenGettingMaterializations() {
        return millisTakenGettingMaterializations;
    }

    @JsonProperty("millisTakenGettingMaterializations")
    public void setMillisTakenGettingMaterializations(long millisTakenGettingMaterializations) {
        this.millisTakenGettingMaterializations = millisTakenGettingMaterializations;
    }

    public AccelerationProfile withMillisTakenGettingMaterializations(long millisTakenGettingMaterializations) {
        this.millisTakenGettingMaterializations = millisTakenGettingMaterializations;
        return this;
    }

    @JsonProperty("millisTakenNormalizing")
    public long getMillisTakenNormalizing() {
        return millisTakenNormalizing;
    }

    @JsonProperty("millisTakenNormalizing")
    public void setMillisTakenNormalizing(long millisTakenNormalizing) {
        this.millisTakenNormalizing = millisTakenNormalizing;
    }

    public AccelerationProfile withMillisTakenNormalizing(long millisTakenNormalizing) {
        this.millisTakenNormalizing = millisTakenNormalizing;
        return this;
    }

    @JsonProperty("millisTakenSubstituting")
    public long getMillisTakenSubstituting() {
        return millisTakenSubstituting;
    }

    @JsonProperty("millisTakenSubstituting")
    public void setMillisTakenSubstituting(long millisTakenSubstituting) {
        this.millisTakenSubstituting = millisTakenSubstituting;
    }

    public AccelerationProfile withMillisTakenSubstituting(long millisTakenSubstituting) {
        this.millisTakenSubstituting = millisTakenSubstituting;
        return this;
    }

    @JsonProperty("layoutProfiles")
    public List<LayoutProfile> getLayoutProfiles() {
        return layoutProfiles;
    }

    @JsonProperty("layoutProfiles")
    public void setLayoutProfiles(List<LayoutProfile> layoutProfiles) {
        this.layoutProfiles = layoutProfiles;
    }

    public AccelerationProfile withLayoutProfiles(List<LayoutProfile> layoutProfiles) {
        this.layoutProfiles = layoutProfiles;
        return this;
    }

    @JsonProperty("normalizedQueryPlans")
    public List<String> getNormalizedQueryPlans() {
        return normalizedQueryPlans;
    }

    @JsonProperty("normalizedQueryPlans")
    public void setNormalizedQueryPlans(List<String> normalizedQueryPlans) {
        this.normalizedQueryPlans = normalizedQueryPlans;
    }

    public AccelerationProfile withNormalizedQueryPlans(List<String> normalizedQueryPlans) {
        this.normalizedQueryPlans = normalizedQueryPlans;
        return this;
    }

    @JsonProperty("accelerationDetails")
    public String getAccelerationDetails() {
        return accelerationDetails;
    }

    @JsonProperty("accelerationDetails")
    public void setAccelerationDetails(String accelerationDetails) {
        this.accelerationDetails = accelerationDetails;
    }

    public AccelerationProfile withAccelerationDetails(String accelerationDetails) {
        this.accelerationDetails = accelerationDetails;
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

    public AccelerationProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(AccelerationProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("accelerated");
        sb.append('=');
        sb.append(this.accelerated);
        sb.append(',');
        sb.append("numSubstitutions");
        sb.append('=');
        sb.append(this.numSubstitutions);
        sb.append(',');
        sb.append("millisTakenGettingMaterializations");
        sb.append('=');
        sb.append(this.millisTakenGettingMaterializations);
        sb.append(',');
        sb.append("millisTakenNormalizing");
        sb.append('=');
        sb.append(this.millisTakenNormalizing);
        sb.append(',');
        sb.append("millisTakenSubstituting");
        sb.append('=');
        sb.append(this.millisTakenSubstituting);
        sb.append(',');
        sb.append("layoutProfiles");
        sb.append('=');
        sb.append(((this.layoutProfiles == null)?"<null>":this.layoutProfiles));
        sb.append(',');
        sb.append("normalizedQueryPlans");
        sb.append('=');
        sb.append(((this.normalizedQueryPlans == null)?"<null>":this.normalizedQueryPlans));
        sb.append(',');
        sb.append("accelerationDetails");
        sb.append('=');
        sb.append(((this.accelerationDetails == null)?"<null>":this.accelerationDetails));
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
        result = ((result* 31)+((int)(this.millisTakenNormalizing^(this.millisTakenNormalizing >>> 32))));
        result = ((result* 31)+((this.accelerationDetails == null)? 0 :this.accelerationDetails.hashCode()));
        result = ((result* 31)+((this.layoutProfiles == null)? 0 :this.layoutProfiles.hashCode()));
        result = ((result* 31)+((int)(this.numSubstitutions^(this.numSubstitutions >>> 32))));
        result = ((result* 31)+((int)(this.millisTakenSubstituting^(this.millisTakenSubstituting >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+(this.accelerated? 1 : 0));
        result = ((result* 31)+((int)(this.millisTakenGettingMaterializations^(this.millisTakenGettingMaterializations >>> 32))));
        result = ((result* 31)+((this.normalizedQueryPlans == null)? 0 :this.normalizedQueryPlans.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof AccelerationProfile) == false) {
            return false;
        }
        AccelerationProfile rhs = ((AccelerationProfile) other);
        return (((((((((this.millisTakenNormalizing == rhs.millisTakenNormalizing)&&((this.accelerationDetails == rhs.accelerationDetails)||((this.accelerationDetails!= null)&&this.accelerationDetails.equals(rhs.accelerationDetails))))&&((this.layoutProfiles == rhs.layoutProfiles)||((this.layoutProfiles!= null)&&this.layoutProfiles.equals(rhs.layoutProfiles))))&&(this.numSubstitutions == rhs.numSubstitutions))&&(this.millisTakenSubstituting == rhs.millisTakenSubstituting))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.accelerated == rhs.accelerated))&&(this.millisTakenGettingMaterializations == rhs.millisTakenGettingMaterializations))&&((this.normalizedQueryPlans == rhs.normalizedQueryPlans)||((this.normalizedQueryPlans!= null)&&this.normalizedQueryPlans.equals(rhs.normalizedQueryPlans))));
    }

}
