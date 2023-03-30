
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
    "state",
    "minorFragmentId",
    "operatorProfile",
    "startTime",
    "endTime",
    "memoryUsed",
    "maxMemoryUsed",
    "endpoint",
    "lastUpdate",
    "lastProgress",
    "sleepingDuration",
    "blockedDuration",
    "firstRun",
    "runDuration",
    "numRuns",
    "setupDuration",
    "finishDuration",
    "blockedOnUpstreamDuration",
    "blockedOnDownstreamDuration",
    "blockedOnSharedResourceDuration",
    "perResourceBlockedDuration"
})
@Generated("jsonschema2pojo")
public class MinorFragmentProfile {

    @JsonProperty("state")
    private long state;
    @JsonProperty("minorFragmentId")
    private long minorFragmentId;
    @JsonProperty("operatorProfile")
    private List<OperatorProfile> operatorProfile = new ArrayList<OperatorProfile>();
    @JsonProperty("startTime")
    private long startTime;
    @JsonProperty("endTime")
    private long endTime;
    @JsonProperty("memoryUsed")
    private long memoryUsed;
    @JsonProperty("maxMemoryUsed")
    private long maxMemoryUsed;
    @JsonProperty("endpoint")
    private Endpoint endpoint;
    @JsonProperty("lastUpdate")
    private long lastUpdate;
    @JsonProperty("lastProgress")
    private long lastProgress;
    @JsonProperty("sleepingDuration")
    private long sleepingDuration;
    @JsonProperty("blockedDuration")
    private long blockedDuration;
    @JsonProperty("firstRun")
    private long firstRun;
    @JsonProperty("runDuration")
    private long runDuration;
    @JsonProperty("numRuns")
    private long numRuns;
    @JsonProperty("setupDuration")
    private long setupDuration;
    @JsonProperty("finishDuration")
    private long finishDuration;
    @JsonProperty("blockedOnUpstreamDuration")
    private long blockedOnUpstreamDuration;
    @JsonProperty("blockedOnDownstreamDuration")
    private long blockedOnDownstreamDuration;
    @JsonProperty("blockedOnSharedResourceDuration")
    private long blockedOnSharedResourceDuration;
    @JsonProperty("perResourceBlockedDuration")
    private List<PerResourceBlockedDuration> perResourceBlockedDuration = new ArrayList<PerResourceBlockedDuration>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("state")
    public long getState() {
        return state;
    }

    @JsonProperty("state")
    public void setState(long state) {
        this.state = state;
    }

    public MinorFragmentProfile withState(long state) {
        this.state = state;
        return this;
    }

    @JsonProperty("minorFragmentId")
    public long getMinorFragmentId() {
        return minorFragmentId;
    }

    @JsonProperty("minorFragmentId")
    public void setMinorFragmentId(long minorFragmentId) {
        this.minorFragmentId = minorFragmentId;
    }

    public MinorFragmentProfile withMinorFragmentId(long minorFragmentId) {
        this.minorFragmentId = minorFragmentId;
        return this;
    }

    @JsonProperty("operatorProfile")
    public List<OperatorProfile> getOperatorProfile() {
        return operatorProfile;
    }

    @JsonProperty("operatorProfile")
    public void setOperatorProfile(List<OperatorProfile> operatorProfile) {
        this.operatorProfile = operatorProfile;
    }

    public MinorFragmentProfile withOperatorProfile(List<OperatorProfile> operatorProfile) {
        this.operatorProfile = operatorProfile;
        return this;
    }

    @JsonProperty("startTime")
    public long getStartTime() {
        return startTime;
    }

    @JsonProperty("startTime")
    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public MinorFragmentProfile withStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsonProperty("endTime")
    public long getEndTime() {
        return endTime;
    }

    @JsonProperty("endTime")
    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public MinorFragmentProfile withEndTime(long endTime) {
        this.endTime = endTime;
        return this;
    }

    @JsonProperty("memoryUsed")
    public long getMemoryUsed() {
        return memoryUsed;
    }

