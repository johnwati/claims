/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.integ.interfaces.ProviderClaimsInterface;
import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.Diagnosi;
import com.smart.integ.model.EdiSlClaims;
import com.smart.integ.model.MapProvider;
import com.smart.integ.model.UnsubmitedInvoicesModel;
import com.smart.integ.model.stg_edi_claim.Claim;
import com.smart.integ.repository.AbacusRepository;
import com.smart.integ.repository.ProviderRepository;
import com.smart.integ.util.CustomerRowMapper;
import com.smart.integ.util.DateHandler;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.http.HttpStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
//import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 *
 * @author John.Simiyu
 */
@Service
public class ProviderClaimsService implements ProviderClaimsInterface {

    @Autowired
    @Qualifier("aarJdbcTemplate")
    private JdbcTemplate aarJdbcTemplate;

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;
    private final ObjectMapper mapper = new ObjectMapper();

    Logger log = Logger.getLogger(ProviderClaimsService.class.getName());

    @Autowired
    AbacusRepository abacusRepository;

    @Autowired
    ProviderRepository providerRepository;

    @Value("${app.prov_code}")
    private String prov_code;

//    public List<ClaimRequest> getClaimsToSwitch() {
//
//    }
    public List<ClaimRequest> fetchProviderClaims() {
        String sql = "SELECT * FROM smart_eclaims.dbo.smart_eclaims_submitted where smart_pulled = 0";
        List<ClaimRequest> requests = aarJdbcTemplate.query(sql, new CustomerRowMapper());
//        requests.forEach((request) -> {
//            List<Claim> claims = invoice_CLAIM_EXIST(request);
//            if (claims.size() > 0) {
//                provMarkBack(request);
//            }
//        });
        return requests;
    }

    public void processProviderClaim(ClaimRequest request) {
        List<Claim> claims = invoice_CLAIM_EXIST(request);
        if (claims.size() > 0) {
            provMarkBack(request);
        }
    }

