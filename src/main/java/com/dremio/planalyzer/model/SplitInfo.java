
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
    "namedExpression",
    "inGandiva",
    "outputName",
    "dependsOn",
    "optimize"
})
@Generated("jsonschema2pojo")
public class SplitInfo {

    @JsonProperty("namedExpression")
    private String namedExpression;
    @JsonProperty("inGandiva")
    private boolean inGandiva;
    @JsonProperty("outputName")
    private String outputName;
    @JsonProperty("dependsOn")
    private List<Object> dependsOn = new ArrayList<Object>();
    @JsonProperty("optimize")
    private boolean optimize;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("namedExpression")
    public String getNamedExpression() {
        return namedExpression;
    }

    @JsonProperty("namedExpression")
    public void setNamedExpression(String namedExpression) {
        this.namedExpression = namedExpression;
    }

    public SplitInfo withNamedExpression(String namedExpression) {
        this.namedExpression = namedExpression;
        return this;
    }

    @JsonProperty("inGandiva")
    public boolean isInGandiva() {
        return inGandiva;
    }

    @JsonProperty("inGandiva")
    public void setInGandiva(boolean inGandiva) {
        this.inGandiva = inGandiva;
    }

    public SplitInfo withInGandiva(boolean inGandiva) {
        this.inGandiva = inGandiva;
        return this;
    }

    @JsonProperty("outputName")
    public String getOutputName() {
        return outputName;
    }

    @JsonProperty("outputName")
    public void setOutputName(String outputName) {
        this.outputName = outputName;
    }

    public SplitInfo withOutputName(String outputName) {
        this.outputName = outputName;
        return this;
    }

    @JsonProperty("dependsOn")
    public List<Object> getDependsOn() {
        return dependsOn;
    }

    @JsonProperty("dependsOn")
    public void setDependsOn(List<Object> dependsOn) {
        this.dependsOn = dependsOn;
    }

    public SplitInfo withDependsOn(List<Object> dependsOn) {
        this.dependsOn = dependsOn;
        return this;
    }

    @JsonProperty("optimize")
    public boolean isOptimize() {
        return optimize;
    }

    @JsonProperty("optimize")
    public void setOptimize(boolean optimize) {
        this.optimize = optimize;
    }

    public SplitInfo withOptimize(boolean optimize) {
        this.optimize = optimize;
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

    public SplitInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(SplitInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("namedExpression");
        sb.append('=');
        sb.append(((this.namedExpression == null)?"<null>":this.namedExpression));
        sb.append(',');
        sb.append("inGandiva");
        sb.append('=');
        sb.append(this.inGandiva);
        sb.append(',');
        sb.append("outputName");
        sb.append('=');
        sb.append(((this.outputName == null)?"<null>":this.outputName));
        sb.append(',');
        sb.append("dependsOn");
        sb.append('=');
        sb.append(((this.dependsOn == null)?"<null>":this.dependsOn));
        sb.append(',');
        sb.append("optimize");
        sb.append('=');
        sb.append(this.optimize);
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
        result = ((result* 31)+((this.outputName == null)? 0 :this.outputName.hashCode()));
        result = ((result* 31)+((this.dependsOn == null)? 0 :this.dependsOn.hashCode()));
        result = ((result* 31)+(this.optimize? 1 : 0));
        result = ((result* 31)+((this.namedExpression == null)? 0 :this.namedExpression.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+(this.inGandiva? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof SplitInfo) == false) {
            return false;
        }
        SplitInfo rhs = ((SplitInfo) other);
        return (((((((this.outputName == rhs.outputName)||((this.outputName!= null)&&this.outputName.equals(rhs.outputName)))&&((this.dependsOn == rhs.dependsOn)||((this.dependsOn!= null)&&this.dependsOn.equals(rhs.dependsOn))))&&(this.optimize == rhs.optimize))&&((this.namedExpression == rhs.namedExpression)||((this.namedExpression!= null)&&this.namedExpression.equals(rhs.namedExpression))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.inGandiva == rhs.inGandiva));
    }

}
