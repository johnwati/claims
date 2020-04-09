/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.controller;

/**
 *
 * @author John.Simiyu
 */
import com.smart.integ.Application;
import com.smart.integ.config.Constants;
import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.model.TokenModel;
import com.smart.integ.service.EDIService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartupRunner implements ApplicationRunner {

    @Autowired
    private TokenInterface tokenService;

    @Autowired
    private RestTemplate restTemplate;
    String url = "https://data.smartapplicationsgroup.com/auth/integ-clients/oauth/token?client_id=RESOECLAIMS&client_secret=zDPxTn6V3fql3oh00xIKLbNgkj4&grant_type=client_credentials";
    Logger log = Logger.getLogger(EDIService.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
//        log.info("resp = " + constants.getAuth_link());
//        log.info("Preparing request to ... " + url);
//        //Set the headers you need send
//        HttpHeaders headers = new HttpHeaders();
//        headers.set("Accept", "application/json");
//        headers.set("userId", "35906");     //INTEGEDI @ production/qa 
//        // //Create a new HttpEntity
//        final HttpEntity<String> entity = new HttpEntity<String>(headers);
//        //return restTemplate.exchange("https://httpbin.org/user-agent", HttpMethod.GET, entity, String.class);        
//        ResponseEntity<TokenModel> resp = restTemplate.exchange(url, HttpMethod.POST, entity, TokenModel.class); 
//        log.info("resp = " + resp.getBody().access_token);

//        TokenModel tokenModel = authService.creatToken();
//        log.info("resp = " + tokenModel.access_token);
        log.info("GETTING NEW TOKEN");
        Application.BEARER_TOKEN = tokenService.getToken("RESOECLAIMS", "zDPxTn6V3fql3oh00xIKLbNgkj4");
    }
}
