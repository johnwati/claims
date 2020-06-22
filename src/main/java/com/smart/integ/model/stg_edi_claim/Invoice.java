
package com.smart.integ.model.stg_edi_claim;

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
import org.apache.commons.lang.builder.ToStringBuilder;


@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "amount",
    "gross_amount",
    "invoice_date",
    "invoice_number",
    "service_type",
    "lines",
    "payment_modifiers"
})
public class Invoice implements Serializable
{

    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("gross_amount")
    private Integer grossAmount;
    @JsonProperty("invoice_date")
    private String invoiceDate;
    @JsonProperty("invoice_number")
    private String invoiceNumber;
    @JsonProperty("service_type")
    private String serviceType;
    @JsonProperty("lines")
    private List<Line> lines = null;
    @JsonProperty("payment_modifiers")
    private List<PaymentModifier> paymentModifiers = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 7329887285827146581L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Invoice() {
    }

    /**
     * 
     * @param serviceType
     * @param paymentModifiers
     * @param amount
     * @param invoiceNumber
     * @param grossAmount
     * @param invoiceDate
     * @param lines
     */
    public Invoice(Integer amount, Integer grossAmount, String invoiceDate, String invoiceNumber, String serviceType, List<Line> lines, List<PaymentModifier> paymentModifiers) {
        super();
        this.amount = amount;
        this.grossAmount = grossAmount;
        this.invoiceDate = invoiceDate;
        this.invoiceNumber = invoiceNumber;
        this.serviceType = serviceType;
        this.lines = lines;
        this.paymentModifiers = paymentModifiers;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("gross_amount")
    public Integer getGrossAmount() {
        return grossAmount;
    }

    @JsonProperty("gross_amount")
    public void setGrossAmount(Integer grossAmount) {
        this.grossAmount = grossAmount;
    }

    @JsonProperty("invoice_date")
    public String getInvoiceDate() {
        return invoiceDate;
    }

    @JsonProperty("invoice_date")
    public void setInvoiceDate(String invoiceDate) {
        this.invoiceDate = invoiceDate;
    }

    @JsonProperty("invoice_number")
    public String getInvoiceNumber() {
        return invoiceNumber;
    }

    @JsonProperty("invoice_number")
    public void setInvoiceNumber(String invoiceNumber) {
        this.invoiceNumber = invoiceNumber;
    }

    @JsonProperty("service_type")
    public String getServiceType() {
        return serviceType;
    }

    @JsonProperty("service_type")
    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    @JsonProperty("lines")
    public List<Line> getLines() {
        return lines;
    }

    @JsonProperty("lines")
    public void setLines(List<Line> lines) {
        this.lines = lines;
    }

    @JsonProperty("payment_modifiers")
    public List<PaymentModifier> getPaymentModifiers() {
        return paymentModifiers;
    }

    @JsonProperty("payment_modifiers")
    public void setPaymentModifiers(List<PaymentModifier> paymentModifiers) {
        this.paymentModifiers = paymentModifiers;
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
        return new ToStringBuilder(this).append("amount", amount).append("grossAmount", grossAmount).append("invoiceDate", invoiceDate).append("invoiceNumber", invoiceNumber).append("serviceType", serviceType).append("lines", lines).append("paymentModifiers", paymentModifiers).append("additionalProperties", additionalProperties).toString();
    }

}
