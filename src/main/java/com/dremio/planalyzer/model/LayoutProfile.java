
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
    "layoutId",
    "materializationId",
    "materializationExpirationTimestamp",
    "plan",
    "dimensions",
    "measures",
    "sortedColumns",
    "partitionedColumns",
    "distributionColumns",
    "displayColumns",
    "numUsed",
    "numSubstitutions",
    "millisTakenSubstituting",
    "substitutions",
    "normalizedPlans",
    "normalizedQueryPlans",
    "name",
    "optimizedPlan",
    "type",
    "snowflake",
    "measureColumns",
    "defaultReflection"
})
@Generated("jsonschema2pojo")
public class LayoutProfile {

    @JsonProperty("layoutId")
    private String layoutId;
    @JsonProperty("materializationId")
    private String materializationId;
    @JsonProperty("materializationExpirationTimestamp")
    private long materializationExpirationTimestamp;
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("dimensions")
    private List<Object> dimensions = new ArrayList<Object>();
    @JsonProperty("measures")
    private List<Object> measures = new ArrayList<Object>();
    @JsonProperty("sortedColumns")
    private List<Object> sortedColumns = new ArrayList<Object>();
    @JsonProperty("partitionedColumns")
    private List<Object> partitionedColumns = new ArrayList<Object>();
    @JsonProperty("distributionColumns")
    private List<Object> distributionColumns = new ArrayList<Object>();
    @JsonProperty("displayColumns")
    private List<String> displayColumns = new ArrayList<String>();
    @JsonProperty("numUsed")
    private long numUsed;
    @JsonProperty("numSubstitutions")
    private long numSubstitutions;
    @JsonProperty("millisTakenSubstituting")
    private long millisTakenSubstituting;
    @JsonProperty("substitutions")
    private List<Substitution> substitutions = new ArrayList<Substitution>();
    @JsonProperty("normalizedPlans")
    private List<String> normalizedPlans = new ArrayList<String>();
    @JsonProperty("normalizedQueryPlans")
    private List<Object> normalizedQueryPlans = new ArrayList<Object>();
    @JsonProperty("name")
    private String name;
    @JsonProperty("optimizedPlan")
    private String optimizedPlan;
    @JsonProperty("type")
    private long type;
    @JsonProperty("snowflake")
    private boolean snowflake;
    @JsonProperty("measureColumns")
    private List<Object> measureColumns = new ArrayList<Object>();
    @JsonProperty("defaultReflection")
    private boolean defaultReflection;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("layoutId")
    public String getLayoutId() {
        return layoutId;
    }

    @JsonProperty("layoutId")
    public void setLayoutId(String layoutId) {
        this.layoutId = layoutId;
    }

    public LayoutProfile withLayoutId(String layoutId) {
        this.layoutId = layoutId;
        return this;
    }

    @JsonProperty("materializationId")
    public String getMaterializationId() {
        return materializationId;
    }

    @JsonProperty("materializationId")
    public void setMaterializationId(String materializationId) {
        this.materializationId = materializationId;
    }

    public LayoutProfile withMaterializationId(String materializationId) {
        this.materializationId = materializationId;
        return this;
    }

    @JsonProperty("materializationExpirationTimestamp")
    public long getMaterializationExpirationTimestamp() {
        return materializationExpirationTimestamp;
    }

    @JsonProperty("materializationExpirationTimestamp")
    public void setMaterializationExpirationTimestamp(long materializationExpirationTimestamp) {
        this.materializationExpirationTimestamp = materializationExpirationTimestamp;
    }

    public LayoutProfile withMaterializationExpirationTimestamp(long materializationExpirationTimestamp) {
        this.materializationExpirationTimestamp = materializationExpirationTimestamp;
        return this;
    }

    @JsonProperty("plan")
    public String getPlan() {
        return plan;
    }

    @JsonProperty("plan")
    public void setPlan(String plan) {
        this.plan = plan;
    }

    public LayoutProfile withPlan(String plan) {
        this.plan = plan;
        return this;
    }

    @JsonProperty("dimensions")
    public List<Object> getDimensions() {
        return dimensions;
    }

    @JsonProperty("dimensions")
    public void setDimensions(List<Object> dimensions) {
        this.dimensions = dimensions;
    }

    public LayoutProfile withDimensions(List<Object> dimensions) {
        this.dimensions = dimensions;
        return this;
    }

    @JsonProperty("measures")
    public List<Object> getMeasures() {
        return measures;
    }

