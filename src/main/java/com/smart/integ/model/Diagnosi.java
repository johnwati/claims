
package com.smart.integ.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "is_primary",
    "code",
    "coding_standard",
    "name",
    "id"
})
public class Diagnosi implements Serializable
{

    @JsonProperty("is_primary")
    private Integer isPrimary;
    @JsonProperty("code")
    private String code;
    @JsonProperty("coding_standard")
    private String codingStandard;
    @JsonProperty("name")
    private String name;
    @JsonProperty("id")
    private Integer id;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 5031122938236293457L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Diagnosi() {
    }

    /**
     * 
     * @param codingStandard
     * @param code
     * @param isPrimary
     * @param name
     * @param id
     */
    public Diagnosi(Integer isPrimary, String code, String codingStandard, String name, Integer id) {
        super();
        this.isPrimary = isPrimary;
        this.code = code;
        this.codingStandard = codingStandard;
        this.name = name;
        this.id = id;
    }

    @JsonProperty("is_primary")
    public Integer getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("is_primary")
    public void setIsPrimary(Integer isPrimary) {
        this.isPrimary = isPrimary;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("coding_standard")
    public String getCodingStandard() {
        return codingStandard;
    }

    @JsonProperty("coding_standard")
    public void setCodingStandard(String codingStandard) {
        this.codingStandard = codingStandard;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("isPrimary", isPrimary).append("code", code).append("codingStandard", codingStandard).append("name", name).append("id", id).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(codingStandard).append(code).append(isPrimary).append(name).append(id).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Diagnosi) == false) {
            return false;
        }
        Diagnosi rhs = ((Diagnosi) other);
        return new EqualsBuilder().append(codingStandard, rhs.codingStandard).append(code, rhs.code).append(isPrimary, rhs.isPrimary).append(name, rhs.name).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
