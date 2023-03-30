
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
    "datasetPath",
    "type",
    "sql"
})
@Generated("jsonschema2pojo")
public class DatasetProfile {

    @JsonProperty("datasetPath")
    private String datasetPath;
    @JsonProperty("type")
    private long type;
    @JsonProperty("sql")
    private String sql;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("datasetPath")
    public String getDatasetPath() {
        return datasetPath;
    }

    @JsonProperty("datasetPath")
    public void setDatasetPath(String datasetPath) {
        this.datasetPath = datasetPath;
    }

    public DatasetProfile withDatasetPath(String datasetPath) {
        this.datasetPath = datasetPath;
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

    public DatasetProfile withType(long type) {
        this.type = type;
        return this;
    }

    @JsonProperty("sql")
    public String getSql() {
        return sql;
    }

    @JsonProperty("sql")
    public void setSql(String sql) {
        this.sql = sql;
    }

    public DatasetProfile withSql(String sql) {
        this.sql = sql;
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

    public DatasetProfile withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(DatasetProfile.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("datasetPath");
        sb.append('=');
        sb.append(((this.datasetPath == null)?"<null>":this.datasetPath));
        sb.append(',');
        sb.append("type");
        sb.append('=');
        sb.append(this.type);
        sb.append(',');
        sb.append("sql");
        sb.append('=');
        sb.append(((this.sql == null)?"<null>":this.sql));
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
        result = ((result* 31)+((this.datasetPath == null)? 0 :this.datasetPath.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+((int)(this.type^(this.type >>> 32))));
        result = ((result* 31)+((this.sql == null)? 0 :this.sql.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof DatasetProfile) == false) {
            return false;
        }
        DatasetProfile rhs = ((DatasetProfile) other);
        return (((((this.datasetPath == rhs.datasetPath)||((this.datasetPath!= null)&&this.datasetPath.equals(rhs.datasetPath)))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.type == rhs.type))&&((this.sql == rhs.sql)||((this.sql!= null)&&this.sql.equals(rhs.sql))));
    }

}
