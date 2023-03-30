
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
    "id",
    "start",
    "end",
    "query",
    "plan",
    "foreman",
    "state",
    "totalFragments",
    "finishedFragments",
    "fragmentProfile",
    "user",
    "planningStart",
    "planningEnd",
    "jsonPlan",
    "clientInfo",
    "planPhases",
    "accelerationProfile",
    "fullSchema",
    "nonDefaultOptionsJSON",
    "datasetProfile",
    "nodeProfile",
    "dremioVersion",
    "operatorTypeMetricsMap",
    "resourceSchedulingProfile",
    "commandPoolWaitMillis",
    "stateList"
})
@Generated("jsonschema2pojo")
public class Profile {

    @JsonProperty("id")
    private Id id;
    @JsonProperty("start")
    private long start;
    @JsonProperty("end")
    private long end;
    @JsonProperty("query")
    private String query;
    @JsonProperty("plan")
    private String plan;
    @JsonProperty("foreman")
    private Foreman foreman;
    @JsonProperty("state")
    private long state;
    @JsonProperty("totalFragments")
    private long totalFragments;
    @JsonProperty("finishedFragments")
    private long finishedFragments;
    @JsonProperty("fragmentProfile")
    private List<FragmentProfile> fragmentProfile = new ArrayList<FragmentProfile>();
    @JsonProperty("user")
    private String user;
    @JsonProperty("planningStart")
    private long planningStart;
    @JsonProperty("planningEnd")
    private long planningEnd;
    @JsonProperty("jsonPlan")
    private String jsonPlan;
    @JsonProperty("clientInfo")
    private ClientInfo clientInfo;
    @JsonProperty("planPhases")
    private List<PlanPhase> planPhases = new ArrayList<PlanPhase>();
    @JsonProperty("accelerationProfile")
    private AccelerationProfile accelerationProfile;
    @JsonProperty("fullSchema")
    private String fullSchema;
    @JsonProperty("nonDefaultOptionsJSON")
    private String nonDefaultOptionsJSON;
    @JsonProperty("datasetProfile")
    private List<DatasetProfile> datasetProfile = new ArrayList<DatasetProfile>();
    @JsonProperty("nodeProfile")
    private List<NodeProfile> nodeProfile = new ArrayList<NodeProfile>();
    @JsonProperty("dremioVersion")
    private String dremioVersion;
    @JsonProperty("operatorTypeMetricsMap")
    private OperatorTypeMetricsMap operatorTypeMetricsMap;
    @JsonProperty("resourceSchedulingProfile")
    private ResourceSchedulingProfile resourceSchedulingProfile;
    @JsonProperty("commandPoolWaitMillis")
    private long commandPoolWaitMillis;
    @JsonProperty("stateList")
    private List<State> stateList = new ArrayList<State>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public Id getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Id id) {
        this.id = id;
    }

    public Profile withId(Id id) {
        this.id = id;
        return this;
    }

    @JsonProperty("start")
    public long getStart() {
        return start;
    }

    @JsonProperty("start")
    public void setStart(long start) {
        this.start = start;
    }

    public Profile withStart(long start) {
        this.start = start;
        return this;
    }

    @JsonProperty("end")
    public long getEnd() {
        return end;
    }

    @JsonProperty("end")
    public void setEnd(long end) {
        this.end = end;
    }

    public Profile withEnd(long end) {
        this.end = end;
        return this;
    }

    @JsonProperty("query")
    public String getQuery() {
        return query;
    }

    @JsonProperty("query")
    public void setQuery(String query) {
        this.query = query;
    }

    public Profile withQuery(String query) {
        this.query = query;
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

    public Profile withPlan(String plan) {
        this.plan = plan;
        return this;
    }

    @JsonProperty("foreman")
    public Foreman getForeman() {
        return foreman;
    }

    @JsonProperty("foreman")
    public void setForeman(Foreman foreman) {
        this.foreman = foreman;
    }

    public Profile withForeman(Foreman foreman) {
        this.foreman = foreman;
        return this;
    }

    @JsonProperty("state")
    public long getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(long state) {
        this.state = state;
    }

    public Profile withState(long state) {
        this.state = state;
        return this;
    }

    @JsonProperty("totalFragments")
    public long getTotalFragments() {
        return totalFragments;
    }

    @JsonProperty("totalFragments")
    public void setTotalFragments(long totalFragments) {
        this.totalFragments = totalFragments;
    }

    public Profile withTotalFragments(long totalFragments) {
        this.totalFragments = totalFragments;
        return this;
    }

    @JsonProperty("finishedFragments")
    public long getFinishedFragments() {
        return finishedFragments;
    }

    @JsonProperty("finishedFragments")
    public void setFinishedFragments(long finishedFragments) {
        this.finishedFragments = finishedFragments;
    }

    public Profile withFinishedFragments(long finishedFragments) {
        this.finishedFragments = finishedFragments;
        return this;
    }

    @JsonProperty("fragmentProfile")
    public List<FragmentProfile> getFragmentProfile() {
        return fragmentProfile;
    }

    @JsonProperty("fragmentProfile")
    public void setFragmentProfile(List<FragmentProfile> fragmentProfile) {
        this.fragmentProfile = fragmentProfile;
    }

    public Profile withFragmentProfile(List<FragmentProfile> fragmentProfile) {
        this.fragmentProfile = fragmentProfile;
        return this;
    }

    @JsonProperty("user")
    public String getUser() {
        return user;
    }

    @JsonProperty("user")
    public void setUser(String user) {
        this.user = user;
    }

    public Profile withUser(String user) {
        this.user = user;
        return this;
    }

    @JsonProperty("planningStart")
    public long getPlanningStart() {
        return planningStart;
    }

    @JsonProperty("planningStart")
    public void setPlanningStart(long planningStart) {
        this.planningStart = planningStart;
    }

    public Profile withPlanningStart(long planningStart) {
        this.planningStart = planningStart;
        return this;
    }

    @JsonProperty("planningEnd")
    public long getPlanningEnd() {
        return planningEnd;
    }

    @JsonProperty("planningEnd")
    public void setPlanningEnd(long planningEnd) {
        this.planningEnd = planningEnd;
    }

    public Profile withPlanningEnd(long planningEnd) {
        this.planningEnd = planningEnd;
        return this;
    }

    @JsonProperty("jsonPlan")
    public String getJsonPlan() {
        return jsonPlan;
    }

    @JsonProperty("jsonPlan")
    public void setJsonPlan(String jsonPlan) {
        this.jsonPlan = jsonPlan;
    }

    public Profile withJsonPlan(String jsonPlan) {
        this.jsonPlan = jsonPlan;
        return this;
    }

    @JsonProperty("clientInfo")
    public ClientInfo getClientInfo() {
        return clientInfo;
    }

    @JsonProperty("clientInfo")
    public void setClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
    }

    public Profile withClientInfo(ClientInfo clientInfo) {
        this.clientInfo = clientInfo;
        return this;
    }

    @JsonProperty("planPhases")
    public List<PlanPhase> getPlanPhases() {
        return planPhases;
    }

    @JsonProperty("planPhases")
    public void setPlanPhases(List<PlanPhase> planPhases) {
        this.planPhases = planPhases;
    }

    public Profile withPlanPhases(List<PlanPhase> planPhases) {
        this.planPhases = planPhases;
        return this;
    }

    @JsonProperty("accelerationProfile")
    public AccelerationProfile getAccelerationProfile() {
        return accelerationProfile;
    }

    @JsonProperty("accelerationProfile")
    public void setAccelerationProfile(AccelerationProfile accelerationProfile) {
        this.accelerationProfile = accelerationProfile;
    }

    public Profile withAccelerationProfile(AccelerationProfile accelerationProfile) {
        this.accelerationProfile = accelerationProfile;
        return this;
    }

    @JsonProperty("fullSchema")
    public String getFullSchema() {
        return fullSchema;
    }

    @JsonProperty("fullSchema")
    public void setFullSchema(String fullSchema) {
        this.fullSchema = fullSchema;
    }

    public Profile withFullSchema(String fullSchema) {
        this.fullSchema = fullSchema;
        return this;
    }

    @JsonProperty("nonDefaultOptionsJSON")
    public String getNonDefaultOptionsJSON() {
        return nonDefaultOptionsJSON;
    }

    @JsonProperty("nonDefaultOptionsJSON")
    public void setNonDefaultOptionsJSON(String nonDefaultOptionsJSON) {
        this.nonDefaultOptionsJSON = nonDefaultOptionsJSON;
    }

    public Profile withNonDefaultOptionsJSON(String nonDefaultOptionsJSON) {
        this.nonDefaultOptionsJSON = nonDefaultOptionsJSON;
        return this;
    }

    @JsonProperty("datasetProfile")
    public List<DatasetProfile> getDatasetProfile() {
        return datasetProfile;
    }

    @JsonProperty("datasetProfile")
    public void setDatasetProfile(List<DatasetProfile> datasetProfile) {
        this.datasetProfile = datasetProfile;
    }

    public Profile withDatasetProfile(List<DatasetProfile> datasetProfile) {
        this.datasetProfile = datasetProfile;
        return this;
    }

    @JsonProperty("nodeProfile")
    public List<NodeProfile> getNodeProfile() {
        return nodeProfile;
    }

    @JsonProperty("nodeProfile")
    public void setNodeProfile(List<NodeProfile> nodeProfile) {
        this.nodeProfile = nodeProfile;
    }

    public Profile withNodeProfile(List<NodeProfile> nodeProfile) {
        this.nodeProfile = nodeProfile;
        return this;
    }

    @JsonProperty("dremioVersion")
    public String getDremioVersion() {
        return dremioVersion;
    }

    @JsonProperty("dremioVersion")
    public void setDremioVersion(String dremioVersion) {
        this.dremioVersion = dremioVersion;
    }

    public Profile withDremioVersion(String dremioVersion) {
        this.dremioVersion = dremioVersion;
        return this;
    }

    @JsonProperty("operatorTypeMetricsMap")
    public OperatorTypeMetricsMap getOperatorTypeMetricsMap() {
        return operatorTypeMetricsMap;
    }

    @JsonProperty("operatorTypeMetricsMap")
    public void setOperatorTypeMetricsMap(OperatorTypeMetricsMap operatorTypeMetricsMap) {
        this.operatorTypeMetricsMap = operatorTypeMetricsMap;
    }

    public Profile withOperatorTypeMetricsMap(OperatorTypeMetricsMap operatorTypeMetricsMap) {
        this.operatorTypeMetricsMap = operatorTypeMetricsMap;
        return this;
    }

    @JsonProperty("resourceSchedulingProfile")
    public ResourceSchedulingProfile getResourceSchedulingProfile() {
        return resourceSchedulingProfile;
    }

    @JsonProperty("resourceSchedulingProfile")
    public void setResourceSchedulingProfile(ResourceSchedulingProfile resourceSchedulingProfile) {
        this.resourceSchedulingProfile = resourceSchedulingProfile;
    }

    public Profile withResourceSchedulingProfile(ResourceSchedulingProfile resourceSchedulingProfile) {
        this.resourceSchedulingProfile = resourceSchedulingProfile;
        return this;
    }

    @JsonProperty("commandPoolWaitMillis")
    public long getCommandPoolWaitMillis() {
        return commandPoolWaitMillis;
    }

    @JsonProperty("commandPoolWaitMillis")
    public void setCommandPoolWaitMillis(long commandPoolWaitMillis) {
        this.commandPoolWaitMillis = commandPoolWaitMillis;
    }

    public Profile withCommandPoolWaitMillis(long commandPoolWaitMillis) {
        this.commandPoolWaitMillis = commandPoolWaitMillis;
        return this;
    }

    @JsonProperty("stateList")
    public List<State> getStateList() {
        return stateList;
    }

    @JsonProperty("stateList")
    public void setStateList(List<State> stateList) {
        this.stateList = stateList;
    }

    public Profile withStateList(List<State> stateList) {
        this.stateList = stateList;
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

    public Profile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Profile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("start");
        sb.append('=');
        sb.append(this.start);
        sb.append(',');
        sb.append("end");
        sb.append('=');
        sb.append(this.end);
        sb.append(',');
        sb.append("query");
        sb.append('=');
        sb.append(((this.query == null)?"<null>":this.query));
        sb.append(',');
        sb.append("plan");
        sb.append('=');
        sb.append(((this.plan == null)?"<null>":this.plan));
        sb.append(',');
        sb.append("foreman");
        sb.append('=');
        sb.append(((this.foreman == null)?"<null>":this.foreman));
        sb.append(',');
        sb.append("state");
        sb.append('=');
        sb.append(this.state);
        sb.append(',');
        sb.append("totalFragments");
        sb.append('=');
        sb.append(this.totalFragments);
        sb.append(',');
        sb.append("finishedFragments");
        sb.append('=');
        sb.append(this.finishedFragments);
        sb.append(',');
        sb.append("fragmentProfile");
        sb.append('=');
        sb.append(((this.fragmentProfile == null)?"<null>":this.fragmentProfile));
        sb.append(',');
        sb.append("user");
        sb.append('=');
        sb.append(((this.user == null)?"<null>":this.user));
        sb.append(',');
        sb.append("planningStart");
        sb.append('=');
        sb.append(this.planningStart);
        sb.append(',');
        sb.append("planningEnd");
        sb.append('=');
        sb.append(this.planningEnd);
        sb.append(',');
        sb.append("jsonPlan");
        sb.append('=');
        sb.append(((this.jsonPlan == null)?"<null>":this.jsonPlan));
        sb.append(',');
        sb.append("clientInfo");
        sb.append('=');
        sb.append(((this.clientInfo == null)?"<null>":this.clientInfo));
        sb.append(',');
        sb.append("planPhases");
        sb.append('=');
        sb.append(((this.planPhases == null)?"<null>":this.planPhases));
        sb.append(',');
        sb.append("accelerationProfile");
        sb.append('=');
        sb.append(((this.accelerationProfile == null)?"<null>":this.accelerationProfile));
        sb.append(',');
        sb.append("fullSchema");
        sb.append('=');
        sb.append(((this.fullSchema == null)?"<null>":this.fullSchema));
        sb.append(',');
        sb.append("nonDefaultOptionsJSON");
        sb.append('=');
        sb.append(((this.nonDefaultOptionsJSON == null)?"<null>":this.nonDefaultOptionsJSON));
        sb.append(',');
        sb.append("datasetProfile");
        sb.append('=');
        sb.append(((this.datasetProfile == null)?"<null>":this.datasetProfile));
        sb.append(',');
        sb.append("nodeProfile");
        sb.append('=');
        sb.append(((this.nodeProfile == null)?"<null>":this.nodeProfile));
        sb.append(',');
        sb.append("dremioVersion");
        sb.append('=');
        sb.append(((this.dremioVersion == null)?"<null>":this.dremioVersion));
        sb.append(',');
        sb.append("operatorTypeMetricsMap");
        sb.append('=');
        sb.append(((this.operatorTypeMetricsMap == null)?"<null>":this.operatorTypeMetricsMap));
        sb.append(',');
        sb.append("resourceSchedulingProfile");
        sb.append('=');
        sb.append(((this.resourceSchedulingProfile == null)?"<null>":this.resourceSchedulingProfile));
        sb.append(',');
        sb.append("commandPoolWaitMillis");
        sb.append('=');
        sb.append(this.commandPoolWaitMillis);
        sb.append(',');
        sb.append("stateList");
        sb.append('=');
        sb.append(((this.stateList == null)?"<null>":this.stateList));
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
        result = ((result* 31)+((this.operatorTypeMetricsMap == null)? 0 :this.operatorTypeMetricsMap.hashCode()));
        result = ((result* 31)+((this.foreman == null)? 0 :this.foreman.hashCode()));
        result = ((result* 31)+((this.planPhases == null)? 0 :this.planPhases.hashCode()));
        result = ((result* 31)+((int)(this.finishedFragments^(this.finishedFragments >>> 32))));
        result = ((result* 31)+((int)(this.commandPoolWaitMillis^(this.commandPoolWaitMillis >>> 32))));
        result = ((result* 31)+((this.fragmentProfile == null)? 0 :this.fragmentProfile.hashCode()));
        result = ((result* 31)+((int)(this.end^(this.end >>> 32))));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((int)(this.state^(this.state >>> 32))));
        result = ((result* 31)+((this.plan == null)? 0 :this.plan.hashCode()));
        result = ((result* 31)+((int)(this.totalFragments^(this.totalFragments >>> 32))));
        result = ((result* 31)+((this.nonDefaultOptionsJSON == null)? 0 :this.nonDefaultOptionsJSON.hashCode()));
        result = ((result* 31)+((this.query == null)? 0 :this.query.hashCode()));
        result = ((result* 31)+((this.stateList == null)? 0 :this.stateList.hashCode()));
        result = ((result* 31)+((int)(this.start^(this.start >>> 32))));
        result = ((result* 31)+((this.clientInfo == null)? 0 :this.clientInfo.hashCode()));
        result = ((result* 31)+((this.datasetProfile == null)? 0 :this.datasetProfile.hashCode()));
        result = ((result* 31)+((this.accelerationProfile == null)? 0 :this.accelerationProfile.hashCode()));
        result = ((result* 31)+((int)(this.planningEnd^(this.planningEnd >>> 32))));
        result = ((result* 31)+((this.nodeProfile == null)? 0 :this.nodeProfile.hashCode()));
        result = ((result* 31)+((int)(this.planningStart^(this.planningStart >>> 32))));
        result = ((result* 31)+((this.jsonPlan == null)? 0 :this.jsonPlan.hashCode()));
        result = ((result* 31)+((this.dremioVersion == null)? 0 :this.dremioVersion.hashCode()));
        result = ((result* 31)+((this.resourceSchedulingProfile == null)? 0 :this.resourceSchedulingProfile.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((this.user == null)? 0 :this.user.hashCode()));
        result = ((result* 31)+((this.fullSchema == null)? 0 :this.fullSchema.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Profile) == false) {
            return false;
        }
        Profile rhs = ((Profile) other);
        return ((((((((((((((((((((((((((((this.operatorTypeMetricsMap == rhs.operatorTypeMetricsMap)||((this.operatorTypeMetricsMap!= null)&&this.operatorTypeMetricsMap.equals(rhs.operatorTypeMetricsMap)))&&((this.foreman == rhs.foreman)||((this.foreman!= null)&&this.foreman.equals(rhs.foreman))))&&((this.planPhases == rhs.planPhases)||((this.planPhases!= null)&&this.planPhases.equals(rhs.planPhases))))&&(this.finishedFragments == rhs.finishedFragments))&&(this.commandPoolWaitMillis == rhs.commandPoolWaitMillis))&&((this.fragmentProfile == rhs.fragmentProfile)||((this.fragmentProfile!= null)&&this.fragmentProfile.equals(rhs.fragmentProfile))))&&(this.end == rhs.end))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&(this.state == rhs.state))&&((this.plan == rhs.plan)||((this.plan!= null)&&this.plan.equals(rhs.plan))))&&(this.totalFragments == rhs.totalFragments))&&((this.nonDefaultOptionsJSON == rhs.nonDefaultOptionsJSON)||((this.nonDefaultOptionsJSON!= null)&&this.nonDefaultOptionsJSON.equals(rhs.nonDefaultOptionsJSON))))&&((this.query == rhs.query)||((this.query!= null)&&this.query.equals(rhs.query))))&&((this.stateList == rhs.stateList)||((this.stateList!= null)&&this.stateList.equals(rhs.stateList))))&&(this.start == rhs.start))&&((this.clientInfo == rhs.clientInfo)||((this.clientInfo!= null)&&this.clientInfo.equals(rhs.clientInfo))))&&((this.datasetProfile == rhs.datasetProfile)||((this.datasetProfile!= null)&&this.datasetProfile.equals(rhs.datasetProfile))))&&((this.accelerationProfile == rhs.accelerationProfile)||((this.accelerationProfile!= null)&&this.accelerationProfile.equals(rhs.accelerationProfile))))&&(this.planningEnd == rhs.planningEnd))&&((this.nodeProfile == rhs.nodeProfile)||((this.nodeProfile!= null)&&this.nodeProfile.equals(rhs.nodeProfile))))&&(this.planningStart == rhs.planningStart))&&((this.jsonPlan == rhs.jsonPlan)||((this.jsonPlan!= null)&&this.jsonPlan.equals(rhs.jsonPlan))))&&((this.dremioVersion == rhs.dremioVersion)||((this.dremioVersion!= null)&&this.dremioVersion.equals(rhs.dremioVersion))))&&((this.resourceSchedulingProfile == rhs.resourceSchedulingProfile)||((this.resourceSchedulingProfile!= null)&&this.resourceSchedulingProfile.equals(rhs.resourceSchedulingProfile))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&((this.user == rhs.user)||((this.user!= null)&&this.user.equals(rhs.user))))&&((this.fullSchema == rhs.fullSchema)||((this.fullSchema!= null)&&this.fullSchema.equals(rhs.fullSchema))));
    }

}