    @JsonProperty("memoryUsed")
    public void setMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
    }

    public MinorFragmentProfile withMemoryUsed(long memoryUsed) {
        this.memoryUsed = memoryUsed;
        return this;
    }

    @JsonProperty("maxMemoryUsed")
    public long getMaxMemoryUsed() {
        return maxMemoryUsed;
    }

    @JsonProperty("maxMemoryUsed")
    public void setMaxMemoryUsed(long maxMemoryUsed) {
        this.maxMemoryUsed = maxMemoryUsed;
    }

    public MinorFragmentProfile withMaxMemoryUsed(long maxMemoryUsed) {
        this.maxMemoryUsed = maxMemoryUsed;
        return this;
    }

    @JsonProperty("endpoint")
    public Endpoint getEndpoint() {
        return endpoint;
    }

    @JsonProperty("endpoint")
    public void setEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
    }

    public MinorFragmentProfile withEndpoint(Endpoint endpoint) {
        this.endpoint = endpoint;
        return this;
    }

    @JsonProperty("lastUpdate")
    public long getLastUpdate() {
        return lastUpdate;
    }

    @JsonProperty("lastUpdate")
    public void setLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public MinorFragmentProfile withLastUpdate(long lastUpdate) {
        this.lastUpdate = lastUpdate;
        return this;
    }

    @JsonProperty("lastProgress")
    public long getLastProgress() {
        return lastProgress;
    }

    @JsonProperty("lastProgress")
    public void setLastProgress(long lastProgress) {
        this.lastProgress = lastProgress;
    }

    public MinorFragmentProfile withLastProgress(long lastProgress) {
        this.lastProgress = lastProgress;
        return this;
    }

    @JsonProperty("sleepingDuration")
    public long getSleepingDuration() {
        return sleepingDuration;
    }

    @JsonProperty("sleepingDuration")
    public void setSleepingDuration(long sleepingDuration) {
        this.sleepingDuration = sleepingDuration;
    }

    public MinorFragmentProfile withSleepingDuration(long sleepingDuration) {
        this.sleepingDuration = sleepingDuration;
        return this;
    }

    @JsonProperty("blockedDuration")
    public long getBlockedDuration() {
        return blockedDuration;
    }

    @JsonProperty("blockedDuration")
    public void setBlockedDuration(long blockedDuration) {
        this.blockedDuration = blockedDuration;
    }

    public MinorFragmentProfile withBlockedDuration(long blockedDuration) {
        this.blockedDuration = blockedDuration;
        return this;
    }

    @JsonProperty("firstRun")
    public long getFirstRun() {
        return firstRun;
    }

    @JsonProperty("firstRun")
    public void setFirstRun(long firstRun) {
        this.firstRun = firstRun;
    }

    public MinorFragmentProfile withFirstRun(long firstRun) {
        this.firstRun = firstRun;
        return this;
    }

    @JsonProperty("runDuration")
    public long getRunDuration() {
        return runDuration;
    }

    @JsonProperty("runDuration")
    public void setRunDuration(long runDuration) {
        this.runDuration = runDuration;
    }

    public MinorFragmentProfile withRunDuration(long runDuration) {
        this.runDuration = runDuration;
        return this;
    }

    @JsonProperty("numRuns")
    public long getNumRuns() {
        return numRuns;
    }

    @JsonProperty("numRuns")
    public void setNumRuns(long numRuns) {
        this.numRuns = numRuns;
    }

    public MinorFragmentProfile withNumRuns(long numRuns) {
        this.numRuns = numRuns;
        return this;
    }

    @JsonProperty("setupDuration")
    public long getSetupDuration() {
        return setupDuration;
    }

    @JsonProperty("setupDuration")
    public void setSetupDuration(long setupDuration) {
        this.setupDuration = setupDuration;
    }

    public MinorFragmentProfile withSetupDuration(long setupDuration) {
        this.setupDuration = setupDuration;
        return this;
    }

    @JsonProperty("finishDuration")
    public long getFinishDuration() {
        return finishDuration;
    }

    @JsonProperty("finishDuration")
    public void setFinishDuration(long finishDuration) {
        this.finishDuration = finishDuration;
    }

    public MinorFragmentProfile withFinishDuration(long finishDuration) {
        this.finishDuration = finishDuration;
        return this;
    }

    @JsonProperty("blockedOnUpstreamDuration")
    public long getBlockedOnUpstreamDuration() {
        return blockedOnUpstreamDuration;
    }

    @JsonProperty("blockedOnUpstreamDuration")
    public void setBlockedOnUpstreamDuration(long blockedOnUpstreamDuration) {
        this.blockedOnUpstreamDuration = blockedOnUpstreamDuration;
    }

    public MinorFragmentProfile withBlockedOnUpstreamDuration(long blockedOnUpstreamDuration) {
        this.blockedOnUpstreamDuration = blockedOnUpstreamDuration;
        return this;
    }

    @JsonProperty("blockedOnDownstreamDuration")
    public long getBlockedOnDownstreamDuration() {
        return blockedOnDownstreamDuration;
    }

    @JsonProperty("blockedOnDownstreamDuration")
    public void setBlockedOnDownstreamDuration(long blockedOnDownstreamDuration) {
        this.blockedOnDownstreamDuration = blockedOnDownstreamDuration;
    }

    public MinorFragmentProfile withBlockedOnDownstreamDuration(long blockedOnDownstreamDuration) {
        this.blockedOnDownstreamDuration = blockedOnDownstreamDuration;
        return this;
    }

    @JsonProperty("blockedOnSharedResourceDuration")
    public long getBlockedOnSharedResourceDuration() {
        return blockedOnSharedResourceDuration;
    }

    @JsonProperty("blockedOnSharedResourceDuration")
    public void setBlockedOnSharedResourceDuration(long blockedOnSharedResourceDuration) {
        this.blockedOnSharedResourceDuration = blockedOnSharedResourceDuration;
    }

    public MinorFragmentProfile withBlockedOnSharedResourceDuration(long blockedOnSharedResourceDuration) {
        this.blockedOnSharedResourceDuration = blockedOnSharedResourceDuration;
        return this;
    }

    @JsonProperty("perResourceBlockedDuration")
    public List<PerResourceBlockedDuration> getPerResourceBlockedDuration() {
        return perResourceBlockedDuration;
    }

    @JsonProperty("perResourceBlockedDuration")
    public void setPerResourceBlockedDuration(List<PerResourceBlockedDuration> perResourceBlockedDuration) {
        this.perResourceBlockedDuration = perResourceBlockedDuration;
    }

    public MinorFragmentProfile withPerResourceBlockedDuration(List<PerResourceBlockedDuration> perResourceBlockedDuration) {
        this.perResourceBlockedDuration = perResourceBlockedDuration;
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

    public MinorFragmentProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(MinorFragmentProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("state");
        sb.append('=');
        sb.append(this.state);
        sb.append(',');
        sb.append("minorFragmentId");
        sb.append('=');
        sb.append(this.minorFragmentId);
        sb.append(',');
        sb.append("operatorProfile");
        sb.append('=');
        sb.append(((this.operatorProfile == null)?"<null>":this.operatorProfile));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(this.startTime);
        sb.append(',');
        sb.append("endTime");
        sb.append('=');
        sb.append(this.endTime);
        sb.append(',');
        sb.append("memoryUsed");
        sb.append('=');
        sb.append(this.memoryUsed);
        sb.append(',');
        sb.append("maxMemoryUsed");
        sb.append('=');
        sb.append(this.maxMemoryUsed);
        sb.append(',');
        sb.append("endpoint");
        sb.append('=');
        sb.append(((this.endpoint == null)?"<null>":this.endpoint));
        sb.append(',');
        sb.append("lastUpdate");
        sb.append('=');
        sb.append(this.lastUpdate);
        sb.append(',');
        sb.append("lastProgress");
        sb.append('=');
        sb.append(this.lastProgress);
        sb.append(',');
        sb.append("sleepingDuration");
        sb.append('=');
        sb.append(this.sleepingDuration);
        sb.append(',');
        sb.append("blockedDuration");
        sb.append('=');
        sb.append(this.blockedDuration);
        sb.append(',');
        sb.append("firstRun");
        sb.append('=');
        sb.append(this.firstRun);
        sb.append(',');
        sb.append("runDuration");
        sb.append('=');
        sb.append(this.runDuration);
        sb.append(',');
        sb.append("numRuns");
        sb.append('=');
        sb.append(this.numRuns);
        sb.append(',');
        sb.append("setupDuration");
        sb.append('=');
        sb.append(this.setupDuration);
        sb.append(',');
        sb.append("finishDuration");
        sb.append('=');
        sb.append(this.finishDuration);
        sb.append(',');
        sb.append("blockedOnUpstreamDuration");
        sb.append('=');
        sb.append(this.blockedOnUpstreamDuration);
        sb.append(',');
        sb.append("blockedOnDownstreamDuration");
        sb.append('=');
        sb.append(this.blockedOnDownstreamDuration);
        sb.append(',');
        sb.append("blockedOnSharedResourceDuration");
        sb.append('=');
        sb.append(this.blockedOnSharedResourceDuration);
        sb.append(',');
        sb.append("perResourceBlockedDuration");
        sb.append('=');
        sb.append(((this.perResourceBlockedDuration == null)?"<null>":this.perResourceBlockedDuration));
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
        result = ((result* 31)+((int)(this.finishDuration^(this.finishDuration >>> 32))));
        result = ((result* 31)+((int)(this.firstRun^(this.firstRun >>> 32))));
        result = ((result* 31)+((int)(this.setupDuration^(this.setupDuration >>> 32))));
        result = ((result* 31)+((this.operatorProfile == null)? 0 :this.operatorProfile.hashCode()));
        result = ((result* 31)+((int)(this.blockedOnSharedResourceDuration^(this.blockedOnSharedResourceDuration >>> 32))));
        result = ((result* 31)+((int)(this.blockedOnUpstreamDuration^(this.blockedOnUpstreamDuration >>> 32))));
        result = ((result* 31)+((int)(this.lastProgress^(this.lastProgress >>> 32))));
        result = ((result* 31)+((this.perResourceBlockedDuration == null)? 0 :this.perResourceBlockedDuration.hashCode()));
        result = ((result* 31)+((int)(this.memoryUsed^(this.memoryUsed >>> 32))));
        result = ((result* 31)+((int)(this.blockedOnDownstreamDuration^(this.blockedOnDownstreamDuration >>> 32))));
        result = ((result* 31)+((int)(this.runDuration^(this.runDuration >>> 32))));
        result = ((result* 31)+((this.endpoint == null)? 0 :this.endpoint.hashCode()));
        result = ((result* 31)+((int)(this.maxMemoryUsed^(this.maxMemoryUsed >>> 32))));
        result = ((result* 31)+((int)(this.minorFragmentId^(this.minorFragmentId >>> 32))));
        result = ((result* 31)+((int)(this.numRuns^(this.numRuns >>> 32))));
        result = ((result* 31)+((int)(this.lastUpdate^(this.lastUpdate >>> 32))));
        result = ((result* 31)+((int)(this.startTime^(this.startTime >>> 32))));
        result = ((result* 31)+((int)(this.sleepingDuration^(this.sleepingDuration >>> 32))));
        result = ((result* 31)+((int)(this.state^(this.state >>> 32))));
        result = ((result* 31)+((int)(this.endTime^(this.endTime >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.blockedDuration^(this.blockedDuration >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof MinorFragmentProfile) == false) {
            return false;
        }
        MinorFragmentProfile rhs = ((MinorFragmentProfile) other);
        return ((((((((((((((((((((((this.finishDuration == rhs.finishDuration)&&(this.firstRun == rhs.firstRun))&&(this.setupDuration == rhs.setupDuration))&&((this.operatorProfile == rhs.operatorProfile)||((this.operatorProfile!= null)&&this.operatorProfile.equals(rhs.operatorProfile))))&&(this.blockedOnSharedResourceDuration == rhs.blockedOnSharedResourceDuration))&&(this.blockedOnUpstreamDuration == rhs.blockedOnUpstreamDuration))&&(this.lastProgress == rhs.lastProgress))&&((this.perResourceBlockedDuration == rhs.perResourceBlockedDuration)||((this.perResourceBlockedDuration!= null)&&this.perResourceBlockedDuration.equals(rhs.perResourceBlockedDuration))))&&(this.memoryUsed == rhs.memoryUsed))&&(this.blockedOnDownstreamDuration == rhs.blockedOnDownstreamDuration))&&(this.runDuration == rhs.runDuration))&&((this.endpoint == rhs.endpoint)||((this.endpoint!= null)&&this.endpoint.equals(rhs.endpoint))))&&(this.maxMemoryUsed == rhs.maxMemoryUsed))&&(this.minorFragmentId == rhs.minorFragmentId))&&(this.numRuns == rhs.numRuns))&&(this.lastUpdate == rhs.lastUpdate))&&(this.startTime == rhs.startTime))&&(this.sleepingDuration == rhs.sleepingDuration))&&(this.state == rhs.state))&&(this.endTime == rhs.endTime))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.blockedDuration == rhs.blockedDuration));
    }

}
