/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.service;

import org.springframework.beans.factory.annotation.Value;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.integ.Application;
import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.model.ClaimData;
import com.smart.integ.model.stg_edi_claim.Claim;
import com.smart.integ.repository.EdiClaimRepository;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.model.MapProvider;
import com.smart.integ.model.PostEdiResponce;
import com.smart.integ.model.stg_edi_claim.Admission;
import com.smart.integ.model.stg_edi_claim.Diagnosi;
import com.smart.integ.model.stg_edi_claim.Invoice;
import com.smart.integ.model.stg_edi_claim.Line;
import com.smart.integ.model.stg_edi_claim.PreAuthorization;
import com.smart.integ.util.DateHandler;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Optional;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.http.MediaType;
import org.springframework.web.client.HttpClientErrorException;

/**
 *
 * @author John.Simiyu
 */
@Service
public class EDIClaimService implements ClaimInterface {

    ObjectMapper mapper = new ObjectMapper();

    DateHandler dateHandler = new DateHandler();

    Logger log = Logger.getLogger(EDIClaimService.class.getName());

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;

    @Autowired
    @Qualifier("plainRestTemplate")         //does not use ribbon
    private RestTemplate plainRestTemplate;

    @Autowired
    EdiClaimRepository ediClaimRepository;

    private float invoice_total;
    private float InvoiceGrossAmount;

    //    String clientId, String clientSecret
    @Value("${url.post.claim.edi}")
    private String PostClaimToEdi_url;

    @Autowired
    private TokenInterface tokenService;

    public List<Claim> getUnswitchedCalims() {
        log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS---------------\n"+PostClaimToEdi_url);
        String sql = "SELECT * FROM INTERACTIVE_EDI_CLAIMS.CLAIMS  WHERE PICK_STATUS = ?   ";
        List<Claim> claims = integJdbcTemplate.query(sql, new Object[]{0}, BeanPropertyRowMapper.newInstance(Claim.class));
//        claims.forEach((request) -> {
//            String ClaimJsonString = getClaimsToSwich(request);
//            PostClaimsToEdi(ClaimJsonString, request.getClaimCode());
//        });
        return claims;
    }

