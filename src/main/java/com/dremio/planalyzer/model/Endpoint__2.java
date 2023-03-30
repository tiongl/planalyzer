
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
    "fabricPort"
})
@Generated("jsonschema2pojo")
public class Endpoint__2 {

    @JsonProperty("address")
    private String address;
    @JsonProperty("fabricPort")
    private long fabricPort;
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

    public Endpoint__2 withAddress(String address) {
        this.address = address;
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

    public Endpoint__2 withFabricPort(long fabricPort) {
        this.fabricPort = fabricPort;
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

    public Endpoint__2 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Endpoint__2 .class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("address");
        sb.append('=');
        sb.append(((this.address == null)?"<null>":this.address));
        sb.append(',');
        sb.append("fabricPort");
        sb.append('=');
        sb.append(this.fabricPort);
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
        result = ((result* 31)+((this.address == null)? 0 :this.address.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.fabricPort^(this.fabricPort >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Endpoint__2) == false) {
            return false;
        }
        Endpoint__2 rhs = ((Endpoint__2) other);
        return ((((this.address == rhs.address)||((this.address!= null)&&this.address.equals(rhs.address)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.fabricPort == rhs.fabricPort));
    }

}
