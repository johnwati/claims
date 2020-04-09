
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
    "attachments",
    "provider_code",
    "payer_prov_code",
    "payer_prov_name",
    "roaming_amount",
    "preauth",
    "admissions",
    "claim_id",
    "member_number",
    "invoices",
    "diagnosis",
    "start_date",
    "end_date",
    "pol_id",
    "country_code",
    "payer_name",
    "batch_number",
    "roaming_country",
    "integ_scheme_code",
    "integ_member_number",
    "other_number",
    "card_serial_number",
    "integ_scheme_name",
    "patient_name",
    "central_id",
    "provider_name",
    "scheme_name",
    "insert_time",
    "amount",
    "policy_currency_code",
    "claim_code",
    "payer_code",
    "gross_amount",
    "dispatch_date",
    "patient_number",
    "visit_number",
    "visit_start",
    "visit_end",
    "currency"
})
public class Claim implements Serializable
{

    @JsonProperty("attachments")
    private List<Object> attachments = null;
    @JsonProperty("provider_code")
    private String providerCode;
    @JsonProperty("payer_prov_code")
    private String payerProvCode;
    @JsonProperty("payer_prov_name")
    private String payerProvName;
    @JsonProperty("roaming_amount")
    private Integer roamingAmount;
    @JsonProperty("preauth")
    private List<Object> preauth = null;
    @JsonProperty("admissions")
    private List<Object> admissions = null;
    @JsonProperty("claim_id")
    private Integer claimId;
    @JsonProperty("member_number")
    private String memberNumber;
    @JsonProperty("invoices")
    private List<Invoice> invoices = null;
    @JsonProperty("diagnosis")
    private List<Diagnosi> diagnosis = null;
    @JsonProperty("start_date")
    private String startDate;
    @JsonProperty("end_date")
    private String endDate;
    @JsonProperty("pol_id")
    private Integer polId;
    @JsonProperty("country_code")
    private String countryCode;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty("roaming_country")
    private String roamingCountry;
    @JsonProperty("integ_scheme_code")
    private String integSchemeCode;
    @JsonProperty("integ_member_number")
    private String integMemberNumber;
    @JsonProperty("other_number")
    private String otherNumber;
    @JsonProperty("card_serial_number")
    private String cardSerialNumber;
    @JsonProperty("integ_scheme_name")
    private String integSchemeName;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("central_id")
    private Integer centralId;
    @JsonProperty("provider_name")
    private String providerName;
    @JsonProperty("scheme_name")
    private String schemeName;
    @JsonProperty("insert_time")
    private String insertTime;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("policy_currency_code")
    private String policyCurrencyCode;
    @JsonProperty("claim_code")
    private String claimCode;
    @JsonProperty("payer_code")
    private String payerCode;
    @JsonProperty("gross_amount")
    private Integer grossAmount;
    @JsonProperty("dispatch_date")
    private String dispatchDate;
    @JsonProperty("patient_number")
    private String patientNumber;
    @JsonProperty("visit_number")
    private String visitNumber;
    @JsonProperty("visit_start")
    private String visitStart;
    @JsonProperty("visit_end")
    private String visitEnd;
    @JsonProperty("currency")
    private String currency;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = -5912814437444776796L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Claim() {
    }

