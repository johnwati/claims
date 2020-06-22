/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.model;

import java.util.Date;

/**
 *
 * @author John.Simiyu
 */
public class ClaimRequest {

   public int claim_id;
public String claim_unique_identifier;
public String invoice_number;
public String bill_number;
public int payer_code;
public String payer_name;
public String patient_number;
public String patient_name;
public int branch_id;
public String branch_name;
public int scheme_code;
public String Scheme_name;
public String insurance_Number;
public int visit_number;
public String financial_system_invoice_Number;
public String hmis_invoice_number;
public String invoice_date;
public double total_amount;
public String Claim_Type;
public String payment_modifier_type;
public String payment_modifier_amount;
public String payment_modifier_reference_number;
public String admission_date;
public String discaharge_date;
public String discharge_summary;
public String service_type;
public String diagnosis_standard;
public String primary_diagnosis_code;
public String secondary_diagnosis_code;
public String preauthorisation_code;
public String preauthorisation_amount;
public String preauthorisation_athourised_by;
public String batch_number;
public String batch_dispatched_by;
public String doctor_name;
public String file_version;
public String service_code;
public String description;
public String Charge_Date;
public Double unit_price;
public int quantity;
public Double amount;
public String transation_reference_number;
public String Service_Group;
public String claim_code;
public String Coding_date;
public String Diagnosis_type;
public String diagnosis_code;
public String diagnosis_description;
public Date batch_Date;//(dte)
public String batch_dispatch_date;
public String aar_submitted_on;//(//dt)
public int smart_pulled;
public String smart_pulled_on;

    public int getClaim_id() {
        return claim_id;
    }

    public void setClaim_id(int claim_id) {
        this.claim_id = claim_id;
    }

    public String getClaim_unique_identifier() {
        return claim_unique_identifier;
    }

    public void setClaim_unique_identifier(String claim_unique_identifier) {
        this.claim_unique_identifier = claim_unique_identifier;
    }

    public String getInvoice_number() {
        return invoice_number;
    }

    public void setInvoice_number(String invoice_number) {
        this.invoice_number = invoice_number;
    }

    public String getBill_number() {
        return bill_number;
    }

    public void setBill_number(String bill_number) {
        this.bill_number = bill_number;
    }

    public int getPayer_code() {
        return payer_code;
    }

    public void setPayer_code(int payer_code) {
        this.payer_code = payer_code;
    }

    public String getPayer_name() {
        return payer_name;
    }

    public void setPayer_name(String payer_name) {
        this.payer_name = payer_name;
    }

    public String getPatient_number() {
        return patient_number;
    }

    public void setPatient_number(String patient_number) {
        this.patient_number = patient_number;
    }

    public String getPatient_name() {
        return patient_name;
    }

    public void setPatient_name(String patient_name) {
        this.patient_name = patient_name;
    }

    public int getBranch_id() {
        return branch_id;
    }

    public void setBranch_id(int branch_id) {
        this.branch_id = branch_id;
    }

    public String getBranch_name() {
        return branch_name;
    }

    public void setBranch_name(String branch_name) {
        this.branch_name = branch_name;
    }

    public int getScheme_code() {
        return scheme_code;
    }

    public void setScheme_code(int scheme_code) {
        this.scheme_code = scheme_code;
    }

    public String getScheme_name() {
        return Scheme_name;
    }

    public void setScheme_name(String Scheme_name) {
        this.Scheme_name = Scheme_name;
    }

    public String getInsurance_Number() {
        return insurance_Number;
    }

    public void setInsurance_Number(String insurance_Number) {
        this.insurance_Number = insurance_Number;
    }

    public int getVisit_number() {
        return visit_number;
    }

    public void setVisit_number(int visit_number) {
        this.visit_number = visit_number;
    }

    public String getFinancial_system_invoice_Number() {
        return financial_system_invoice_Number;
    }

    public void setFinancial_system_invoice_Number(String financial_system_invoice_Number) {
        this.financial_system_invoice_Number = financial_system_invoice_Number;
    }

    public String getHmis_invoice_number() {
        return hmis_invoice_number;
    }

    public void setHmis_invoice_number(String hmis_invoice_number) {
        this.hmis_invoice_number = hmis_invoice_number;
    }

    public String getInvoice_date() {
        return invoice_date;
    }

    public void setInvoice_date(String invoice_date) {
        this.invoice_date = invoice_date;
    }