    public String getClaimsToSwich(Claim ediClaim) {
//        Claim ediClaim = new Claim();
        invoice_total = 0;
        InvoiceGrossAmount = 0;

        try {
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS-------------------- {0} ", ediClaim.getClaimCode());
//            String sql = "SELECT * FROM INTERACTIVE_EDI_CLAIMS.CLAIMS  WHERE PICK_STATUS = ?  AND CLAIM_CODE = ? FETCH FIRST 1 ROWS ONLY";
//            Claim claims = integJdbcTemplate.queryForObject(sql, new Object[]{0, Claim_code}, BeanPropertyRowMapper.newInstance(Claim.class));
////            log.log(Level.INFO, "---------FOUND {0}  UNSWITCHED CLAIMS---------------", claims); 
//            ediClaim = claims;
            ediClaim.setDispatchDate(dateHandler.dateFormatter(ediClaim.getDispatchDate()));
            ediClaim.setVisitStart(dateHandler.dateFormatter(ediClaim.getVisitStart()));
            ediClaim.setVisitEnd(dateHandler.dateFormatter(ediClaim.getVisitEnd()));
//           MapProvider mapProvider = getProvider(ediClaim.getLocationCode());
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS Diagnosi---------------{0}", ediClaim.getClaimCode());
            String sql_diagnosis = "SELECT  CLAIM_CODE,CODING_STANDARD,CODE,NAME, CASE WHEN IS_PRIMARY = 'primary'"
                    + "THEN 'true' ELSE 'false' END AS IS_PRIMARY FROM INTERACTIVE_EDI_CLAIMS.DIAGNOSIS  WHERE CLAIM_CODE = ?  ";
            List<Diagnosi> diagnosis = integJdbcTemplate.query(sql_diagnosis, new Object[]{ediClaim.getClaimCode()},
                    BeanPropertyRowMapper.newInstance(Diagnosi.class));
            ediClaim.setDiagnosis(diagnosis);
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS PRE_AUTHORIZATION---------------{0}", ediClaim.getClaimCode());
            String sql_pre_authorization = "SELECT  CODE,AMOUNT,AUTHORIZED_BY,MESSAGE FROM INTERACTIVE_EDI_CLAIMS.PRE_AUTHORIZATION "
                    + " WHERE CLAIM_CODE = ?  ";
            List<PreAuthorization> preAuthorization = integJdbcTemplate.query(sql_pre_authorization, new Object[]{ediClaim.getClaimCode()},
                    BeanPropertyRowMapper.newInstance(PreAuthorization.class));
            ediClaim.setPreAuthorization(preAuthorization);
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS ADMISSION---------------{0}", ediClaim.getClaimCode());
            String sql_ADMISSION = "SELECT  ADMIT_DATE,DISCHARGE_DATE,DISCHARGE_SUMMARY FROM INTERACTIVE_EDI_CLAIMS.ADMISSION "
                    + " WHERE CLAIM_CODE = ?  ";
            List<Admission> admission = integJdbcTemplate.query(sql_ADMISSION, new Object[]{ediClaim.getClaimCode()},
                    BeanPropertyRowMapper.newInstance(Admission.class));
//            admission.get(0).setAdmitDate(dateHandler.dateFormatter(admission.get(0).getAdmitDate()));
//            admission.get(0).setDischargeDate(dateHandler.dateFormatter(admission.get(0).getDischargeDate()));
            admission.forEach((adm) -> {
                try {
                    adm.setAdmitDate(dateHandler.dateFormatter(adm.getAdmitDate()));
                    adm.setDischargeDate(dateHandler.dateFormatter(adm.getDischargeDate()));
                } catch (ParseException ex) {
                    Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
            ediClaim.setAdmission(admission);
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS INVOICES---------------{0}", ediClaim.getClaimCode());
            String sql_INVOICES = "SELECT  AMOUNT,GROSS_AMOUNT,INVOICE_DATE,INVOICE_NUMBER,SERVICE_TYPE FROM INTERACTIVE_EDI_CLAIMS.INVOICES "
                    + " WHERE CLAIM_CODE = ?  ";
            List<Invoice> invoices = integJdbcTemplate.query(sql_INVOICES, new Object[]{ediClaim.getClaimCode()},
                    BeanPropertyRowMapper.newInstance(Invoice.class));
            invoices.forEach((invoice) -> {
                try {
                    invoice.setInvoiceDate(dateHandler.dateFormatter(invoice.getInvoiceDate()));
                } catch (ParseException ex) {
                    Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            });

            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS INVOICES LINES---------------{0}", ediClaim.getClaimCode());
            String sql_INVOICES_LINES = "SELECT  ITEM_CODE,ITEM_NAME,SERVICE_GROUP,CHARGE_DATE,UNIT_PRICE,QUANTITY,AMOUNT,"
                    + "GROSS_AMOUNT,PRE_AUTHORIZATION_CODE"
                    + " FROM INTERACTIVE_EDI_CLAIMS.LINES   WHERE CLAIM_CODE = ?  ";
            List<Line> INVOICE_lines = integJdbcTemplate.query(sql_INVOICES_LINES, new Object[]{ediClaim.getClaimCode()},
                    BeanPropertyRowMapper.newInstance(Line.class));
            log.log(Level.INFO, "---------GETTING UNSWITCHED CLAIMS INVOICES LINES---------------{0}", ediClaim.getClaimCode());
//            String sql_INVOICES_LINES = "SELECT  ITEM_CODE,REF_NUMBER  FROM INTERACTIVE_EDI_CLAIMS.LINES   WHERE CLAIM_CODE = ?  ";
//            List<Line> INVOICE_line = integJdbcTemplate.query(sql_INVOICES_LINES, new Object[]{claims.getClaimCode()},
//                    BeanPropertyRowMapper.newInstance(Line.class));
//            INVOICE_line.get(0).setPaymentReference(paymentReference);

            INVOICE_lines.forEach((INVOICE_line) -> {
                invoice_total = invoice_total + INVOICE_line.getAmount();
                InvoiceGrossAmount = InvoiceGrossAmount + INVOICE_line.getAmount();
                try {
                    INVOICE_line.setChargeDate(dateHandler.dateFormatter(INVOICE_line.getChargeDate()));
                } catch (ParseException ex) {
                    Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
                }
            });
//float total_line = INVOICE_lines.stream().map((b)->b.getGrossAmount()).reduce(invoice_total, (accumulator, a)->accumulator+a);
            float ttl_line_Amount = 0;
            ttl_line_Amount = INVOICE_lines.stream().map((b) -> b.getAmount()).reduce(ttl_line_Amount, (accumulator, _item) -> accumulator + _item);
            float ttl_line_GrossAmount = 0;
            ttl_line_GrossAmount = INVOICE_lines.stream().map((b) -> b.getAmount()).reduce(ttl_line_GrossAmount, (accumulator, _item) -> accumulator + _item);

            System.out.println(ttl_line_GrossAmount);
            System.out.println(ttl_line_Amount);

//        System.out.println(invoice_total);
            invoices.get(0).setAmount(ttl_line_Amount);
            invoices.get(0).setGrossAmount(ttl_line_GrossAmount);
            invoices.get(0).setLines(INVOICE_lines);
            ediClaim.setInvoices(invoices);
            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ediClaim);
            System.out.println(jsonInString);
//            System.out.println(new Gson().toJson(ediClaim));
//            ObjectMapper mapper = new ObjectMapper();
//            Object value = mapper.writeValue(System.out, ediClaim);
//            ObjectMapper mapper = new ObjectMapper();

//                mapper.writeValue(new File("c://tmp/ediClaim.json"), ediClaim);
//        if (claims.size() > 0) {
//        }
            return jsonInString;
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (ParseException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
//        return ediClaim;
    }

    public void processClaimToEdi(Claim claim) {
        String ClaimJsonString = getClaimsToSwich(claim);
        PostClaimsToEdi(ClaimJsonString, claim.getClaimCode());
    }

    public MapProvider getProvider(String Branch_id) {

        log.log(Level.INFO, "---------GETTING Provider Mapping ---------------");
        String sql = "SELECT PROV_NAME AS Provider_name, PROV_KEY AS Provider_code FROM "
                + "INTERACTIVE_EDI_CLAIMS.MAP_PROVIDERS mb  "
                + "WHERE   json_value(EXTRA_FIELDS_JSON , '$.branch_id')  = ?  ORDER BY PROV_KEY  DESC FETCH  FIRST  1 ROWS ONLY ";
        MapProvider mapProvider = integJdbcTemplate.queryForObject(sql, new Object[]{Branch_id}, BeanPropertyRowMapper.newInstance(MapProvider.class));
//            log.log(Level.INFO, "---------FOUND {0}  UNSWITCHED CLAIMS---------------", claims); 
        return mapProvider;

    }

    public void postclaimsToEdi2(String claimJsonString) {
        System.out.println(Application.BEARER_TOKEN);
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.set("Authorization", "Bearer " + Application.BEARER_TOKEN);

        HttpEntity<String> entity = new HttpEntity<String>(claimJsonString, headers);
        String result = plainRestTemplate.postForObject(PostClaimToEdi_url, entity, String.class);
        System.out.println(result);
    }

    public void PostClaimsToEdi(String claimJsonString, String Claim_code) {
        log.log(Level.INFO, "-------------------------SENDING CLAIMS TO EDI WITH CLAIM CODE : {0} ------------------------------", Claim_code);
        if (Checkifnull(Application.BEARER_TOKEN)) {
            tokenService.getToken();
        }
        System.out.println("TOKEN " + Application.BEARER_TOKEN);
        System.out.println("EDI LINK " + PostClaimToEdi_url);
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("Accept", "application/json");
            headers.set("content-type", "application/json");
            headers.set("Authorization", "Bearer " + Application.BEARER_TOKEN);
//        headers.set("token", "Bearer " + tokenService.getToken());
//         headers.set("token", "Bearer " + tokenService.getToken());
//        headers.set("userId", "35906");
//        headers.setContentType(MediaType.APPLICATION_JSON);
//        headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
            //Create a new HttpEntity
            final HttpEntity<String> entity = new HttpEntity<String>(claimJsonString, headers);
            ResponseEntity<PostEdiResponce> resp = plainRestTemplate.exchange(PostClaimToEdi_url, HttpMethod.POST, entity, PostEdiResponce.class);

            String jsonInString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(resp.getBody());
            System.out.println("TOKEN " + Application.BEARER_TOKEN);
            System.out.println("EDI LINK " + PostClaimToEdi_url);
            System.out.println("BODY "+jsonInString);
             System.out.println("EDI RESPONCE  "+resp);
             
            MackBackService(resp.getBody(), claimJsonString, Claim_code);
        } catch (HttpClientErrorException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void MackBackService(PostEdiResponce ediResponce, String claimJsonString, String Claim_code) {
        try {
//            2020-06-20 22:41:00
            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date date = new Date();
            String DateTime = formatter.format(date);

            log.log(Level.INFO, "-------------------------MACKBACK {0} ------------------------------", Claim_code);
            String PICK_STATUS;
            if (ediResponce.getStatusCode().equals("2000")) {
                PICK_STATUS = "1";
            } else if (ediResponce.getStatusCodeMsg() == "Unknown backend payer code") {
                PICK_STATUS = "3";
            } else {

                PICK_STATUS = "2";
            }

            String PICKED_DATE;
            PICKED_DATE = DateTime;
            String JSON_CLAIM = claimJsonString;
            String EDI_RESPONCE;
            EDI_RESPONCE = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(ediResponce);

            String CLAIM_CODE = Claim_code;
            String sqlInsert = "UPDATE   INTERACTIVE_EDI_CLAIMS.CLAIMS  SET  PICK_STATUS = ?"
                    + ",PICKED_DATE = current_timestamp ,JSON_CLAIM = ?,EDI_RESPONCE =? WHERE CLAIM_CODE = ? ";
            integJdbcTemplate.update(sqlInsert, PICK_STATUS, JSON_CLAIM, EDI_RESPONCE, CLAIM_CODE);
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DuplicateKeyException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        } catch (DataAccessException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean Checkifnull(String x) {
        // for Null value 
        Optional<String> check = Optional.ofNullable(x);
        // If the value in the current instance is null, 
        // it will return false, else true 
        if (check.isPresent()) {
            return false;
        } else // As the current value is null 
        {
            return true;
        }
    }
}
