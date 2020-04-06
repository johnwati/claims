/**
* JAVADOC
* details here
**/
package com.smart.integ.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;

import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.model.AuthToken;

import java.util.logging.Logger;

@Service("tokenservice")
public class TokenService implements TokenInterface {

    Logger log = Logger.getLogger(EDIService.class.getName());

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;


    @Autowired
    @Qualifier("plainRestTemplate")         //does not use ribbon
    private RestTemplate plainRestTemplate;

    public String getToken(String clientId, String clientSecret){

        String url = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=" + clientId + "&client_secret=" + clientSecret + "&grant_type=client_credentials";      
        
        log.info("Preparing request to ... " + url);
        
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");

        final HttpEntity<String> entity = new HttpEntity<String>(headers);

        //NB: Endpoint will return 404 if you use GET instead of POST
        ResponseEntity<AuthToken> resp = plainRestTemplate.exchange(url, HttpMethod.POST, entity, AuthToken.class);  
    
        log.info("resp token = " + resp.getBody().getAccess_token());

        return resp.getBody().getAccess_token();

        }

    
}