    public double getTotal_amount() {
        return total_amount;
    }

    public void setTotal_amount(double total_amount) {
        this.total_amount = total_amount;
    }

    public String getClaim_Type() {
        return Claim_Type;
    }

    public void setClaim_Type(String Claim_Type) {
        this.Claim_Type = Claim_Type;
    }

    public String getPayment_modifier_type() {
        return payment_modifier_type;
    }

    public void setPayment_modifier_type(String payment_modifier_type) {
        this.payment_modifier_type = payment_modifier_type;
    }

    public String getPayment_modifier_amount() {
        return payment_modifier_amount;
    }

    public void setPayment_modifier_amount(String payment_modifier_amount) {
        this.payment_modifier_amount = payment_modifier_amount;
    }

    public String getPayment_modifier_reference_number() {
        return payment_modifier_reference_number;
    }

    public void setPayment_modifier_reference_number(String payment_modifier_reference_number) {
        this.payment_modifier_reference_number = payment_modifier_reference_number;
    }

    public String getAdmission_date() {
        return admission_date;
    }

    public void setAdmission_date(String admission_date) {
        this.admission_date = admission_date;
    }

    public String getDiscaharge_date() {
        return discaharge_date;
    }

    public void setDiscaharge_date(String discaharge_date) {
        this.discaharge_date = discaharge_date;
    }

    public String getDischarge_summary() {
        return discharge_summary;
    }

    public void setDischarge_summary(String discharge_summary) {
        this.discharge_summary = discharge_summary;
    }

    public String getService_type() {
        return service_type;
    }

    public void setService_type(String service_type) {
        this.service_type = service_type;
    }

    public String getDiagnosis_standard() {
        return diagnosis_standard;
    }

    public void setDiagnosis_standard(String diagnosis_standard) {
        this.diagnosis_standard = diagnosis_standard;
    }

    public String getPrimary_diagnosis_code() {
        return primary_diagnosis_code;
    }

    public void setPrimary_diagnosis_code(String primary_diagnosis_code) {
        this.primary_diagnosis_code = primary_diagnosis_code;
    }

    public String getSecondary_diagnosis_code() {
        return secondary_diagnosis_code;
    }

    public void setSecondary_diagnosis_code(String secondary_diagnosis_code) {
        this.secondary_diagnosis_code = secondary_diagnosis_code;
    }

    public String getPreauthorisation_code() {
        return preauthorisation_code;
    }

    public void setPreauthorisation_code(String preauthorisation_code) {
        this.preauthorisation_code = preauthorisation_code;
    }

    public String getPreauthorisation_amount() {
        return preauthorisation_amount;
    }

    public void setPreauthorisation_amount(String preauthorisation_amount) {
        this.preauthorisation_amount = preauthorisation_amount;
    }

    public String getPreauthorisation_athourised_by() {
        return preauthorisation_athourised_by;
    }

    public void setPreauthorisation_athourised_by(String preauthorisation_athourised_by) {
        this.preauthorisation_athourised_by = preauthorisation_athourised_by;
    }

    public String getBatch_number() {
        return batch_number;
    }

    public void setBatch_number(String batch_number) {
        this.batch_number = batch_number;
    }

    public String getBatch_dispatched_by() {
        return batch_dispatched_by;
    }

    public void setBatch_dispatched_by(String batch_dispatched_by) {
        this.batch_dispatched_by = batch_dispatched_by;
    }

    public String getDoctor_name() {
        return doctor_name;
    }

    public void setDoctor_name(String doctor_name) {
        this.doctor_name = doctor_name;
    }

    public String getFile_version() {
        return file_version;
    }

    public void setFile_version(String file_version) {
        this.file_version = file_version;
    }

    public String getService_code() {
        return service_code;
    }

