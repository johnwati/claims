/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.repository;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.integ.model.ClaimData;
import com.fasterxml.jackson.databind.*;
import java.util.logging.Logger;
import javax.sql.DataSource;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John.Simiyu
 */
@Repository
public class EdiClaimRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    DataSource ds = null;

    String clients = "ril";             //codes
    String clientIds = "61000954";      //abacus cust_id
    String customerIds = "156578462";
    String smartProviderCodes = "SKSP_358";
    Logger log = Logger.getLogger(EdiClaimRepository.class.getName());

    public void PersistClaims(ClaimData claimData) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        String claismString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(claimData);
        log.info("No of claims fetched:  " + claismString);
        //1. Check the query offset (actualy iteration count) from cache. if none use zero

        if (claimData.getClaims().size() == 0) {
            log.warning("NO CLAIMS found... checking next provider");
        } else {
            for (int i = 0; i < claimData.getClaims().size(); i++) {
                //3. Cache'em one by one
                log.info("FOUND CLAIM WITH CLAIM CODE: " + claimData.getClaims().get(i).getClaimCode());
                String prov = claimData.getClaims().get(i).getProviderCode();
                String claimsKey = "integ:edi:claims:outgoing:" + clients + ":" + prov + ":json";
                String claim_data = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(claimData.getClaims().get(i));
                log.info("CLAIM DATA:  " + claim_data);
                String cacheEdiSql = "INSERT INTO INTEG_API.edi_claim_cache(claims_key, claim_code, customer_id, smart_prov_code, request_url, claim_json) VALUES(?,?,?,?,?,?)";
                jdbcTemplate.update(cacheEdiSql, claimsKey, claimData.getClaims().get(i).getClaimCode(), customerIds, prov, "", claim_data);    //toJSONString                    

                //4. Update offset....
                String fetch_id_to = claimData.getFetchIdTo().toString();
                if (fetch_id_to != null && !fetch_id_to.equals("0")) {
                } else {
                    log.info("No new offset. Leaving the current one intact !!!");
                }
            }
        }
    }

}
