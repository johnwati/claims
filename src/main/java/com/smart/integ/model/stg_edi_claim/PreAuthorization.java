
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
    "code",
    "amount",
    "authorized_by",
    "message"
})
public class PreAuthorization implements Serializable
{

    @JsonProperty("code")
    private String code;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("authorized_by")
    private String authorizedBy;
    @JsonProperty("message")
    private String message;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6185662027429857904L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PreAuthorization() {
    }

    /**
     * 
     * @param amount
     * @param code
     * @param authorizedBy
     * @param message
     */
    public PreAuthorization(String code, Integer amount, String authorizedBy, String message) {
        super();
        this.code = code;
        this.amount = amount;
        this.authorizedBy = authorizedBy;
        this.message = message;
    }

    @JsonProperty("code")
    public String getCode() {
        return code;
    }

    @JsonProperty("code")
    public void setCode(String code) {
        this.code = code;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("authorized_by")
    public String getAuthorizedBy() {
        return authorizedBy;
    }

    @JsonProperty("authorized_by")
    public void setAuthorizedBy(String authorizedBy) {
        this.authorizedBy = authorizedBy;
    }

    @JsonProperty("message")
    public String getMessage() {
        return message;
    }

    @JsonProperty("message")
    public void setMessage(String message) {
        this.message = message;
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
        return new ToStringBuilder(this).append("code", code).append("amount", amount).append("authorizedBy", authorizedBy).append("message", message).append("additionalProperties", additionalProperties).toString();
    }

}
