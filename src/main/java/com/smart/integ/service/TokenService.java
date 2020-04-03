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

import com.smart.integ.interfaces.TokenInterface;

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
import org.springframework.web.client.RestTemplate;



@Service("tokenservice")
public class TokenService implements TokenInterface {

    Logger log = Logger.getLogger(EDIService.class.getName());

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    private RestTemplate restTemplate;

    LocalDate now;

    public String getToken(String clientId, String clientSecret){

        //String url = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=JUBILEEECLAIMS&client_secret=J-XkwYmHJ3PerbOD8qrg9qR5w7I&grant_type=client_credentials";      
        String url = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials";      
        
        log.info("Preparing request to ... " + url);
        
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        //headers.set("userId", "35906");     //INTEGEDI @ production/qa

        // //Create a new HttpEntity
        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        //return restTemplate.exchange("https://httpbin.org/user-agent", HttpMethod.GET, entity, String.class);        
        ResponseEntity<String> resp = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);                
        
        log.info("resp = " + resp.getBody());

        return resp.getBody();

        }

    
}
