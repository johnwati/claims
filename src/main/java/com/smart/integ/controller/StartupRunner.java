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
import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.interfaces.ProviderClaimsInterface;
import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.stg_edi_claim.Claim;
import com.smart.integ.repository.AbacusRepository;
import com.smart.integ.threads.ThreadInterface;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartupRunner implements ApplicationRunner {

    @Autowired
    private TokenInterface tokenService;

    @Autowired
    private ClaimInterface claimInterface;

    @Autowired
    private ProviderClaimsInterface providerClaimsInterface;

    @Autowired
    AbacusRepository abacusRepository;

    @Autowired
    private RestTemplate restTemplate;
    Logger log = Logger.getLogger(StartupRunner.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("*****************************GETTING NEW TOKEN*****************************");
        Application.BEARER_TOKEN = tokenService.getToken();
        log.info("*****************************UPDATING TOKEN : " + Application.BEARER_TOKEN+"*****************************");
        ThreadInterface threadInterface = new ThreadInterface(providerClaimsInterface, claimInterface, abacusRepository);
        log.log(Level.INFO, "*****************************PROVIDER CLAIMS SERVICE ACTIVATED********************************");
        threadInterface.getProviderClaims();
        log.log(Level.INFO, "**************************POST CLAIM TO EDI  SERVICE ACTIVATED***********************");
        threadInterface.postToEdiClaims();
        log.log(Level.INFO, "**************************LOG PROVIDER UNSUBMITTED CLAIMS SERVICE ACTIVATED***********************");
        threadInterface.logProviderUnsubmittedInvoices();

//        log.log(Level.INFO, "*****************************PROVIDER CLAIMS SERVICE ACTIVATED********************************");
//        ThreadInterface threadInterface = new ThreadInterface(providerClaimsInterface, claimInterface, abacusRepository);
//        threadInterface.getProviderClaims();
//        
//        
//        providerClaimsInterface.ProviderLogUnsubmittedInvoices();
////        
////        ThreadInterface PostEdiThread = new ThreadInterface(providerClaimsInterface, claimInterface);
//        log.log(Level.INFO, "**************************POST CLAIM TO EDI  SERVICE ACTIVATED***********************");
//        PostEdiThread.postToEdiClaims();
//        log.info("============================POSTING CLAIMS TO EDI=====================================");
//        List<Claim> claims = claimInterface.getUnswitchedCalims();
//        log.log(Level.INFO, "================ {0}  CLAIMS PROCESSED TO  EDI =======================", claims.size());
//         List<ClaimRequest> requests = providerClaimsInterface.fetchProviderClaims();
//        log.log(Level.INFO, "============= {0} CLAIMS PROCESSED FROM THE PROVIDER =========", requests.size());
//        
//         List<Claim> claims = claimInterface.getUnswitchedCalims();
//        log.log(Level.INFO, "================ {0}  CLAIMS PROCESSED FROM THE PROVIDER =======================", claims.size());
//        
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
//                TokenModel tokenModel = authService.creatToken();
//                log.info("resp = " + tokenModel.access_token);
        //        log.info("GETTING NEW TOKEN");
//                Application.BEARER_TOKEN = tokenService.getToken();
//        System.out.println(providerClaimsInterface.fetchProviderClaims().toString());
//        providerClaimsInterface.fetchProviderClaims().forEach(action);
//        requests.forEach((request) -> {
//            List<Claim> claims =  providerClaimsInterface.invoice_CLAIM_EXIST(request);
//            if(claims.size() > 0){
//                providerClaimsInterface.provMarkBack(request);
//            }
//        }); 
//        unSwitchedClaims.forEach((request) -> {
////            providerClaimsInterface.invoice_CLAIM_EXIST(request);
//            String ClaimJsonString = claimInterface.getClaimsToSwich(request);
//            claimInterface.PostClaimsToEdi(ClaimJsonString, request.getClaimCode());
////            claimInterface.postclaimsToEdi2(ClaimJsonString);
////            System.out.println(ClaimJsonString);
//        });
//        DateHandler dateHandler = new DateHandler();
////        dateHandler.dateCoversion2("Jun 15 2020 11:24AM");
//        
//        dateHandler.dateConvserter("Jun 15 2020 11:24AM");
    }
}


