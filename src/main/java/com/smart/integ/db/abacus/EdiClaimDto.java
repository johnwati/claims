/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.db.abacus;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

/**
 *
 * @author John.Simiyu
 */
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class EdiClaimDto {

    private String POLICY_NUMBER,PROVIDER_CODE,MEMBERSHIP_NUMBER,MEMBER_NAME;
    private String CARD_SERIAL,TRANSACTION_DATE,SERVICE_DESCRIPTION,BENEFIT_CODE;
    private String AMOUNT,DATE_RECEIVED,PROVIDER_CLAIM_ID,SMART_INVOICE_NR,ADMIT_ID;
    private String CLAIM_ID,INSERT_DATE,STAFF_NUMBER,COUNTRY_CODE,CURRENCY_CODE;
    private String CURRENCY_CONV_RATE,IS_ROAMING,ROAMING_AMOUNT,ROAMING_COUNTRY;
    private String DIAGNOSIS_CODE,DIAGNOSIS_DESCRIPTION,POLICY_CURRENCY_CODE;
    private String IS_OPENTICKET,IS_OPENBATCH,BATCH_NO,BATCH_AMT,BATCH_TYPE,VISIT_NUMBER;
    private String CURRENCY,REJECT_COUNT,BATCH_CLOSE_TIME,BATCH_TIME,CLOSED_BY,USER_EMAIL; 
}