    public void setService_code(String service_code) {
        this.service_code = service_code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCharge_Date() {
        return Charge_Date;
    }

    public void setCharge_Date(String Charge_Date) {
        this.Charge_Date = Charge_Date;
    }

    public Double getUnit_price() {
        return unit_price;
    }

    public void setUnit_price(Double unit_price) {
        this.unit_price = unit_price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getTransation_reference_number() {
        return transation_reference_number;
    }

    public void setTransation_reference_number(String transation_reference_number) {
        this.transation_reference_number = transation_reference_number;
    }

    public String getService_Group() {
        return Service_Group;
    }

    public void setService_Group(String Service_Group) {
        this.Service_Group = Service_Group;
    }

    public String getClaim_code() {
        return claim_code;
    }

    public void setClaim_code(String claim_code) {
        this.claim_code = claim_code;
    }

    public String getCoding_date() {
        return Coding_date;
    }

    public void setCoding_date(String Coding_date) {
        this.Coding_date = Coding_date;
    }

    public String getDiagnosis_type() {
        return Diagnosis_type;
    }

    public void setDiagnosis_type(String Diagnosis_type) {
        this.Diagnosis_type = Diagnosis_type;
    }

    public String getDiagnosis_code() {
        return diagnosis_code;
    }

    public void setDiagnosis_code(String diagnosis_code) {
        this.diagnosis_code = diagnosis_code;
    }

    public String getDiagnosis_description() {
        return diagnosis_description;
    }

    public void setDiagnosis_description(String diagnosis_description) {
        this.diagnosis_description = diagnosis_description;
    }

    public Date getBatch_Date() {
        return batch_Date;
    }

    public void setBatch_Date(Date batch_Date) {
        this.batch_Date = batch_Date;
    }

    public String getBatch_dispatch_date() {
        return batch_dispatch_date;
    }

    public void setBatch_dispatch_date(String batch_dispatch_date) {
        this.batch_dispatch_date = batch_dispatch_date;
    }

    public String getAar_submitted_on() {
        return aar_submitted_on;
    }

    public void setAar_submitted_on(String aar_submitted_on) {
        this.aar_submitted_on = aar_submitted_on;
    }

    public int getSmart_pulled() {
        return smart_pulled;
    }

    public void setSmart_pulled(int smart_pulled) {
        this.smart_pulled = smart_pulled;
    }

    public String getSmart_pulled_on() {
        return smart_pulled_on;
    }

    public void setSmart_pulled_on(String smart_pulled_on) {
        this.smart_pulled_on = smart_pulled_on;
    }

    

    @Override
    public String toString() {
        return "ClaimRequest{" + "claim_id=" + claim_id + ", claim_unique_identifier=" + claim_unique_identifier + ", invoice_number=" + invoice_number + ", bill_number=" + bill_number + ", payer_code=" + payer_code + ", payer_name=" + payer_name + ", patient_number=" + patient_number + ", patient_name=" + patient_name + ", branch_id=" + branch_id + ", branch_name=" + branch_name + ", scheme_code=" + scheme_code + ", Scheme_name=" + Scheme_name + ", insurance_Number=" + insurance_Number + ", visit_number=" + visit_number + ", financial_system_invoice_Number=" + financial_system_invoice_Number + ", hmis_invoice_number=" + hmis_invoice_number + ", invoice_date=" + invoice_date + ", total_amount=" + total_amount + ", Claim_Type=" + Claim_Type + ", payment_modifier_type=" + payment_modifier_type + ", payment_modifier_amount=" + payment_modifier_amount + ", payment_modifier_reference_number=" + payment_modifier_reference_number + ", admission_date=" + admission_date + ", discaharge_date=" + discaharge_date + ", discharge_summary=" + discharge_summary + ", service_type=" + service_type + ", diagnosis_standard=" + diagnosis_standard + ", primary_diagnosis_code=" + primary_diagnosis_code + ", secondary_diagnosis_code=" + secondary_diagnosis_code + ", preauthorisation_code=" + preauthorisation_code + ", preauthorisation_amount=" + preauthorisation_amount + ", preauthorisation_athourised_by=" + preauthorisation_athourised_by + ", batch_number=" + batch_number + ", batch_dispatched_by=" + batch_dispatched_by + ", doctor_name=" + doctor_name + ", file_version=" + file_version + ", service_code=" + service_code + ", description=" + description + ", Charge_Date=" + Charge_Date + ", unit_price=" + unit_price + ", quantity=" + quantity + ", amount=" + amount + ", transation_reference_number=" + transation_reference_number + ", Service_Group=" + Service_Group + ", claim_code=" + claim_code + ", Coding_date=" + Coding_date + ", Diagnosis_type=" + Diagnosis_type + ", diagnosis_code=" + diagnosis_code + ", diagnosis_description=" + diagnosis_description + ", batch_Date=" + batch_Date + ", batch_dispatch_date=" + batch_dispatch_date + ", aar_submitted_on=" + aar_submitted_on + ", smart_pulled=" + smart_pulled + ", smart_pulled_on=" + smart_pulled_on + '}';
    }

    
}