    @JsonProperty("measures")
    public void setMeasures(List<Object> measures) {
        this.measures = measures;
    }

    public LayoutProfile withMeasures(List<Object> measures) {
        this.measures = measures;
        return this;
    }

    @JsonProperty("sortedColumns")
    public List<Object> getSortedColumns() {
        return sortedColumns;
    }

    @JsonProperty("sortedColumns")
    public void setSortedColumns(List<Object> sortedColumns) {
        this.sortedColumns = sortedColumns;
    }

    public LayoutProfile withSortedColumns(List<Object> sortedColumns) {
        this.sortedColumns = sortedColumns;
        return this;
    }

    @JsonProperty("partitionedColumns")
    public List<Object> getPartitionedColumns() {
        return partitionedColumns;
    }

    @JsonProperty("partitionedColumns")
    public void setPartitionedColumns(List<Object> partitionedColumns) {
        this.partitionedColumns = partitionedColumns;
    }

    public LayoutProfile withPartitionedColumns(List<Object> partitionedColumns) {
        this.partitionedColumns = partitionedColumns;
        return this;
    }

    @JsonProperty("distributionColumns")
    public List<Object> getDistributionColumns() {
        return distributionColumns;
    }

    @JsonProperty("distributionColumns")
    public void setDistributionColumns(List<Object> distributionColumns) {
        this.distributionColumns = distributionColumns;
    }

    public LayoutProfile withDistributionColumns(List<Object> distributionColumns) {
        this.distributionColumns = distributionColumns;
        return this;
    }

    @JsonProperty("displayColumns")
    public List<String> getDisplayColumns() {
        return displayColumns;
    }

    @JsonProperty("displayColumns")
    public void setDisplayColumns(List<String> displayColumns) {
        this.displayColumns = displayColumns;
    }

    public LayoutProfile withDisplayColumns(List<String> displayColumns) {
        this.displayColumns = displayColumns;
        return this;
    }

    @JsonProperty("numUsed")
    public long getNumUsed() {
        return numUsed;
    }

    @JsonProperty("numUsed")
    public void setNumUsed(long numUsed) {
        this.numUsed = numUsed;
    }

