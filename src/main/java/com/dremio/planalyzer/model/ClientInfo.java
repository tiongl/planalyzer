
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
    "name",
    "version",
    "majorVersion",
    "minorVersion",
    "patchVersion",
    "application",
    "buildNumber",
    "versionQualifier"
})
@Generated("jsonschema2pojo")
public class ClientInfo {

    @JsonProperty("name")
    private String name;
    @JsonProperty("version")
    private String version;
    @JsonProperty("majorVersion")
    private long majorVersion;
    @JsonProperty("minorVersion")
    private long minorVersion;
    @JsonProperty("patchVersion")
    private long patchVersion;
    @JsonProperty("application")
    private String application;
    @JsonProperty("buildNumber")
    private long buildNumber;
    @JsonProperty("versionQualifier")
    private String versionQualifier;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public ClientInfo withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    public ClientInfo withVersion(String version) {
        this.version = version;
        return this;
    }

    @JsonProperty("majorVersion")
    public long getMajorVersion() {
        return majorVersion;
    }

    @JsonProperty("majorVersion")
    public void setMajorVersion(long majorVersion) {
        this.majorVersion = majorVersion;
    }

    public ClientInfo withMajorVersion(long majorVersion) {
        this.majorVersion = majorVersion;
        return this;
    }

    @JsonProperty("minorVersion")
    public long getMinorVersion() {
        return minorVersion;
    }

    @JsonProperty("minorVersion")
    public void setMinorVersion(long minorVersion) {
        this.minorVersion = minorVersion;
    }

    public ClientInfo withMinorVersion(long minorVersion) {
        this.minorVersion = minorVersion;
        return this;
    }

    @JsonProperty("patchVersion")
    public long getPatchVersion() {
        return patchVersion;
    }

    @JsonProperty("patchVersion")
    public void setPatchVersion(long patchVersion) {
        this.patchVersion = patchVersion;
    }

    public ClientInfo withPatchVersion(long patchVersion) {
        this.patchVersion = patchVersion;
        return this;
    }

    @JsonProperty("application")
    public String getApplication() {
        return application;
    }

    @JsonProperty("application")
    public void setApplication(String application) {
        this.application = application;
    }

    public ClientInfo withApplication(String application) {
        this.application = application;
        return this;
    }

    @JsonProperty("buildNumber")
    public long getBuildNumber() {
        return buildNumber;
    }

    @JsonProperty("buildNumber")
    public void setBuildNumber(long buildNumber) {
        this.buildNumber = buildNumber;
    }

    public ClientInfo withBuildNumber(long buildNumber) {
        this.buildNumber = buildNumber;
        return this;
    }

    @JsonProperty("versionQualifier")
    public String getVersionQualifier() {
        return versionQualifier;
    }

    @JsonProperty("versionQualifier")
    public void setVersionQualifier(String versionQualifier) {
        this.versionQualifier = versionQualifier;
    }

    public ClientInfo withVersionQualifier(String versionQualifier) {
        this.versionQualifier = versionQualifier;
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

    public ClientInfo withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(ClientInfo.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("version");
        sb.append('=');
        sb.append(((this.version == null)?"<null>":this.version));
        sb.append(',');
        sb.append("majorVersion");
        sb.append('=');
        sb.append(this.majorVersion);
        sb.append(',');
        sb.append("minorVersion");
        sb.append('=');
        sb.append(this.minorVersion);
        sb.append(',');
        sb.append("patchVersion");
        sb.append('=');
        sb.append(this.patchVersion);
        sb.append(',');
        sb.append("application");
        sb.append('=');
        sb.append(((this.application == null)?"<null>":this.application));
        sb.append(',');
        sb.append("buildNumber");
        sb.append('=');
        sb.append(this.buildNumber);
        sb.append(',');
        sb.append("versionQualifier");
        sb.append('=');
        sb.append(((this.versionQualifier == null)?"<null>":this.versionQualifier));
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
        result = ((result* 31)+((this.versionQualifier == null)? 0 :this.versionQualifier.hashCode()));
        result = ((result* 31)+((this.application == null)? 0 :this.application.hashCode()));
        result = ((result* 31)+((int)(this.patchVersion^(this.patchVersion >>> 32))));
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.majorVersion^(this.majorVersion >>> 32))));
        result = ((result* 31)+((int)(this.minorVersion^(this.minorVersion >>> 32))));
        result = ((result* 31)+((this.version == null)? 0 :this.version.hashCode()));
        result = ((result* 31)+((int)(this.buildNumber^(this.buildNumber >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ClientInfo) == false) {
            return false;
        }
        ClientInfo rhs = ((ClientInfo) other);
        return ((((((((((this.versionQualifier == rhs.versionQualifier)||((this.versionQualifier!= null)&&this.versionQualifier.equals(rhs.versionQualifier)))&&((this.application == rhs.application)||((this.application!= null)&&this.application.equals(rhs.application))))&&(this.patchVersion == rhs.patchVersion))&&((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.majorVersion == rhs.majorVersion))&&(this.minorVersion == rhs.minorVersion))&&((this.version == rhs.version)||((this.version!= null)&&this.version.equals(rhs.version))))&&(this.buildNumber == rhs.buildNumber));
    }

}