    /**
     * 
     * @param attachments
     * @param providerCode
     * @param endDate
     * @param cardSerialNumber
     * @param dispatchDate
     * @param visitNumber
     * @param integMemberNumber
     * @param roamingCountry
     * @param integSchemeName
     * @param centralId
     * @param invoices
     * @param policyCurrencyCode
     * @param polId
     * @param countryCode
     * @param payerName
     * @param patientNumber
     * @param currency
     * @param providerName
     * @param batchNumber
     * @param otherNumber
     * @param patientName
     * @param amount
     * @param visitEnd
     * @param schemeName
     * @param payerProvName
     * @param diagnosis
     * @param integSchemeCode
     * @param admissions
     * @param claimId
     * @param grossAmount
     * @param visitStart
     * @param payerProvCode
     * @param insertTime
     * @param roamingAmount
     * @param memberNumber
     * @param preauth
     * @param claimCode
     * @param payerCode
     * @param startDate
     */
    public Claim(List<Object> attachments, String providerCode, String payerProvCode, String payerProvName, Integer roamingAmount, List<Object> preauth, List<Object> admissions, Integer claimId, String memberNumber, List<Invoice> invoices, List<Diagnosi> diagnosis, String startDate, String endDate, Integer polId, String countryCode, String payerName, String batchNumber, String roamingCountry, String integSchemeCode, String integMemberNumber, String otherNumber, String cardSerialNumber, String integSchemeName, String patientName, Integer centralId, String providerName, String schemeName, String insertTime, Integer amount, String policyCurrencyCode, String claimCode, String payerCode, Integer grossAmount, String dispatchDate, String patientNumber, String visitNumber, String visitStart, String visitEnd, String currency) {
        super();
        this.attachments = attachments;
        this.providerCode = providerCode;
        this.payerProvCode = payerProvCode;
        this.payerProvName = payerProvName;
        this.roamingAmount = roamingAmount;
        this.preauth = preauth;
        this.admissions = admissions;
        this.claimId = claimId;
        this.memberNumber = memberNumber;
        this.invoices = invoices;
        this.diagnosis = diagnosis;
        this.startDate = startDate;
        this.endDate = endDate;
        this.polId = polId;
        this.countryCode = countryCode;
        this.payerName = payerName;
        this.batchNumber = batchNumber;
        this.roamingCountry = roamingCountry;
        this.integSchemeCode = integSchemeCode;
        this.integMemberNumber = integMemberNumber;
        this.otherNumber = otherNumber;
        this.cardSerialNumber = cardSerialNumber;
        this.integSchemeName = integSchemeName;
        this.patientName = patientName;
        this.centralId = centralId;
        this.providerName = providerName;
        this.schemeName = schemeName;
        this.insertTime = insertTime;
        this.amount = amount;
        this.policyCurrencyCode = policyCurrencyCode;
        this.claimCode = claimCode;
        this.payerCode = payerCode;
        this.grossAmount = grossAmount;
        this.dispatchDate = dispatchDate;
        this.patientNumber = patientNumber;
        this.visitNumber = visitNumber;
        this.visitStart = visitStart;
        this.visitEnd = visitEnd;
        this.currency = currency;
    }

    @JsonProperty("attachments")
    public List<Object> getAttachments() {
        return attachments;
    }

    @JsonProperty("attachments")
    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    @JsonProperty("provider_code")
    public String getProviderCode() {
        return providerCode;
    }

    @JsonProperty("provider_code")
    public void setProviderCode(String providerCode) {
        this.providerCode = providerCode;
    }

    @JsonProperty("payer_prov_code")
    public String getPayerProvCode() {
        return payerProvCode;
    }

    @JsonProperty("payer_prov_code")
    public void setPayerProvCode(String payerProvCode) {
        this.payerProvCode = payerProvCode;
    }

    @JsonProperty("payer_prov_name")
    public String getPayerProvName() {
        return payerProvName;
    }

    @JsonProperty("payer_prov_name")
    public void setPayerProvName(String payerProvName) {
        this.payerProvName = payerProvName;
    }

    @JsonProperty("roaming_amount")
    public Integer getRoamingAmount() {
        return roamingAmount;
    }

    @JsonProperty("roaming_amount")
    public void setRoamingAmount(Integer roamingAmount) {
        this.roamingAmount = roamingAmount;
    }

    @JsonProperty("preauth")
    public List<Object> getPreauth() {
        return preauth;
    }

    @JsonProperty("preauth")
    public void setPreauth(List<Object> preauth) {
        this.preauth = preauth;
    }

    @JsonProperty("admissions")
    public List<Object> getAdmissions() {
        return admissions;
    }

    @JsonProperty("admissions")
    public void setAdmissions(List<Object> admissions) {
        this.admissions = admissions;
    }

    @JsonProperty("claim_id")
    public Integer getClaimId() {
        return claimId;
    }

    @JsonProperty("claim_id")
    public void setClaimId(Integer claimId) {
        this.claimId = claimId;
    }

    @JsonProperty("member_number")
    public String getMemberNumber() {
        return memberNumber;
    }