    public LayoutProfile withNumUsed(long numUsed) {
        this.numUsed = numUsed;
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

    public LayoutProfile withNumSubstitutions(long numSubstitutions) {
        this.numSubstitutions = numSubstitutions;
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

    public LayoutProfile withMillisTakenSubstituting(long millisTakenSubstituting) {
        this.millisTakenSubstituting = millisTakenSubstituting;
        return this;
    }

    @JsonProperty("substitutions")
    public List<Substitution> getSubstitutions() {
        return substitutions;
    }

    @JsonProperty("substitutions")
    public void setSubstitutions(List<Substitution> substitutions) {
        this.substitutions = substitutions;
    }

    public LayoutProfile withSubstitutions(List<Substitution> substitutions) {
        this.substitutions = substitutions;
        return this;
    }

    @JsonProperty("normalizedPlans")
    public List<String> getNormalizedPlans() {
        return normalizedPlans;
    }

    @JsonProperty("normalizedPlans")
    public void setNormalizedPlans(List<String> normalizedPlans) {
        this.normalizedPlans = normalizedPlans;
    }

    public LayoutProfile withNormalizedPlans(List<String> normalizedPlans) {
        this.normalizedPlans = normalizedPlans;
        return this;
    }

    @JsonProperty("normalizedQueryPlans")
    public List<Object> getNormalizedQueryPlans() {
        return normalizedQueryPlans;
    }

    @JsonProperty("normalizedQueryPlans")
    public void setNormalizedQueryPlans(List<Object> normalizedQueryPlans) {
        this.normalizedQueryPlans = normalizedQueryPlans;
    }

    public LayoutProfile withNormalizedQueryPlans(List<Object> normalizedQueryPlans) {
        this.normalizedQueryPlans = normalizedQueryPlans;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public LayoutProfile withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("optimizedPlan")
    public String getOptimizedPlan() {
        return optimizedPlan;
    }

    @JsonProperty("optimizedPlan")
    public void setOptimizedPlan(String optimizedPlan) {
        this.optimizedPlan = optimizedPlan;
    }

    public LayoutProfile withOptimizedPlan(String optimizedPlan) {
        this.optimizedPlan = optimizedPlan;
        return this;
    }

    @JsonProperty("type")
    public long getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(long type) {
        this.type = type;
    }

    public LayoutProfile withType(long type) {
        this.type = type;
        return this;
    }

    @JsonProperty("snowflake")
    public boolean isSnowflake() {
        return snowflake;
    }

    @JsonProperty("snowflake")
    public void setSnowflake(boolean snowflake) {
        this.snowflake = snowflake;
    }

    public LayoutProfile withSnowflake(boolean snowflake) {
        this.snowflake = snowflake;
        return this;
    }

    @JsonProperty("measureColumns")
    public List<Object> getMeasureColumns() {
        return measureColumns;
    }

    @JsonProperty("measureColumns")
    public void setMeasureColumns(List<Object> measureColumns) {
        this.measureColumns = measureColumns;
    }

    public LayoutProfile withMeasureColumns(List<Object> measureColumns) {
        this.measureColumns = measureColumns;
        return this;
    }

    @JsonProperty("defaultReflection")
    public boolean isDefaultReflection() {
        return defaultReflection;
    }

    @JsonProperty("defaultReflection")
    public void setDefaultReflection(boolean defaultReflection) {
        this.defaultReflection = defaultReflection;
    }

    public LayoutProfile withDefaultReflection(boolean defaultReflection) {
        this.defaultReflection = defaultReflection;
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

    public LayoutProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(LayoutProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("layoutId");
        sb.append('=');
        sb.append(((this.layoutId == null)?"<null>":this.layoutId));
        sb.append(',');
        sb.append("materializationId");
        sb.append('=');
        sb.append(((this.materializationId == null)?"<null>":this.materializationId));
        sb.append(',');
        sb.append("materializationExpirationTimestamp");
        sb.append('=');
        sb.append(this.materializationExpirationTimestamp);
        sb.append(',');
        sb.append("plan");
        sb.append('=');
        sb.append(((this.plan == null)?"<null>":this.plan));
        sb.append(',');
        sb.append("dimensions");
        sb.append('=');
        sb.append(((this.dimensions == null)?"<null>":this.dimensions));
        sb.append(',');
        sb.append("measures");
        sb.append('=');
        sb.append(((this.measures == null)?"<null>":this.measures));
        sb.append(',');
        sb.append("sortedColumns");
        sb.append('=');
        sb.append(((this.sortedColumns == null)?"<null>":this.sortedColumns));
        sb.append(',');
        sb.append("partitionedColumns");
        sb.append('=');
        sb.append(((this.partitionedColumns == null)?"<null>":this.partitionedColumns));
        sb.append(',');
        sb.append("distributionColumns");
        sb.append('=');
        sb.append(((this.distributionColumns == null)?"<null>":this.distributionColumns));
        sb.append(',');
        sb.append("displayColumns");
        sb.append('=');
        sb.append(((this.displayColumns == null)?"<null>":this.displayColumns));
        sb.append(',');
        sb.append("numUsed");
        sb.append('=');
        sb.append(this.numUsed);
        sb.append(',');
        sb.append("numSubstitutions");
        sb.append('=');
        sb.append(this.numSubstitutions);
        sb.append(',');
        sb.append("millisTakenSubstituting");
        sb.append('=');
        sb.append(this.millisTakenSubstituting);
        sb.append(',');
        sb.append("substitutions");
        sb.append('=');
        sb.append(((this.substitutions == null)?"<null>":this.substitutions));
        sb.append(',');
        sb.append("normalizedPlans");
        sb.append('=');
        sb.append(((this.normalizedPlans == null)?"<null>":this.normalizedPlans));
        sb.append(',');
        sb.append("normalizedQueryPlans");
        sb.append('=');
        sb.append(((this.normalizedQueryPlans == null)?"<null>":this.normalizedQueryPlans));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("optimizedPlan");
        sb.append('=');
        sb.append(((this.optimizedPlan == null)?"<null>":this.optimizedPlan));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(this.type);
        sb.append(',');
        sb.append("snowflake");
        sb.append('=');
        sb.append(this.snowflake);
        sb.append(',');
        sb.append("measureColumns");
        sb.append('=');
        sb.append(((this.measureColumns == null)?"<null>":this.measureColumns));
        sb.append(',');
        sb.append("defaultReflection");
        sb.append('=');
        sb.append(this.defaultReflection);
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
        result = ((result* 31)+(this.snowflake? 1 : 0));
        result = ((result* 31)+((int)(this.millisTakenSubstituting^(this.millisTakenSubstituting >>> 32))));
        result = ((result* 31)+((this.sortedColumns == null)? 0 :this.sortedColumns.hashCode()));
        result = ((result* 31)+((this.distributionColumns == null)? 0 :this.distributionColumns.hashCode()));
        result = ((result* 31)+((int)(this.type^(this.type >>> 32))));
        result = ((result* 31)+((this.layoutId == null)? 0 :this.layoutId.hashCode()));
        result = ((result* 31)+((this.normalizedQueryPlans == null)? 0 :this.normalizedQueryPlans.hashCode()));
        result = ((result* 31)+((this.optimizedPlan == null)? 0 :this.optimizedPlan.hashCode()));
        result = ((result* 31)+((this.materializationId == null)? 0 :this.materializationId.hashCode()));
        result = ((result* 31)+((int)(this.materializationExpirationTimestamp^(this.materializationExpirationTimestamp >>> 32))));
        result = ((result* 31)+((this.measures == null)? 0 :this.measures.hashCode()));
        result = ((result* 31)+((this.partitionedColumns == null)? 0 :this.partitionedColumns.hashCode()));
        result = ((result* 31)+((this.displayColumns == null)? 0 :this.displayColumns.hashCode()));
        result = ((result* 31)+((this.substitutions == null)? 0 :this.substitutions.hashCode()));
        result = ((result* 31)+((int)(this.numSubstitutions^(this.numSubstitutions >>> 32))));
        result = ((result* 31)+((this.normalizedPlans == null)? 0 :this.normalizedPlans.hashCode()));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.plan == null)? 0 :this.plan.hashCode()));
        result = ((result* 31)+((this.measureColumns == null)? 0 :this.measureColumns.hashCode()));
        result = ((result* 31)+((this.dimensions == null)? 0 :this.dimensions.hashCode()));
        result = ((result* 31)+((int)(this.numUsed^(this.numUsed >>> 32))));
        result = ((result* 31)+(this.defaultReflection? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LayoutProfile) == false) {
            return false;
        }
        LayoutProfile rhs = ((LayoutProfile) other);
        return (((((((((((((((((((((((this.snowflake == rhs.snowflake)&&(this.millisTakenSubstituting == rhs.millisTakenSubstituting))&&((this.sortedColumns == rhs.sortedColumns)||((this.sortedColumns!= null)&&this.sortedColumns.equals(rhs.sortedColumns))))&&((this.distributionColumns == rhs.distributionColumns)||((this.distributionColumns!= null)&&this.distributionColumns.equals(rhs.distributionColumns))))&&(this.type == rhs.type))&&((this.layoutId == rhs.layoutId)||((this.layoutId!= null)&&this.layoutId.equals(rhs.layoutId))))&&((this.normalizedQueryPlans == rhs.normalizedQueryPlans)||((this.normalizedQueryPlans!= null)&&this.normalizedQueryPlans.equals(rhs.normalizedQueryPlans))))&&((this.optimizedPlan == rhs.optimizedPlan)||((this.optimizedPlan!= null)&&this.optimizedPlan.equals(rhs.optimizedPlan))))&&((this.materializationId == rhs.materializationId)||((this.materializationId!= null)&&this.materializationId.equals(rhs.materializationId))))&&(this.materializationExpirationTimestamp == rhs.materializationExpirationTimestamp))&&((this.measures == rhs.measures)||((this.measures!= null)&&this.measures.equals(rhs.measures))))&&((this.partitionedColumns == rhs.partitionedColumns)||((this.partitionedColumns!= null)&&this.partitionedColumns.equals(rhs.partitionedColumns))))&&((this.displayColumns == rhs.displayColumns)||((this.displayColumns!= null)&&this.displayColumns.equals(rhs.displayColumns))))&&((this.substitutions == rhs.substitutions)||((this.substitutions!= null)&&this.substitutions.equals(rhs.substitutions))))&&(this.numSubstitutions == rhs.numSubstitutions))&&((this.normalizedPlans == rhs.normalizedPlans)||((this.normalizedPlans!= null)&&this.normalizedPlans.equals(rhs.normalizedPlans))))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.plan == rhs.plan)||((this.plan!= null)&&this.plan.equals(rhs.plan))))&&((this.measureColumns == rhs.measureColumns)||((this.measureColumns!= null)&&this.measureColumns.equals(rhs.measureColumns))))&&((this.dimensions == rhs.dimensions)||((this.dimensions!= null)&&this.dimensions.equals(rhs.dimensions))))&&(this.numUsed == rhs.numUsed))&&(this.defaultReflection == rhs.defaultReflection));
    }

}
