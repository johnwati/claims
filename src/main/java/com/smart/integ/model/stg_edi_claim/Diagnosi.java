
package com.smart.integ.model.stg_edi_claim;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "coding_standard",
    "code",
    "name",
    "is_primary"
})
public class Diagnosi implements Serializable
{

    @JsonProperty("coding_standard")
    private String codingStandard;
    @JsonProperty("code")
    private String code;
    @JsonProperty("name")
    private String name;
    @JsonProperty("is_primary")
    private String isPrimary;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 2364646571153989640L;

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
     */
    public Diagnosi(String codingStandard, String code, String name, String isPrimary) {
        super();
        this.codingStandard = codingStandard;
        this.code = code;
        this.name = name;
        this.isPrimary = isPrimary;
    }

    @JsonProperty("coding_standard")
    public String getCodingStandard() {
        return codingStandard;
    }

    @JsonProperty("coding_standard")
    public void setCodingStandard(String codingStandard) {
        this.codingStandard = codingStandard;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    @JsonProperty("is_primary")
    public String getIsPrimary() {
        return isPrimary;
    }

    @JsonProperty("is_primary")
    public void setIsPrimary(String isPrimary) {
        this.isPrimary = isPrimary;
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
        return new ToStringBuilder(this).append("codingStandard", codingStandard).append("code", code).append("name", name).append("isPrimary", isPrimary).append("additionalProperties", additionalProperties).toString();
    }

}
