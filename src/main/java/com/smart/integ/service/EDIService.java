/**
* JAVADOC
* details here
**/
package com.smart.integ.service;

import java.util.Map;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Random;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.*;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.context.annotation.Scope;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

import org.springframework.web.context.WebApplicationContext;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.ui.Model;
import org.springframework.scheduling.annotation.Async;


import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import org.springframework.core.env.Environment;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import java.util.logging.Logger;
//import org.apache.commons.lang.StringUtils;
import org.springframework.web.client.RestTemplate;



@Service("ediservice")
public class EDIService implements EDIInterface {

    Logger log = Logger.getLogger(EDIService.class.getName());

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    LocalDate now;
    //https://www.journaldev.com/18141/spring-boot-redis-cache
    //https://docs.spring.io/spring/docs/current/spring-framework-reference/integration.html#cache
    //https://www.baeldung.com/spring-data-redis-tutorial

    //public Map<String,String> fetchEDIClaimsBasic(Integer clientid, Integer providerid, Integer offset){
    //public String fetchEDIClaimsBasic(Integer clientid, Integer providerid, Integer offset){
    public String fetchEDIClaimsBasic(Integer clientid, String smartProviderCode, Integer offset){

        Map<String,String> props = new HashMap<String,String>();
        //props.put("hello","world");
        
        now = LocalDate.now();
        
        //Production. Need to use integ endpoint
        String url = "https://data.smartapplicationsgroup.com/api/abacus/edi/claims/fetch2?lastFetchId=" + offset + "&provCode=" + smartProviderCode;      
        //String url = "https://data.smartapplicationsgroup.com/api/abacus/integ/claims/fetch?provCode=" + smartProviderCode + "&dateFrom=" + now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();      
        
        //QA dev
        //String url = "https://data.smartapplicationsgroup.com/qa/abacus/edi/claims/fetch2?lastFetchId=" + offset + "&provCode=" + smartProviderCode  + "&dateFrom=2019-06-01";      
        
        //Date        
        //String url = "https://data.smartapplicationsgroup.com/api/abacus_qa/edi/claims/fetch2?lastFetchId=" + offset + "&provCode=" + smartProviderCode + "&dateFrom=" + now.getYear() + "-" + now.getMonthValue() + "-" + now.getDayOfMonth();      
  
        log.info("Preparing request to ... " + url);

       
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("userId", "35906");     //INTEGEDI @ production/qa


        // //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        //return restTemplate.exchange("https://httpbin.org/user-agent", HttpMethod.GET, entity, String.class);        
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);                
        
        log.info("resp = " + resp.getBody());

        return resp.getBody();

        }


public List<JsonObject> toJsonObjectFull(String resp){

    JsonArray jsonarray = null;
    List<JsonObject> jsonData = null;

    try {

        Object o = null;
        String balance = "";
            o = Jsoner.deserialize(resp);
            //log.info("JSON Type = " + o.getClass());

            if(o instanceof org.json.simple.JsonObject){
                //log.info("Response is JsonObject");
                JsonObject obj = (JsonObject)o;

                jsonData = new ArrayList<JsonObject>();
                jsonData.add(obj);
                }
            else{
                //log.info("Response is " + c);
                jsonarray = (JsonArray) Jsoner.deserialize(resp);
                jsonData = new ArrayList<JsonObject>();
                jsonarray.asCollection(jsonData);
                }
            return jsonData;
            }
        catch(Exception e){
            log.info("ERROR : " + e.getMessage());
            return null;
            }

        }



    //public JsonArray fetchEDIClaimsJson(Integer clientid, Integer providerid, Integer offset){
    public JsonArray fetchEDIClaimsJson(Integer clientid, String smartProviderCode, Integer offset){        
        String strClaimsList = fetchEDIClaimsBasic(clientid, smartProviderCode, offset);
        JsonObject ediClaimsObject = toJsonObjectFull(strClaimsList).get(0);
        JsonArray claimList = (JsonArray)ediClaimsObject.get("claims");
        return claimList;
        }

    //public JsonObject fetchEDIClaimsObjectJson(Integer clientid, Integer providerid, Integer offset){
    public JsonObject fetchEDIClaimsObjectJson(Integer clientid, String smartProviderCode, Integer offset){        
    
        String strClaimsList = fetchEDIClaimsBasic(clientid, smartProviderCode, offset);
        JsonObject ediClaimsObject = toJsonObjectFull(strClaimsList).get(0);
        //JsonArray claimList = (JsonArray)ediClaimsObject;

        return ediClaimsObject;
        }

    
}
