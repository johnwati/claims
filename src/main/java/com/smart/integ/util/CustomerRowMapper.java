/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.util;

/**
 *
 * @author John.Simiyu
 */
import com.smart.integ.model.ClaimRequest;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerRowMapper implements RowMapper<ClaimRequest> {

    @Override
    public ClaimRequest mapRow(ResultSet rs, int rowNum) throws SQLException {

        ClaimRequest claimRequest = new ClaimRequest();
        claimRequest.setClaim_id(rs.getInt("claim_id"));
        claimRequest.setClaim_unique_identifier(rs.getString("claim_unique_identifier"));
        claimRequest.setInvoice_number(rs.getString("invoice_number"));
        claimRequest.setBill_number(rs.getString("bill_number"));
        claimRequest.setPayer_code(rs.getInt("payer_code"));
        claimRequest.setPayer_name(rs.getString("payer_name"));
        claimRequest.setPatient_number(rs.getString("patient_number"));
        claimRequest.setPatient_name(rs.getString("patient_name"));
        claimRequest.setBranch_id(rs.getInt("branch_id"));
        claimRequest.setBranch_name(rs.getString("branch_name"));
        claimRequest.setScheme_code(rs.getInt("scheme_code"));
        claimRequest.setScheme_name(rs.getString("Scheme_name"));
        claimRequest.setInsurance_Number(rs.getString("insurance_Number"));
        claimRequest.setVisit_number(rs.getInt("visit_number"));
        claimRequest.setFinancial_system_invoice_Number(rs.getString("financial_system_invoice_Number"));
        claimRequest.setHmis_invoice_number(rs.getString("hmis_invoice_number"));
        claimRequest.setInvoice_date(rs.getString("invoice_date"));
        claimRequest.setTotal_amount(rs.getDouble("total_amount"));
        claimRequest.setClaim_Type(rs.getString("Claim_Type"));
        claimRequest.setPayment_modifier_type(rs.getString("payment_modifier_type"));
        claimRequest.setPayment_modifier_amount(rs.getString("payment_modifier_amount"));
        claimRequest.setPayment_modifier_reference_number(rs.getString("payment_modifier_reference_number"));
        claimRequest.setAdmission_date(rs.getString("admission_date"));
        claimRequest.setDiscaharge_date(rs.getString("discharge_date"));//discharge_date
        claimRequest.setDischarge_summary(rs.getString("discharge_summary"));
        claimRequest.setService_type(rs.getString("service_type"));
        claimRequest.setDiagnosis_standard(rs.getString("diagnosis_standard"));
        claimRequest.setPrimary_diagnosis_code(rs.getString("primary_diagnosis_code"));
        claimRequest.setSecondary_diagnosis_code(rs.getString("secondary_diagnosis_code"));
        claimRequest.setPreauthorisation_code(rs.getString("preauthorisation_code"));
        claimRequest.setPreauthorisation_amount(rs.getString("preauthorisation_amount"));
        claimRequest.setPreauthorisation_athourised_by(rs.getString("preauthorisation_athourised_by"));
        claimRequest.setBatch_number(rs.getString("batch_number"));
        claimRequest.setBatch_dispatched_by(rs.getString("batch_dispatched_by"));
        claimRequest.setDoctor_name(rs.getString("doctor_name"));
        claimRequest.setFile_version(rs.getString("file_version"));
        claimRequest.setService_code(rs.getString("service_code"));
        claimRequest.setDescription(rs.getString("description"));
        claimRequest.setCharge_Date(rs.getString("Charge_Date"));
        claimRequest.setUnit_price(rs.getDouble("unit_price"));
        claimRequest.setQuantity(rs.getInt("quantity"));
        claimRequest.setAmount(rs.getDouble("amount"));
        claimRequest.setTransation_reference_number(rs.getString("transation_reference_number"));
        claimRequest.setService_Group(rs.getString("Service_Group"));
        claimRequest.setClaim_code(rs.getString("claim_code"));
        claimRequest.setCoding_date(rs.getString("Coding_date"));
        claimRequest.setDiagnosis_type(rs.getString("Diagnosis_type"));
        claimRequest.setDiagnosis_code(rs.getString("diagnosis_code"));
        claimRequest.setDiagnosis_description(rs.getString("diagnosis_description"));
        claimRequest.setBatch_Date(rs.getDate("batch_Date"));
        claimRequest.setBatch_dispatch_date(rs.getString("batch_dispatch_date"));
        claimRequest.setAar_submitted_on(rs.getString("aar_submitted_on"));
        claimRequest.setSmart_pulled(rs.getInt("smart_pulled"));
        claimRequest.setSmart_pulled_on(rs.getString("smart_pulled_on"));

        return claimRequest;

    }
}
