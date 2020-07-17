
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

//@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonInclude(JsonInclude.Include.ALWAYS)
@JsonPropertyOrder({
    "item_code",
    "item_name",
    "service_group",
    "charge_date",
    "unit_price",
    "quantity",
    "amount",
    "gross_amount",
    "pre_authorization_code",
    "payment_reference"
})
public class Line implements Serializable
{

    @JsonProperty("item_code")
    private String itemCode;
    @JsonProperty("item_name")
    private String itemName;
    @JsonProperty("service_group")
    private String serviceGroup;
    @JsonProperty("charge_date")
    private String chargeDate;
    @JsonProperty("unit_price")
    private Float unitPrice;
    @JsonProperty("quantity")
    private Float quantity;
    @JsonProperty("amount")
    private Float amount;
    @JsonProperty("gross_amount")
    private Float grossAmount;
    @JsonProperty("pre_authorization_code")
    private String preAuthorizationCode;
    @JsonProperty("payment_reference")
    private List<PaymentReference> paymentReference = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -6002268867304067387L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Line() {
    }

    /**
     * 
     * @param unitPrice
     * @param preAuthorizationCode
     * @param itemName
     * @param amount
     * @param quantity
     * @param itemCode
     * @param paymentReference
     * @param serviceGroup
     * @param grossAmount
     * @param chargeDate
     */
    public Line(String itemCode, String itemName, String serviceGroup, String chargeDate, Float unitPrice, Float quantity, Float amount, Float grossAmount, String preAuthorizationCode, List<PaymentReference> paymentReference) {
        super();
        this.itemCode = itemCode;
        this.itemName = itemName;
        this.serviceGroup = serviceGroup;
        this.chargeDate = chargeDate;
        this.unitPrice = unitPrice;
        this.quantity = quantity;
        this.amount = amount;
        this.grossAmount = grossAmount;
        this.preAuthorizationCode = preAuthorizationCode;
        this.paymentReference = paymentReference;
    }

    @JsonProperty("item_code")
    public String getItemCode() {
        return itemCode;
    }

    @JsonProperty("item_code")
    public void setItemCode(String itemCode) {
        this.itemCode = itemCode;
    }

    @JsonProperty("item_name")
    public String getItemName() {
        return itemName;
    }

    @JsonProperty("item_name")
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    @JsonProperty("service_group")
    public String getServiceGroup() {
        return serviceGroup;
    }

    @JsonProperty("service_group")
    public void setServiceGroup(String serviceGroup) {
        this.serviceGroup = serviceGroup;
    }

    @JsonProperty("charge_date")
    public String getChargeDate() {
        return chargeDate;
    }

    @JsonProperty("charge_date")
    public void setChargeDate(String chargeDate) {
        this.chargeDate = chargeDate;
    }

    @JsonProperty("unit_price")
    public Float getUnitPrice() {
        return unitPrice;
    }

    @JsonProperty("unit_price")
    public void setUnitPrice(Float unitPrice) {
        this.unitPrice = unitPrice;
    }

    @JsonProperty("quantity")
    public Float getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Float amount) {
        this.amount = amount;
    }

    @JsonProperty("gross_amount")
    public Float getGrossAmount() {
        return grossAmount;
    }

    @JsonProperty("gross_amount")
    public void setGrossAmount(Float grossAmount) {
        this.grossAmount = grossAmount;
    }

    @JsonProperty("pre_authorization_code")
    public String getPreAuthorizationCode() {
        return preAuthorizationCode;
    }

    @JsonProperty("pre_authorization_code")
    public void setPreAuthorizationCode(String preAuthorizationCode) {
        this.preAuthorizationCode = preAuthorizationCode;
    }

    @JsonProperty("payment_reference")
    public List<PaymentReference> getPaymentReference() {
        return paymentReference;
    }

    @JsonProperty("payment_reference")
    public void setPaymentReference(List<PaymentReference> paymentReference) {
        this.paymentReference = paymentReference;
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
        return new ToStringBuilder(this).append("itemCode", itemCode).append("itemName", itemName).append("serviceGroup", serviceGroup).append("chargeDate", chargeDate).append("unitPrice", unitPrice).append("quantity", quantity).append("amount", amount).append("grossAmount", grossAmount).append("preAuthorizationCode", preAuthorizationCode).append("paymentReference", paymentReference).append("additionalProperties", additionalProperties).toString();
    }

}
