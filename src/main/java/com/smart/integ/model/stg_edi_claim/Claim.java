
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
import java.util.logging.Logger;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "claim_code",
    "payer_code",
    "payer_name",
    "amount",
    "gross_amount",
    "batch_number",
    "dispatch_date",
    "patient_number",
    "patient_name",
    "location_code",
    "location_name",
    "scheme_code",
    "scheme_name",
    "member_number",
    "visit_number",
    "visit_start",
    "visit_end",
    "currency",
    "doctor_name",
    "file_version",
    "diagnosis",
    "pre_authorization",
    "admission",
    "invoices"
})
public class Claim implements Serializable
{

    @JsonProperty("claim_code")
    private String claimCode;
    @JsonProperty("payer_code")
    private String payerCode;
    @JsonProperty("payer_name")
    private String payerName;
    @JsonProperty("amount")
    private Integer amount;
    @JsonProperty("gross_amount")
    private Integer grossAmount;
    @JsonProperty("batch_number")
    private String batchNumber;
    @JsonProperty("dispatch_date")
    private String dispatchDate;
    @JsonProperty("patient_number")
    private String patientNumber;
    @JsonProperty("patient_name")
    private String patientName;
    @JsonProperty("location_code")
    private String locationCode;
    @JsonProperty("location_name")
    private String locationName;
    @JsonProperty("scheme_code")
    private String schemeCode;
    @JsonProperty("scheme_name")
    private String schemeName;
    @JsonProperty("member_number")
    private String memberNumber;
    @JsonProperty("visit_number")
    private String visitNumber;
    @JsonProperty("visit_start")
    private String visitStart;
    @JsonProperty("visit_end")
    private String visitEnd;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("doctor_name")
    private String doctorName;
    @JsonProperty("file_version")
    private String fileVersion;
    @JsonProperty("diagnosis")
    private List<Diagnosi> diagnosis = null;
    @JsonProperty("pre_authorization")
    private List<PreAuthorization> preAuthorization = null;
    @JsonProperty("admission")
    private List<Admission> admission = null;
    @JsonProperty("invoices")
    private List<Invoice> invoices = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();
    private final static long serialVersionUID = 8401284604236118518L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Claim() {
    }

