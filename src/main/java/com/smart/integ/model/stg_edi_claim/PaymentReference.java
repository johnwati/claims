
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

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
@JsonPropertyOrder({
    "ref_number"
})
public class PaymentReference implements Serializable
{

    @JsonProperty("ref_number")
    private String refNumber;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -4951801820179200144L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PaymentReference() {
    }

    /**
     * 
     * @param refNumber
     */
    public PaymentReference(String refNumber) {
        super();
        this.refNumber = refNumber;
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
        return new ToStringBuilder(this).append("refNumber", refNumber).append("additionalProperties", additionalProperties).toString();
    }

}