    @JsonProperty("member_number")
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
    }

    @JsonProperty("invoices")
    public List<Invoice> getInvoices() {
        return invoices;
    }

    @JsonProperty("invoices")
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
    }

    @JsonProperty("diagnosis")
    public List<Diagnosi> getDiagnosis() {
        return diagnosis;
    }

    @JsonProperty("diagnosis")
    public void setDiagnosis(List<Diagnosi> diagnosis) {
        this.diagnosis = diagnosis;
    }

    @JsonProperty("start_date")
    public String getStartDate() {
        return startDate;
    }

    @JsonProperty("start_date")
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    @JsonProperty("end_date")
    public String getEndDate() {
        return endDate;
    }

    @JsonProperty("end_date")
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    @JsonProperty("pol_id")
    public Integer getPolId() {
        return polId;
    }

    @JsonProperty("pol_id")
    public void setPolId(Integer polId) {
        this.polId = polId;
    }

    @JsonProperty("country_code")
    public String getCountryCode() {
        return countryCode;
    }

    @JsonProperty("country_code")
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @JsonProperty("payer_name")
    public String getPayerName() {
        return payerName;
    }

    @JsonProperty("payer_name")
    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    @JsonProperty("batch_number")
    public String getBatchNumber() {
        return batchNumber;
    }

    @JsonProperty("batch_number")
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
    }

    @JsonProperty("roaming_country")
    public String getRoamingCountry() {
        return roamingCountry;
    }

    @JsonProperty("roaming_country")
    public void setRoamingCountry(String roamingCountry) {
        this.roamingCountry = roamingCountry;
    }

    @JsonProperty("integ_scheme_code")
    public String getIntegSchemeCode() {
        return integSchemeCode;
    }

    @JsonProperty("integ_scheme_code")
    public void setIntegSchemeCode(String integSchemeCode) {
        this.integSchemeCode = integSchemeCode;
    }

    @JsonProperty("integ_member_number")
    public String getIntegMemberNumber() {
        return integMemberNumber;
    }

    @JsonProperty("integ_member_number")
    public void setIntegMemberNumber(String integMemberNumber) {
        this.integMemberNumber = integMemberNumber;
    }

    @JsonProperty("other_number")
    public String getOtherNumber() {
        return otherNumber;
    }

    @JsonProperty("other_number")
    public void setOtherNumber(String otherNumber) {
        this.otherNumber = otherNumber;
    }

    @JsonProperty("card_serial_number")
    public String getCardSerialNumber() {
        return cardSerialNumber;
    }

    @JsonProperty("card_serial_number")
    public void setCardSerialNumber(String cardSerialNumber) {
        this.cardSerialNumber = cardSerialNumber;
    }

    @JsonProperty("integ_scheme_name")
    public String getIntegSchemeName() {
        return integSchemeName;
    }

    @JsonProperty("integ_scheme_name")
    public void setIntegSchemeName(String integSchemeName) {
        this.integSchemeName = integSchemeName;
    }

    @JsonProperty("patient_name")
    public String getPatientName() {
        return patientName;
    }

    @JsonProperty("patient_name")
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @JsonProperty("central_id")
    public Integer getCentralId() {
        return centralId;
    }

    @JsonProperty("central_id")
    public void setCentralId(Integer centralId) {
        this.centralId = centralId;
    }

    @JsonProperty("provider_name")
    public String getProviderName() {
        return providerName;
    }

    @JsonProperty("provider_name")
    public void setProviderName(String providerName) {
        this.providerName = providerName;
    }

    @JsonProperty("scheme_name")
    public String getSchemeName() {
        return schemeName;
    }

    @JsonProperty("scheme_name")
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    @JsonProperty("insert_time")
    public String getInsertTime() {
        return insertTime;
    }

    @JsonProperty("insert_time")
    public void setInsertTime(String insertTime) {
        this.insertTime = insertTime;
    }

    @JsonProperty("amount")
    public Integer getAmount() {
        return amount;
    }

    @JsonProperty("amount")
    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @JsonProperty("policy_currency_code")
    public String getPolicyCurrencyCode() {
        return policyCurrencyCode;
    }

    @JsonProperty("policy_currency_code")
    public void setPolicyCurrencyCode(String policyCurrencyCode) {
        this.policyCurrencyCode = policyCurrencyCode;
    }

    @JsonProperty("claim_code")
    public String getClaimCode() {
        return claimCode;
    }

    @JsonProperty("claim_code")
    public void setClaimCode(String claimCode) {
        this.claimCode = claimCode;
    }

    @JsonProperty("payer_code")
    public String getPayerCode() {
        return payerCode;
    }

    @JsonProperty("payer_code")
    public void setPayerCode(String payerCode) {
        this.payerCode = payerCode;
    }

    @JsonProperty("gross_amount")
    public Integer getGrossAmount() {
        return grossAmount;
    }

    @JsonProperty("gross_amount")
    public void setGrossAmount(Integer grossAmount) {
        this.grossAmount = grossAmount;
    }

    @JsonProperty("dispatch_date")
    public String getDispatchDate() {
        return dispatchDate;
    }

    @JsonProperty("dispatch_date")
    public void setDispatchDate(String dispatchDate) {
        this.dispatchDate = dispatchDate;
    }

    @JsonProperty("patient_number")
    public String getPatientNumber() {
        return patientNumber;
    }

    @JsonProperty("patient_number")
    public void setPatientNumber(String patientNumber) {
        this.patientNumber = patientNumber;
    }

    @JsonProperty("visit_number")
    public String getVisitNumber() {
        return visitNumber;
    }

    @JsonProperty("visit_number")
    public void setVisitNumber(String visitNumber) {
        this.visitNumber = visitNumber;
    }

    @JsonProperty("visit_start")
    public String getVisitStart() {
        return visitStart;
    }

    @JsonProperty("visit_start")
    public void setVisitStart(String visitStart) {
        this.visitStart = visitStart;
    }

    @JsonProperty("visit_end")
    public String getVisitEnd() {
        return visitEnd;
    }

    @JsonProperty("visit_end")
    public void setVisitEnd(String visitEnd) {
        this.visitEnd = visitEnd;
    }

    @JsonProperty("currency")
    public String getCurrency() {
        return currency;
    }

    @JsonProperty("currency")
    public void setCurrency(String currency) {
        this.currency = currency;
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
        return new ToStringBuilder(this).append("attachments", attachments).append("providerCode", providerCode).append("payerProvCode", payerProvCode).append("payerProvName", payerProvName).append("roamingAmount", roamingAmount).append("preauth", preauth).append("admissions", admissions).append("claimId", claimId).append("memberNumber", memberNumber).append("invoices", invoices).append("diagnosis", diagnosis).append("startDate", startDate).append("endDate", endDate).append("polId", polId).append("countryCode", countryCode).append("payerName", payerName).append("batchNumber", batchNumber).append("roamingCountry", roamingCountry).append("integSchemeCode", integSchemeCode).append("integMemberNumber", integMemberNumber).append("otherNumber", otherNumber).append("cardSerialNumber", cardSerialNumber).append("integSchemeName", integSchemeName).append("patientName", patientName).append("centralId", centralId).append("providerName", providerName).append("schemeName", schemeName).append("insertTime", insertTime).append("amount", amount).append("policyCurrencyCode", policyCurrencyCode).append("claimCode", claimCode).append("payerCode", payerCode).append("grossAmount", grossAmount).append("dispatchDate", dispatchDate).append("patientNumber", patientNumber).append("visitNumber", visitNumber).append("visitStart", visitStart).append("visitEnd", visitEnd).append("currency", currency).append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(attachments).append(providerCode).append(endDate).append(cardSerialNumber).append(dispatchDate).append(visitNumber).append(integMemberNumber).append(roamingCountry).append(integSchemeName).append(centralId).append(invoices).append(policyCurrencyCode).append(polId).append(countryCode).append(payerName).append(patientNumber).append(currency).append(providerName).append(batchNumber).append(otherNumber).append(patientName).append(amount).append(visitEnd).append(schemeName).append(payerProvName).append(diagnosis).append(integSchemeCode).append(admissions).append(claimId).append(grossAmount).append(visitStart).append(payerProvCode).append(insertTime).append(roamingAmount).append(memberNumber).append(preauth).append(claimCode).append(payerCode).append(additionalProperties).append(startDate).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Claim) == false) {
            return false;
        }
        Claim rhs = ((Claim) other);
        return new EqualsBuilder().append(attachments, rhs.attachments).append(providerCode, rhs.providerCode).append(endDate, rhs.endDate).append(cardSerialNumber, rhs.cardSerialNumber).append(dispatchDate, rhs.dispatchDate).append(visitNumber, rhs.visitNumber).append(integMemberNumber, rhs.integMemberNumber).append(roamingCountry, rhs.roamingCountry).append(integSchemeName, rhs.integSchemeName).append(centralId, rhs.centralId).append(invoices, rhs.invoices).append(policyCurrencyCode, rhs.policyCurrencyCode).append(polId, rhs.polId).append(countryCode, rhs.countryCode).append(payerName, rhs.payerName).append(patientNumber, rhs.patientNumber).append(currency, rhs.currency).append(providerName, rhs.providerName).append(batchNumber, rhs.batchNumber).append(otherNumber, rhs.otherNumber).append(patientName, rhs.patientName).append(amount, rhs.amount).append(visitEnd, rhs.visitEnd).append(schemeName, rhs.schemeName).append(payerProvName, rhs.payerProvName).append(diagnosis, rhs.diagnosis).append(integSchemeCode, rhs.integSchemeCode).append(admissions, rhs.admissions).append(claimId, rhs.claimId).append(grossAmount, rhs.grossAmount).append(visitStart, rhs.visitStart).append(payerProvCode, rhs.payerProvCode).append(insertTime, rhs.insertTime).append(roamingAmount, rhs.roamingAmount).append(memberNumber, rhs.memberNumber).append(preauth, rhs.preauth).append(claimCode, rhs.claimCode).append(payerCode, rhs.payerCode).append(additionalProperties, rhs.additionalProperties).append(startDate, rhs.startDate).isEquals();
    }

}
