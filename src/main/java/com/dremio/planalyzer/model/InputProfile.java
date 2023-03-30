
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
    "records",
    "batches",
    "size"
})
@Generated("jsonschema2pojo")
public class InputProfile {

    @JsonProperty("records")
    private long records;
    @JsonProperty("batches")
    private long batches;
    @JsonProperty("size")
    private long size;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("records")
    public long getRecords() {
        return records;
    }

    @JsonProperty("records")
    public void setRecords(long records) {
        this.records = records;
    }

    public InputProfile withRecords(long records) {
        this.records = records;
        return this;
    }

    @JsonProperty("batches")
    public long getBatches() {
        return batches;
    }

    @JsonProperty("batches")
    public void setBatches(long batches) {
        this.batches = batches;
    }

    public InputProfile withBatches(long batches) {
        this.batches = batches;
        return this;
    }

    @JsonProperty("size")
    public long getSize() {
        return size;
    }

    @JsonProperty("size")
    public void setSize(long size) {
        this.size = size;
    }

    public InputProfile withSize(long size) {
        this.size = size;
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

    public InputProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(InputProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("records");
        sb.append('=');
        sb.append(this.records);
        sb.append(',');
        sb.append("batches");
        sb.append('=');
        sb.append(this.batches);
        sb.append(',');
        sb.append("size");
        sb.append('=');
        sb.append(this.size);
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
        result = ((result* 31)+((int)(this.batches^(this.batches >>> 32))));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.size^(this.size >>> 32))));
        result = ((result* 31)+((int)(this.records^(this.records >>> 32))));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof InputProfile) == false) {
            return false;
        }
        InputProfile rhs = ((InputProfile) other);
        return ((((this.batches == rhs.batches)&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.size == rhs.size))&&(this.records == rhs.records));
    }

}