    /**
     * 
     * @param patientName
     * @param schemeCode
     * @param amount
     * @param locationName
     * @param visitEnd
     * @param dispatchDate
     * @param visitNumber
     * @param schemeName
     * @param diagnosis
     * @param grossAmount
     * @param admission
     * @param visitStart
     * @param doctorName
     * @param memberNumber
     * @param invoices
     * @param claimCode
     * @param payerCode
     * @param payerName
     * @param preAuthorization
     * @param patientNumber
     * @param currency
     * @param locationCode
     * @param fileVersion
     * @param batchNumber
     */
    public Claim(String claimCode, String payerCode, String payerName, Integer amount, Integer grossAmount, String batchNumber, String dispatchDate, String patientNumber, String patientName, String locationCode, String locationName, String schemeCode, String schemeName, String memberNumber, String visitNumber, String visitStart, String visitEnd, String currency, String doctorName, String fileVersion, List<Diagnosi> diagnosis, List<PreAuthorization> preAuthorization, List<Admission> admission, List<Invoice> invoices) {
        super();
        this.claimCode = claimCode;
        this.payerCode = payerCode;
        this.payerName = payerName;
        this.amount = amount;
        this.grossAmount = grossAmount;
        this.batchNumber = batchNumber;
        this.dispatchDate = dispatchDate;
        this.patientNumber = patientNumber;
        this.patientName = patientName;
        this.locationCode = locationCode;
        this.locationName = locationName;
        this.schemeCode = schemeCode;
        this.schemeName = schemeName;
        this.memberNumber = memberNumber;
        this.visitNumber = visitNumber;
        this.visitStart = visitStart;
        this.visitEnd = visitEnd;
        this.currency = currency;
        this.doctorName = doctorName;
        this.fileVersion = fileVersion;
        this.diagnosis = diagnosis;
        this.preAuthorization = preAuthorization;
        this.admission = admission;
        this.invoices = invoices;
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

    @JsonProperty("payer_name")
    public String getPayerName() {
        return payerName;
    }

    @JsonProperty("payer_name")
    public void setPayerName(String payerName) {
        this.payerName = payerName;
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

    @JsonProperty("batch_number")
    public String getBatchNumber() {
        return batchNumber;
    }

    @JsonProperty("batch_number")
    public void setBatchNumber(String batchNumber) {
        this.batchNumber = batchNumber;
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

    @JsonProperty("patient_name")
    public String getPatientName() {
        return patientName;
    }

    @JsonProperty("patient_name")
    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    @JsonProperty("location_code")
    public String getLocationCode() {
        return locationCode;
    }

    @JsonProperty("location_code")
    public void setLocationCode(String locationCode) {
        this.locationCode = locationCode;
    }

    @JsonProperty("location_name")
    public String getLocationName() {
        return locationName;
    }

    @JsonProperty("location_name")
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    @JsonProperty("scheme_code")
    public String getSchemeCode() {
        return schemeCode;
    }

    @JsonProperty("scheme_code")
    public void setSchemeCode(String schemeCode) {
        this.schemeCode = schemeCode;
    }

    @JsonProperty("scheme_name")
    public String getSchemeName() {
        return schemeName;
    }

    @JsonProperty("scheme_name")
    public void setSchemeName(String schemeName) {
        this.schemeName = schemeName;
    }

    @JsonProperty("member_number")
    public String getMemberNumber() {
        return memberNumber;
    }

    @JsonProperty("member_number")
    public void setMemberNumber(String memberNumber) {
        this.memberNumber = memberNumber;
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

    @JsonProperty("doctor_name")
    public String getDoctorName() {
        return doctorName;
    }

    @JsonProperty("doctor_name")
    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    @JsonProperty("file_version")
    public String getFileVersion() {
        return fileVersion;
    }

    @JsonProperty("file_version")
    public void setFileVersion(String fileVersion) {
        this.fileVersion = fileVersion;
    }

    @JsonProperty("diagnosis")
    public List<Diagnosi> getDiagnosis() {
        return diagnosis;
    }

    @JsonProperty("diagnosis")
    public void setDiagnosis(List<Diagnosi> diagnosis) {
        this.diagnosis = diagnosis;
    }

    @JsonProperty("pre_authorization")
    public List<PreAuthorization> getPreAuthorization() {
        return preAuthorization;
    }

    @JsonProperty("pre_authorization")
    public void setPreAuthorization(List<PreAuthorization> preAuthorization) {
        this.preAuthorization = preAuthorization;
    }

    @JsonProperty("admission")
    public List<Admission> getAdmission() {
        return admission;
    }

    @JsonProperty("admission")
    public void setAdmission(List<Admission> admission) {
        this.admission = admission;
    }

    @JsonProperty("invoices")
    public List<Invoice> getInvoices() {
        return invoices;
    }

    @JsonProperty("invoices")
    public void setInvoices(List<Invoice> invoices) {
        this.invoices = invoices;
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
        return new ToStringBuilder(this).append("claimCode", claimCode).append("payerCode", payerCode).append("payerName", payerName).append("amount", amount).append("grossAmount", grossAmount).append("batchNumber", batchNumber).append("dispatchDate", dispatchDate).append("patientNumber", patientNumber).append("patientName", patientName).append("locationCode", locationCode).append("locationName", locationName).append("schemeCode", schemeCode).append("schemeName", schemeName).append("memberNumber", memberNumber).append("visitNumber", visitNumber).append("visitStart", visitStart).append("visitEnd", visitEnd).append("currency", currency).append("doctorName", doctorName).append("fileVersion", fileVersion).append("diagnosis", diagnosis).append("preAuthorization", preAuthorization).append("admission", admission).append("invoices", invoices).append("additionalProperties", additionalProperties).toString();
    }

}