    public List<Claim> invoice_CLAIM_EXIST(ClaimRequest claimRequest) {

        String sql = "SELECT * FROM INTERACTIVE_PROV_CLAIMS.CLAIMS  WHERE CLAIM_CODE = ?";
        log.log(Level.INFO, "---------CHECKING IF CLAIM EXIST---------------{0}", claimRequest.invoice_number);
        List<Claim> claims = integJdbcTemplate.query(sql, new Object[]{claimRequest.invoice_number}, BeanPropertyRowMapper.newInstance(Claim.class));
        if (claims.size() > 0) {
            createDiagnosis(claimRequest);
            createAdmission(claimRequest);
            CreatePreAuthorization(claimRequest);
            createInvoice(claimRequest);
            createInvoiceLines(claimRequest);
            createPaymentRefrence(claimRequest);
            return claims;
        } else {
//            if (checkProviderMapping(claimRequest.branch_id) > 0) {
//            MapProvider mapProvider = getProvider(claimRequest.branch_id);
            log.log(Level.INFO, "SAVING NEW CLAIM CODE: {0}", claimRequest.invoice_number);
            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.CLAIMS "
                    + "(CLAIM_CODE,"
                    + "PAYER_CODE,"
                    + "PAYER_NAME,"
                    //                    + "AMOUNT,"
                    //                    + "GROSS_AMOUNT,"
                    + "BATCH_NUMBER,"
                    + "DISPATCH_DATE,"
                    + "PATIENT_NUMBER,"
                    + "PATIENT_NAME,"
                    + "LOCATION_CODE,"
                    + "LOCATION_NAME,"
                    + "SCHEME_CODE,"
                    + "SCHEME_NAME,"
                    + "MEMBER_NUMBER,"
                    + "VISIT_NUMBER,"
                    + "VISIT_START,"
                    + "VISIT_END,"
                    + "CURRENCY,"
                    + "DOCTOR_NAME,"
                    + "FILE_VERSION,PROV_CODE)"
                    + " VALUES (?, ?, ?,?, ?, ?, ?,?,?, ?, ?, ?,?,?, ?, ?, ?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.claim_code,
                    claimRequest.payer_code,
                    claimRequest.payer_name,
                    //                   claimRequest.amount,
                    //                   claimRequest.amount,
                    claimRequest.batch_number,
                    claimRequest.discaharge_date,
                    claimRequest.patient_number,
                    claimRequest.patient_name,
                    claimRequest.branch_id,//mapProvider.getProvider_code(),//
                    claimRequest.branch_name, // mapProvider.getProvider_name(), //  
                    claimRequest.scheme_code,
                    claimRequest.scheme_code,
                    claimRequest.insurance_Number,
                    claimRequest.visit_number,
                    claimRequest.admission_date,
                    claimRequest.admission_date,
                    "KES",
                    claimRequest.doctor_name,
                    claimRequest.file_version,
                    prov_code);

            createDiagnosis(claimRequest);
            createAdmission(claimRequest);
            CreatePreAuthorization(claimRequest);
            createInvoice(claimRequest);
            createInvoiceLines(claimRequest);
            createPaymentRefrence(claimRequest);

            String sql2 = "SELECT * FROM INTERACTIVE_PROV_CLAIMS.CLAIMS  WHERE CLAIM_CODE = ?";
            log.log(Level.INFO, "---------CHECKING IF CLAIM EXIST---------------{0}", claimRequest.invoice_number);
            List<Claim> claims2 = integJdbcTemplate.query(sql2, new Object[]{claimRequest.invoice_number}, BeanPropertyRowMapper.newInstance(Claim.class));
            claims = claims2;
//            }

        }
        return claims;
    }

    private boolean isUserExists(ClaimRequest claimRequest) {

        String sql = "SELECT count(*) FROM COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.DIAGNOSIS WHERE PROVIDER_CLAIM_ID = ?";
        boolean result = false;

        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_id}, Integer.class);

        if (count > 0) {
            result = true;
        }

        return result;
    }

    public void createDiagnosis(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.DIAGNOSIS "
                + " WHERE CLAIM_CODE = ? AND CODING_STANDARD = ? AND CODE = ? AND  NAME = ? AND IS_PRIMARY = ?";
        log.info("---------CHECKING IF DIAGNOSIS EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_code, claimRequest.diagnosis_standard,
                    claimRequest.diagnosis_code, claimRequest.diagnosis_description, claimRequest.Diagnosis_type}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "DIAGNOSIS EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING DIAGNOSIS FOR CLAIM CODE: {0}", claimRequest.invoice_number);
            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.DIAGNOSIS "
                    + "(CLAIM_CODE,"
                    + "CODING_STANDARD,"
                    + "CODE,"
                    + "NAME,"
                    + "IS_PRIMARY,"
                    + "PROVIDER_CLAIM_ID,"
                    + "PRO_CLAIM_UNIQUE_IDENTIFIER , PROV_CODE"
                    + ") VALUES (?,?,?,?,?,?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.claim_code,
                    claimRequest.diagnosis_standard,
                    claimRequest.diagnosis_code,
                    claimRequest.diagnosis_description,
                    claimRequest.Diagnosis_type,
                    claimRequest.claim_id,
                    claimRequest.claim_unique_identifier,prov_code
            );

        };
    }

    public void createAdmission(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.ADMISSION "
                + " WHERE CLAIM_CODE = ? AND ADMIT_DATE = ?";
        log.info("---------CHECKING IF ADMISSION EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_code, claimRequest.admission_date}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "ADMISSION EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING ADMISSION FOR CLAIM CODE: {0}", claimRequest.invoice_number);
            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.ADMISSION ("
                    + "CLAIM_CODE,"
                    + "ADMIT_DATE,"
                    + "DISCHARGE_DATE,"
                    + "DISCHARGE_SUMMARY,"
                    + "PROVIDER_CLAIM_ID,"
                    + "PRO_CLAIM_UNIQUE_IDENTIFIER,PROV_CODE)"
                    + "values(?,?,?,?,?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.claim_code,
                    claimRequest.admission_date,
                    claimRequest.admission_date,
                    claimRequest.discharge_summary,
                    claimRequest.claim_id,
                    claimRequest.claim_unique_identifier,prov_code
            );

        };
    }

    public void CreatePreAuthorization(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.PRE_AUTHORIZATION "
                + " WHERE (CLAIM_CODE = ? AND CODE = ?)  OR (PROVIDER_CLAIM_ID = ? AND PRO_CLAIM_UNIQUE_IDENTIFIER = ?)";
        log.info("---------CHECKING IF CLAIMS PRE_AUTHORIZATION EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_code, claimRequest.preauthorisation_code, claimRequest.claim_id, claimRequest.claim_unique_identifier}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "PRE_AUTHORIZATION EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING PRE_AUTHORIZATION FOR CLAIM CODE: {0}", claimRequest.invoice_number);
            if (!StringUtils.isEmpty(claimRequest.preauthorisation_code)
                    || !StringUtils.isEmpty(claimRequest.preauthorisation_amount)
                    || !StringUtils.isEmpty(claimRequest.preauthorisation_athourised_by)) {
                String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.PRE_AUTHORIZATION ("
                        + "CLAIM_CODE,"
                        + "CODE,"
                        + "AMOUNT,"
                        + "AUTHORIZED_BY,"
                        + "MESSAGE ,"
                        + "PROVIDER_CLAIM_ID,"
                        + "PRO_CLAIM_UNIQUE_IDENTIFIER,PROV_CODE)"
                        + "VALUES (?,?,?,?,?,?,?,?)";
                integJdbcTemplate.update(sqlInsert,
                        claimRequest.claim_code,
                        claimRequest.preauthorisation_code,
                        claimRequest.preauthorisation_amount,
                        claimRequest.preauthorisation_athourised_by,
                        "",
                        claimRequest.claim_id,
                        claimRequest.claim_unique_identifier,prov_code
                );
            } else {
                log.log(Level.INFO, " PRE_AUTHORIZATION  N/A FOR CLAIM CODE: {0}", claimRequest.invoice_number);
            }

        };
    }

    public void createInvoice(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.INVOICES "
                + " WHERE CLAIM_CODE = ?  ";
        log.info("---------CHECKING IF INVOICES EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.invoice_number}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "INVOICES EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING INVOICE FOR CLAIM CODE: {0}", claimRequest.invoice_number);

            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.INVOICES ("
                    + "CLAIM_CODE,"
                    + "INVOICE_DATE,"
                    + "INVOICE_NUMBER,"
                    + "SERVICE_TYPE,prov_code ) VALUES (?,?,?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.claim_code,
                    claimRequest.invoice_date,
                    claimRequest.invoice_number,
                    claimRequest.service_type,prov_code
            );

        };

    }

    public void createInvoiceLines(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.LINES "
                + " WHERE PROVIDER_CLAIM_ID = ? AND PRO_CLAIM_UNIQUE_IDENTIFIER = ?";
        log.info("---------CHECKING IF INVOICES LINE EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_id, claimRequest.claim_unique_identifier}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "INVOICES LINE EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING INVOICE LINE FOR CLAIM CODE: {0}", claimRequest.invoice_number);

            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.LINES ("
                    + "ITEM_CODE,"
                    + "ITEM_NAME,"
                    + "SERVICE_GROUP,"
                    + "CHARGE_DATE,"
                    + "UNIT_PRICE,"
                    + "QUANTITY,"
                    + "AMOUNT,"
                    + "GROSS_AMOUNT,"
                    + "PRE_AUTHORIZATION_CODE,"
                    + "CLAIM_CODE,"
                    + "PROVIDER_CLAIM_ID,"
                    + "PRO_CLAIM_UNIQUE_IDENTIFIER,prov_code"
                    + ")VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.service_code,
                    claimRequest.description,
                    claimRequest.Service_Group,
                    claimRequest.Charge_Date,
                    claimRequest.unit_price,
                    claimRequest.quantity,
                    claimRequest.amount,
                    claimRequest.amount,
                    claimRequest.preauthorisation_code,
                    claimRequest.invoice_number,
                    claimRequest.claim_id,
                    claimRequest.claim_unique_identifier,prov_code
            );

        };

    }

    public void createPaymentModifires() {

    }

    public void createPaymentRefrence(ClaimRequest claimRequest) {
        String sql = "SELECT COUNT(*) FROM INTERACTIVE_PROV_CLAIMS.PAYMENT_REFERENCE "
                + " WHERE PROVIDER_CLAIM_ID = ? AND PRO_CLAIM_UNIQUE_IDENTIFIER = ?";
        log.info("---------CHECKING IF INVOICES LINE PAYMENT_REFERENCE EXIST---------------");
        int count = integJdbcTemplate.queryForObject(
                sql, new Object[]{claimRequest.claim_id, claimRequest.claim_unique_identifier}, Integer.class);
        log.log(Level.INFO, "FOUDN {0}", count);
        if (count > 0) {
            log.log(Level.INFO, "INVOICES LINE PAYMENT_REFERENCE EXIST FOR CLAIMS: {0}", claimRequest.invoice_number);
        } else {
            log.log(Level.INFO, "SAVING INVOICE LINE PAYMENT_REFERENCE FOR CLAIM CODE: {0}", claimRequest.invoice_number);

            String sqlInsert = "INSERT INTO INTERACTIVE_PROV_CLAIMS.PAYMENT_REFERENCE ("
                    + "ITEM_CODE,"
                    + "REF_NUMBER,"
                    + "PROVIDER_CLAIM_ID,"
                    + "PRO_CLAIM_UNIQUE_IDENTIFIER,prov_code)VALUES (?,?,?,?,?)";
            integJdbcTemplate.update(sqlInsert,
                    claimRequest.service_code,
                    claimRequest.transation_reference_number,
                    claimRequest.claim_id,
                    claimRequest.claim_unique_identifier,prov_code
            );

        };

    }

    public String dateFormatter(String date_to_format) throws ParseException {

//        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX");
//        Date date = dateFormat.parse("2017-04-26T20:55:00.000Z");//You will get date object relative to server/client timezone wherever it is parsed
//        DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd"); //If you need time just put specific format for time like 'HH:mm:ss'
//        String dateStr = formatter.format(date);
//        log.info("New Date:  " + dateStr);
//      2019-07-25T19:04:14
//        19-07-25T19:04:14
//      2019-07-25T19:04:14
//        19-07-25T19:04:14
//      2019-07-25T19:04:14.000+03:00
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Date date = dateFormat.parse("2019-07-25 19:04:14");
        Date date = dateFormat.parse(date_to_format);
        DateFormat formatter = new SimpleDateFormat("YYYY-MM-dd");
        String dateStr = formatter.format(date);
        log.info("New Date2:  " + dateStr);
        return dateStr;

    }

    public MapProvider getProvider(int Branch_id) {

        log.log(Level.INFO, "---------GETTING Provider Mapping ---------------");
        String sql = "SELECT PROV_NAME AS Provider_name, PROV_KEY AS Provider_code FROM "
                + "INTERACTIVE_PROV_CLAIMS.MAP_PROVIDERS mb  "
                + "WHERE   json_value(EXTRA_FIELDS_JSON , '$.branch_id')  = ?  ORDER BY PROV_KEY  DESC FETCH  FIRST  1 ROWS ONLY ";
        MapProvider mapProvider = integJdbcTemplate.queryForObject(sql, new Object[]{Branch_id}, BeanPropertyRowMapper.newInstance(MapProvider.class));
//            log.log(Level.INFO, "---------FOUND {0}  UNSWITCHED CLAIMS---------------", claims); 
        return mapProvider;

    }

    public int checkProviderMapping(int Branch_id) {
        String sql = "SELECT count(*) FROM  INTERACTIVE_PROV_CLAIMS.MAP_PROVIDERS mb  "
                + "WHERE   json_value(EXTRA_FIELDS_JSON , '$.branch_id')  = ?  ";

        log.info("---------CHECKING IF PROVIDER BRANCH MAPPING ---------------");
        int count = integJdbcTemplate.queryForObject(sql, new Object[]{Branch_id}, Integer.class);
//      
        if (count > 0) {
            log.log(Level.INFO, "---------PROVIDER BRANCH ID  {0}  MAPPED ---------------", Branch_id);
        } else {
            log.log(Level.INFO, "---------PROVIDER BRANCH ID  {0} NOT MAPPED ---------------", Branch_id);
        }
        log.log(Level.INFO, "FOUDN {0}", count);
        return count;
    }

    public void provMarkBack(ClaimRequest claimRequest) {
        try {
            SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
            Date date = new Date();
            System.out.println(formatter.format(date));
            String time = formatter.format(date);
            String sql = "UPDATE smart_eclaims.dbo.smart_eclaims_submitted  set smart_pulled = ? , smart_pulled_on = ? where claim_id = ?";
            aarJdbcTemplate.update(sql, 1, time, claimRequest.claim_id);
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataAccessException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void logProviderUnsubmittedInvoices(EdiSlClaims ediSlClaims) {
        log.log(Level.INFO, "================= CHECKING INVOICE : {0} ====================", ediSlClaims.getINVOICE_NUMBER().toString());
//        System.out.println(ediSlClaims.getINVOICE_NUMBER().toString());
        Integer ClaimCount = providerRepository.fetchProviderClaims(ediSlClaims.getINVOICE_NUMBER().toString());
        System.out.println(ClaimCount);
        if (ClaimCount <= 0) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();
//            System.out.println(dtf.format(now));
            String start_date = ediSlClaims.getINSERT_TIME().toString();// "2021-01-12 14:43:04"; 
            if (start_date.length() > 19) {
                start_date = start_date.substring(0, 19);
            } else {
                start_date = start_date;
            }
//            System.out.println(start_date);
//            String end_date = dtf.format(now); 
            DateHandler datehandler = new DateHandler();
            long no_of_delayed_days = datehandler.findDifference(ediSlClaims.getINSERT_TIME(), dtf.format(now));
            UnsubmitedInvoicesModel unsubmitedInvoice = new UnsubmitedInvoicesModel();
            unsubmitedInvoice.setClaim_datetime(start_date);
            unsubmitedInvoice.setInvoice_number(ediSlClaims.getINVOICE_NUMBER().toString());
            unsubmitedInvoice.setPayer_name(ediSlClaims.getPAYER_NAME().toString());
            unsubmitedInvoice.setClinic_name(ediSlClaims.getLOCATION_NAME().toString());
            unsubmitedInvoice.setNo_of_delayed_days(no_of_delayed_days);
            unsubmitedInvoice.setScheme_name(ediSlClaims.getSCHEME_NAME());
            providerRepository.logUnsubmittedInvoices(unsubmitedInvoice);
        }

    }

}










