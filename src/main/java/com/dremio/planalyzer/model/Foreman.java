
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
    "address",
    "userPort",
    "fabricPort",
    "roles",
    "startTime",
    "maxDirectMemory",
    "availableCores",
    "nodeTag",
    "conduitPort",
    "dremioVersion"
})
@Generated("jsonschema2pojo")
public class Foreman {

    @JsonProperty("address")
    private String address;
    @JsonProperty("userPort")
    private long userPort;
    @JsonProperty("fabricPort")
    private long fabricPort;
    @JsonProperty("roles")
    private Roles roles;
    @JsonProperty("startTime")
    private long startTime;
    @JsonProperty("maxDirectMemory")
    private long maxDirectMemory;
    @JsonProperty("availableCores")
    private long availableCores;
    @JsonProperty("nodeTag")
    private String nodeTag;
    @JsonProperty("conduitPort")
    private long conduitPort;
    @JsonProperty("dremioVersion")
    private String dremioVersion;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("address")
    public String getAddress() {
        return address;
    }

    @JsonProperty("address")
    public void setAddress(String address) {
        this.address = address;
    }

    public Foreman withAddress(String address) {
        this.address = address;
        return this;
    }

    @JsonProperty("userPort")
    public long getUserPort() {
        return userPort;
    }

    @JsonProperty("userPort")
    public void setUserPort(long userPort) {
        this.userPort = userPort;
    }

    public Foreman withUserPort(long userPort) {
        this.userPort = userPort;
        return this;
    }

    @JsonProperty("fabricPort")
    public long getFabricPort() {
        return fabricPort;
    }

    @JsonProperty("fabricPort")
    public void setFabricPort(long fabricPort) {
        this.fabricPort = fabricPort;
    }

    public Foreman withFabricPort(long fabricPort) {
        this.fabricPort = fabricPort;
        return this;
    }

    @JsonProperty("roles")
    public Roles getRoles() {
        return roles;
    }

    @JsonProperty("roles")
    public void setRoles(Roles roles) {
        this.roles = roles;
    }

    public Foreman withRoles(Roles roles) {
        this.roles = roles;
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

    public Foreman withStartTime(long startTime) {
        this.startTime = startTime;
        return this;
    }

    @JsonProperty("maxDirectMemory")
    public long getMaxDirectMemory() {
        return maxDirectMemory;
    }

    @JsonProperty("maxDirectMemory")
    public void setMaxDirectMemory(long maxDirectMemory) {
        this.maxDirectMemory = maxDirectMemory;
    }

    public Foreman withMaxDirectMemory(long maxDirectMemory) {
        this.maxDirectMemory = maxDirectMemory;
        return this;
    }

    @JsonProperty("availableCores")
    public long getAvailableCores() {
        return availableCores;
    }

    @JsonProperty("availableCores")
    public void setAvailableCores(long availableCores) {
        this.availableCores = availableCores;
    }

    public Foreman withAvailableCores(long availableCores) {
        this.availableCores = availableCores;
        return this;
    }

    @JsonProperty("nodeTag")
    public String getNodeTag() {
        return nodeTag;
    }

    @JsonProperty("nodeTag")
    public void setNodeTag(String nodeTag) {
        this.nodeTag = nodeTag;
    }

    public Foreman withNodeTag(String nodeTag) {
        this.nodeTag = nodeTag;
        return this;
    }

    @JsonProperty("conduitPort")
    public long getConduitPort() {
        return conduitPort;
    }

    @JsonProperty("conduitPort")
    public void setConduitPort(long conduitPort) {
        this.conduitPort = conduitPort;
    }

    public Foreman withConduitPort(long conduitPort) {
        this.conduitPort = conduitPort;
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

    public Foreman withDremioVersion(String dremioVersion) {
        this.dremioVersion = dremioVersion;
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

    public Foreman withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Foreman.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("userPort");
        sb.append('=');
        sb.append(this.userPort);
        sb.append(',');
        sb.append("fabricPort");
        sb.append('=');
        sb.append(this.fabricPort);
        sb.append(',');
        sb.append("roles");
        sb.append('=');
        sb.append(((this.roles == null)?"<null>":this.roles));
        sb.append(',');
        sb.append("startTime");
        sb.append('=');
        sb.append(this.startTime);
        sb.append(',');
        sb.append("maxDirectMemory");
        sb.append('=');
        sb.append(this.maxDirectMemory);
        sb.append(',');
        sb.append("availableCores");
        sb.append('=');
        sb.append(this.availableCores);
        sb.append(',');
        sb.append("nodeTag");
        sb.append('=');
        sb.append(((this.nodeTag == null)?"<null>":this.nodeTag));
        sb.append(',');
        sb.append("conduitPort");
        sb.append('=');
        sb.append(this.conduitPort);
        sb.append(',');
        sb.append("dremioVersion");
        sb.append('=');
        sb.append(((this.dremioVersion == null)?"<null>":this.dremioVersion));
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
        result = ((result* 31)+((int)(this.userPort^(this.userPort >>> 32))));
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((int)(this.fabricPort^(this.fabricPort >>> 32))));
        result = ((result* 31)+((this.roles == null)? 0 :this.roles.hashCode()));
        result = ((result* 31)+((this.dremioVersion == null)? 0 :this.dremioVersion.hashCode()));
        result = ((result* 31)+((int)(this.startTime^(this.startTime >>> 32))));
        result = ((result* 31)+((int)(this.conduitPort^(this.conduitPort >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.availableCores^(this.availableCores >>> 32))));
        result = ((result* 31)+((int)(this.maxDirectMemory^(this.maxDirectMemory >>> 32))));
        result = ((result* 31)+((this.nodeTag == null)? 0 :this.nodeTag.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Foreman) == false) {
            return false;
        }
        Foreman rhs = ((Foreman) other);
        return (((((((((((this.userPort == rhs.userPort)&&((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address))))&&(this.fabricPort == rhs.fabricPort))&&((this.roles == rhs.roles)||((this.roles!= null)&&this.roles.equals(rhs.roles))))&&((this.dremioVersion == rhs.dremioVersion)||((this.dremioVersion!= null)&&this.dremioVersion.equals(rhs.dremioVersion))))&&(this.startTime == rhs.startTime))&&(this.conduitPort == rhs.conduitPort))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.availableCores == rhs.availableCores))&&(this.maxDirectMemory == rhs.maxDirectMemory))&&((this.nodeTag == rhs.nodeTag)||((this.nodeTag!= null)&&this.nodeTag.equals(rhs.nodeTag))));
    }

}
