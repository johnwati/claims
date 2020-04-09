
package com.smart.integ.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
    "payer_benefit_code",
    "payer_benefit_desc",
    "line_items",
    "benefit_desc",
    "pool_number",
    "service_type",
    "invoice_number",
    "amount",
    "invoice_id",
    "gross_amount"
})
public class Invoice implements Serializable
{

    @JsonProperty("payer_benefit_code")
    private String payerBenefitCode;
    @JsonProperty("payer_benefit_desc")
    private String payerBenefitDesc;
    @JsonProperty("line_items")
    private List<LineItem> lineItems = null;
    @JsonProperty("benefit_desc")
    private String benefitDesc;
    @JsonProperty("pool_number")
    private Integer poolNumber;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("invoice_id")
    private Integer invoiceId;
    @JsonProperty("gross_amount")
    private Integer grossAmount;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3332722495113620100L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Invoice() {
    }

    /**
     * 
     * @param payerBenefitCode
     * @param lineItems
     * @param serviceType
     * @param amount
     * @param benefitDesc
     * @param invoiceNumber
     * @param invoiceId
     * @param poolNumber
     * @param grossAmount
     * @param payerBenefitDesc
     */
    public Invoice(String payerBenefitCode, String payerBenefitDesc, List<LineItem> lineItems, String benefitDesc, Integer poolNumber, String serviceType, String invoiceNumber, Integer amount, Integer invoiceId, Integer grossAmount) {
        super();
        this.payerBenefitCode = payerBenefitCode;
        this.payerBenefitDesc = payerBenefitDesc;
        this.lineItems = lineItems;
        this.benefitDesc = benefitDesc;
        this.poolNumber = poolNumber;
        this.serviceType = serviceType;
        this.invoiceNumber = invoiceNumber;
        this.amount = amount;
        this.invoiceId = invoiceId;
        this.grossAmount = grossAmount;
    }

    @JsonProperty("payer_benefit_code")
    public String getPayerBenefitCode() {
        return payerBenefitCode;
    }

    @JsonProperty("payer_benefit_code")
    public void setPayerBenefitCode(String payerBenefitCode) {
        this.payerBenefitCode = payerBenefitCode;
    }

    @JsonProperty("payer_benefit_desc")
    public String getPayerBenefitDesc() {
        return payerBenefitDesc;
    }

    @JsonProperty("payer_benefit_desc")
    public void setPayerBenefitDesc(String payerBenefitDesc) {
        this.payerBenefitDesc = payerBenefitDesc;
    }

    @JsonProperty("line_items")
    public List<LineItem> getLineItems() {
        return lineItems;
    }

    @JsonProperty("line_items")
    public void setLineItems(List<LineItem> lineItems) {
        this.lineItems = lineItems;
    }

    @JsonProperty("benefit_desc")
    public String getBenefitDesc() {
        return benefitDesc;
    }

    @JsonProperty("benefit_desc")
    public void setBenefitDesc(String benefitDesc) {
        this.benefitDesc = benefitDesc;
    }

    @JsonProperty("pool_number")
    public Integer getPoolNumber() {
        return poolNumber;
    }

    @JsonProperty("pool_number")
    public void setPoolNumber(Integer poolNumber) {
        this.poolNumber = poolNumber;
    }

    @JsonProperty("service_type")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("invoice_number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("invoice_number")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("invoice_id")
    public Integer getInvoiceId() {
        return invoiceId;
    }

    @JsonProperty("invoice_id")
    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @JsonProperty("gross_amount")
    public Integer getGrossAmount() {
        return grossAmount;
    }

    @JsonProperty("gross_amount")
    public void setGrossAmount(Integer grossAmount) {
        this.grossAmount = grossAmount;
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
        return new ToStringBuilder(this).append("payerBenefitCode", payerBenefitCode).append("payerBenefitDesc", payerBenefitDesc).append("lineItems", lineItems).append("benefitDesc", benefitDesc).append("poolNumber", poolNumber).append("serviceType", serviceType).append("invoiceNumber", invoiceNumber).append("amount", amount).append("invoiceId", invoiceId).append("grossAmount", grossAmount).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(payerBenefitCode).append(lineItems).append(serviceType).append(amount).append(benefitDesc).append(invoiceNumber).append(invoiceId).append(poolNumber).append(grossAmount).append(additionalProperties).append(payerBenefitDesc).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Invoice) == false) {
            return false;
        }
        Invoice rhs = ((Invoice) other);
        return new EqualsBuilder().append(payerBenefitCode, rhs.payerBenefitCode).append(lineItems, rhs.lineItems).append(serviceType, rhs.serviceType).append(amount, rhs.amount).append(benefitDesc, rhs.benefitDesc).append(invoiceNumber, rhs.invoiceNumber).append(invoiceId, rhs.invoiceId).append(poolNumber, rhs.poolNumber).append(grossAmount, rhs.grossAmount).append(additionalProperties, rhs.additionalProperties).append(payerBenefitDesc, rhs.payerBenefitDesc).isEquals();
    }

}
