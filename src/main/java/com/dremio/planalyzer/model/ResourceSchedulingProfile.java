
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
    "queueName",
    "queueId",
    "ruleContent",
    "ruleName",
    "ruleAction",
    "schedulingProperties",
    "resourceSchedulingStart",
    "resourceSchedulingEnd"
})
@Generated("jsonschema2pojo")
public class ResourceSchedulingProfile {

    @JsonProperty("queueName")
    private String queueName;
    @JsonProperty("queueId")
    private String queueId;
    @JsonProperty("ruleContent")
    private String ruleContent;
    @JsonProperty("ruleName")
    private String ruleName;
    @JsonProperty("ruleAction")
    private String ruleAction;
    @JsonProperty("schedulingProperties")
    private SchedulingProperties schedulingProperties;
    @JsonProperty("resourceSchedulingStart")
    private long resourceSchedulingStart;
    @JsonProperty("resourceSchedulingEnd")
    private long resourceSchedulingEnd;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("queueName")
    public String getQueueName() {
        return queueName;
    }

    @JsonProperty("queueName")
    public void setQueueName(String queueName) {
        this.queueName = queueName;
    }

    public ResourceSchedulingProfile withQueueName(String queueName) {
        this.queueName = queueName;
        return this;
    }

    @JsonProperty("queueId")
    public String getQueueId() {
        return queueId;
    }

    @JsonProperty("queueId")
    public void setQueueId(String queueId) {
        this.queueId = queueId;
    }

    public ResourceSchedulingProfile withQueueId(String queueId) {
        this.queueId = queueId;
        return this;
    }

    @JsonProperty("ruleContent")
    public String getRuleContent() {
        return ruleContent;
    }

    @JsonProperty("ruleContent")
    public void setRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
    }

    public ResourceSchedulingProfile withRuleContent(String ruleContent) {
        this.ruleContent = ruleContent;
        return this;
    }

    @JsonProperty("ruleName")
    public String getRuleName() {
        return ruleName;
    }

    @JsonProperty("ruleName")
    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public ResourceSchedulingProfile withRuleName(String ruleName) {
        this.ruleName = ruleName;
        return this;
    }

    @JsonProperty("ruleAction")
    public String getRuleAction() {
        return ruleAction;
    }

    @JsonProperty("ruleAction")
    public void setRuleAction(String ruleAction) {
        this.ruleAction = ruleAction;
    }

    public ResourceSchedulingProfile withRuleAction(String ruleAction) {
        this.ruleAction = ruleAction;
        return this;
    }

    @JsonProperty("schedulingProperties")
    public SchedulingProperties getSchedulingProperties() {
        return schedulingProperties;
    }

    @JsonProperty("schedulingProperties")
    public void setSchedulingProperties(SchedulingProperties schedulingProperties) {
        this.schedulingProperties = schedulingProperties;
    }

    public ResourceSchedulingProfile withSchedulingProperties(SchedulingProperties schedulingProperties) {
        this.schedulingProperties = schedulingProperties;
        return this;
    }

    @JsonProperty("resourceSchedulingStart")
    public long getResourceSchedulingStart() {
        return resourceSchedulingStart;
    }

    @JsonProperty("resourceSchedulingStart")
    public void setResourceSchedulingStart(long resourceSchedulingStart) {
        this.resourceSchedulingStart = resourceSchedulingStart;
    }

    public ResourceSchedulingProfile withResourceSchedulingStart(long resourceSchedulingStart) {
        this.resourceSchedulingStart = resourceSchedulingStart;
        return this;
    }

    @JsonProperty("resourceSchedulingEnd")
    public long getResourceSchedulingEnd() {
        return resourceSchedulingEnd;
    }

    @JsonProperty("resourceSchedulingEnd")
    public void setResourceSchedulingEnd(long resourceSchedulingEnd) {
        this.resourceSchedulingEnd = resourceSchedulingEnd;
    }

    public ResourceSchedulingProfile withResourceSchedulingEnd(long resourceSchedulingEnd) {
        this.resourceSchedulingEnd = resourceSchedulingEnd;
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

    public ResourceSchedulingProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ResourceSchedulingProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("queueName");
        sb.append('=');
        sb.append(((this.queueName == null)?"<null>":this.queueName));
        sb.append(',');
        sb.append("queueId");
        sb.append('=');
        sb.append(((this.queueId == null)?"<null>":this.queueId));
        sb.append(',');
        sb.append("ruleContent");
        sb.append('=');
        sb.append(((this.ruleContent == null)?"<null>":this.ruleContent));
        sb.append(',');
        sb.append("ruleName");
        sb.append('=');
        sb.append(((this.ruleName == null)?"<null>":this.ruleName));
        sb.append(',');
        sb.append("ruleAction");
        sb.append('=');
        sb.append(((this.ruleAction == null)?"<null>":this.ruleAction));
        sb.append(',');
        sb.append("schedulingProperties");
        sb.append('=');
        sb.append(((this.schedulingProperties == null)?"<null>":this.schedulingProperties));
        sb.append(',');
        sb.append("resourceSchedulingStart");
        sb.append('=');
        sb.append(this.resourceSchedulingStart);
        sb.append(',');
        sb.append("resourceSchedulingEnd");
        sb.append('=');
        sb.append(this.resourceSchedulingEnd);
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
        result = ((result* 31)+((this.ruleContent == null)? 0 :this.ruleContent.hashCode()));
        result = ((result* 31)+((int)(this.resourceSchedulingStart^(this.resourceSchedulingStart >>> 32))));
        result = ((result* 31)+((this.queueId == null)? 0 :this.queueId.hashCode()));
        result = ((result* 31)+((this.ruleAction == null)? 0 :this.ruleAction.hashCode()));
        result = ((result* 31)+((this.queueName == null)? 0 :this.queueName.hashCode()));
        result = ((result* 31)+((this.ruleName == null)? 0 :this.ruleName.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.resourceSchedulingEnd^(this.resourceSchedulingEnd >>> 32))));
        result = ((result* 31)+((this.schedulingProperties == null)? 0 :this.schedulingProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ResourceSchedulingProfile) == false) {
            return false;
        }
        ResourceSchedulingProfile rhs = ((ResourceSchedulingProfile) other);
        return ((((((((((this.ruleContent == rhs.ruleContent)||((this.ruleContent!= null)&&this.ruleContent.equals(rhs.ruleContent)))&&(this.resourceSchedulingStart == rhs.resourceSchedulingStart))&&((this.queueId == rhs.queueId)||((this.queueId!= null)&&this.queueId.equals(rhs.queueId))))&&((this.ruleAction == rhs.ruleAction)||((this.ruleAction!= null)&&this.ruleAction.equals(rhs.ruleAction))))&&((this.queueName == rhs.queueName)||((this.queueName!= null)&&this.queueName.equals(rhs.queueName))))&&((this.ruleName == rhs.ruleName)||((this.ruleName!= null)&&this.ruleName.equals(rhs.ruleName))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.resourceSchedulingEnd == rhs.resourceSchedulingEnd))&&((this.schedulingProperties == rhs.schedulingProperties)||((this.schedulingProperties!= null)&&this.schedulingProperties.equals(rhs.schedulingProperties))));
    }

}
