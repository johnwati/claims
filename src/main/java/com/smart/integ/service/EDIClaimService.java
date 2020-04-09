/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smart.integ.Application;
import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.model.ClaimData;
import com.smart.integ.model.TokenModel;
import com.smart.integ.repository.EdiClaimRepository;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author John.Simiyu
 */
@Service
public class EDIClaimService implements ClaimInterface {

    Logger log = Logger.getLogger(EDIService.class.getName());
    
    @Autowired
    @Qualifier("plainRestTemplate")         //does not use ribbon
    private RestTemplate plainRestTemplate;
    
    @Autowired
    EdiClaimRepository ediClaimRepository;
    String url = "https://data.smartapplicationsgroup.com/api/v2/integqa/claims/edi?customerid=RESOECLAIMS&countrycode=KE&isUpdate=false";

    public Void fetchClaim()  {
        ObjectMapper mapper = new ObjectMapper();
        log.info("Preparing request to ... " + url);
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("userId", "35906");     //INTEGEDI @ production/qa 
        headers.set("Authorization", "Bearer " + Application.BEARER_TOKEN);
        //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);
        ResponseEntity<ClaimData> resp = plainRestTemplate.exchange(url, HttpMethod.GET, entity, ClaimData.class);
        try {
            //   log.info("resp = " + resp.getBody());
            // Object to JSON in String
            String jsonInString = mapper.writeValueAsString(resp.getBody().getClaims());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }
        log.info("No of claims fetched:  " + resp.getBody().getClaims().size());
        try {
            ediClaimRepository.PersistClaims(resp.getBody());
        } catch (JsonProcessingException ex) {
            Logger.getLogger(EDIClaimService.class.getName()).log(Level.SEVERE, null, ex);
        }
//        log.info("CLAIM LIST :  " + jsonInString);
        return null;
    }
}
