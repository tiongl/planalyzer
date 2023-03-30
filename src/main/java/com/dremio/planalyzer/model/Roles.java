
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
    "sqlQuery",
    "javaExecutor",
    "master"
})
@Generated("jsonschema2pojo")
public class Roles {

    @JsonProperty("sqlQuery")
    private boolean sqlQuery;
    @JsonProperty("javaExecutor")
    private boolean javaExecutor;
    @JsonProperty("master")
    private boolean master;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("sqlQuery")
    public boolean isSqlQuery() {
        return sqlQuery;
    }

    @JsonProperty("sqlQuery")
    public void setSqlQuery(boolean sqlQuery) {
        this.sqlQuery = sqlQuery;
    }

    public Roles withSqlQuery(boolean sqlQuery) {
        this.sqlQuery = sqlQuery;
        return this;
    }

    @JsonProperty("javaExecutor")
    public boolean isJavaExecutor() {
        return javaExecutor;
    }

    @JsonProperty("javaExecutor")
    public void setJavaExecutor(boolean javaExecutor) {
        this.javaExecutor = javaExecutor;
    }

    public Roles withJavaExecutor(boolean javaExecutor) {
        this.javaExecutor = javaExecutor;
        return this;
    }

    @JsonProperty("master")
    public boolean isMaster() {
        return master;
    }

    @JsonProperty("master")
    public void setMaster(boolean master) {
        this.master = master;
    }

    public Roles withMaster(boolean master) {
        this.master = master;
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

    public Roles withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(Roles.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("sqlQuery");
        sb.append('=');
        sb.append(this.sqlQuery);
        sb.append(',');
        sb.append("javaExecutor");
        sb.append('=');
        sb.append(this.javaExecutor);
        sb.append(',');
        sb.append("master");
        sb.append('=');
        sb.append(this.master);
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
        result = ((result* 31)+(this.javaExecutor? 1 : 0));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        result = ((result* 31)+(this.sqlQuery? 1 : 0));
        result = ((result* 31)+(this.master? 1 : 0));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Roles) == false) {
            return false;
        }
        Roles rhs = ((Roles) other);
        return ((((this.javaExecutor == rhs.javaExecutor)&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))))&&(this.sqlQuery == rhs.sqlQuery))&&(this.master == rhs.master));
    }

}
