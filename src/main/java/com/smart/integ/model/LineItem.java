
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
    "prov_item_code",
    "prov_item_name",
    "payer_item_code",
    "payer_item_name",
    "payer_group_code",
    "payer_group_name",
    "quantity",
    "item_id",
    "amount",
    "service_group",
    "charge_date",
    "unit_price"
})
public class LineItem implements Serializable
{

    @JsonProperty("prov_item_code")
    private String provItemCode;
    @JsonProperty("prov_item_name")
    private String provItemName;
    @JsonProperty("payer_item_code")
    private String payerItemCode;
    @JsonProperty("payer_item_name")
    private String payerItemName;
    @JsonProperty("payer_group_code")
    private String payerGroupCode;
    @JsonProperty("payer_group_name")
    private String payerGroupName;
    @JsonProperty("quantity")
    private Float quantity;
    @JsonProperty("item_id")
    private Integer itemId;
    @JsonProperty("amount")
    private Float amount;
    @JsonProperty("service_group")
    private String serviceGroup;
    @JsonProperty("charge_date")
    private String chargeDate;
    @JsonProperty("unit_price")
    private Float unitPrice;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -3155684202009225309L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public LineItem() {
    }

    /**
     * 
     * @param unitPrice
     * @param itemId
     * @param amount
     * @param quantity
     * @param payerItemCode
     * @param payerItemName
     * @param serviceGroup
     * @param payerGroupName
     * @param provItemCode
     * @param provItemName
     * @param chargeDate
     * @param payerGroupCode
     */
    public LineItem(String provItemCode, String provItemName, String payerItemCode, String payerItemName, String payerGroupCode, String payerGroupName, Float quantity, Integer itemId, Float amount, String serviceGroup, String chargeDate, Float unitPrice) {
        super();
        this.provItemCode = provItemCode;
        this.provItemName = provItemName;
        this.payerItemCode = payerItemCode;
        this.payerItemName = payerItemName;
        this.payerGroupCode = payerGroupCode;
        this.payerGroupName = payerGroupName;
        this.quantity = quantity;
        this.itemId = itemId;
        this.amount = amount;
        this.serviceGroup = serviceGroup;
        this.chargeDate = chargeDate;
        this.unitPrice = unitPrice;
    }

    @JsonProperty("prov_item_code")
    public String getProvItemCode() {
        return provItemCode;
    }

    @JsonProperty("prov_item_code")
    public void setProvItemCode(String provItemCode) {
        this.provItemCode = provItemCode;
    }

    @JsonProperty("prov_item_name")
    public String getProvItemName() {
        return provItemName;
    }

    @JsonProperty("prov_item_name")
    public void setProvItemName(String provItemName) {
        this.provItemName = provItemName;
    }

    @JsonProperty("payer_item_code")
    public String getPayerItemCode() {
        return payerItemCode;
    }

    @JsonProperty("payer_item_code")
    public void setPayerItemCode(String payerItemCode) {
        this.payerItemCode = payerItemCode;
    }

    @JsonProperty("payer_item_name")
    public String getPayerItemName() {
        return payerItemName;
    }

    @JsonProperty("payer_item_name")
    public void setPayerItemName(String payerItemName) {
        this.payerItemName = payerItemName;
    }

    @JsonProperty("payer_group_code")
    public String getPayerGroupCode() {
        return payerGroupCode;
    }

    @JsonProperty("payer_group_code")
    public void setPayerGroupCode(String payerGroupCode) {
        this.payerGroupCode = payerGroupCode;
    }

    @JsonProperty("payer_group_name")
    public String getPayerGroupName() {
        return payerGroupName;
    }

    @JsonProperty("payer_group_name")
    public void setPayerGroupName(String payerGroupName) {
        this.payerGroupName = payerGroupName;
    }

    @JsonProperty("quantity")
    public Float getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(Float quantity) {
        this.quantity = quantity;
    }

    @JsonProperty("item_id")
    public Integer getItemId() {
        return itemId;
    }

    @JsonProperty("item_id")
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    @JsonProperty("amount")
    public Float getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Float amount) {
        this.amount = amount;
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
        return new ToStringBuilder(this).append("provItemCode", provItemCode).append("provItemName", provItemName).append("payerItemCode", payerItemCode).append("payerItemName", payerItemName).append("payerGroupCode", payerGroupCode).append("payerGroupName", payerGroupName).append("quantity", quantity).append("itemId", itemId).append("amount", amount).append("serviceGroup", serviceGroup).append("chargeDate", chargeDate).append("unitPrice", unitPrice).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(unitPrice).append(amount).append(quantity).append(payerItemCode).append(payerItemName).append(serviceGroup).append(payerGroupName).append(payerGroupCode).append(itemId).append(additionalProperties).append(provItemCode).append(provItemName).append(chargeDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof LineItem) == false) {
            return false;
        }
        LineItem rhs = ((LineItem) other);
        return new EqualsBuilder().append(unitPrice, rhs.unitPrice).append(amount, rhs.amount).append(quantity, rhs.quantity).append(payerItemCode, rhs.payerItemCode).append(payerItemName, rhs.payerItemName).append(serviceGroup, rhs.serviceGroup).append(payerGroupName, rhs.payerGroupName).append(payerGroupCode, rhs.payerGroupCode).append(itemId, rhs.itemId).append(additionalProperties, rhs.additionalProperties).append(provItemCode, rhs.provItemCode).append(provItemName, rhs.provItemName).append(chargeDate, rhs.chargeDate).isEquals();
    }

}
