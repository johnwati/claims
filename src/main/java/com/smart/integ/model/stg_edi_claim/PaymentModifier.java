
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

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "type",
    "amount",
    "ref_number"
})
public class PaymentModifier implements Serializable
{

    @JsonProperty("type")
    private String type;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("ref_number")
    private String refNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6626156838987129173L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentModifier() {
    }

    /**
     * 
     * @param amount
     * @param refNumber
     * @param type
     */
    public PaymentModifier(String type, Integer amount, String refNumber) {
        super();
        this.type = type;
        this.amount = amount;
        this.refNumber = refNumber;
    }

    @JsonProperty("type")
    public String getType() {
        return type;
    }

    @JsonProperty("type")
    public void setType(String type) {
        this.type = type;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("ref_number")
    public String getRefNumber() {
        return refNumber;
    }

    @JsonProperty("ref_number")
    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
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
        return new ToStringBuilder(this).append("type", type).append("amount", amount).append("refNumber", refNumber).append("additionalProperties", additionalProperties).toString();
    }

}
