//// /*
////  * To change this license header, choose License Headers in Project Properties.
////  * To change this template file, choose Tools | Templates
////  * and open the template in the editor.
////  */
//// package com.smart.integ.daemon;
//
//// import com.smart.integ.interfaces.ClaimInterface;
//// import com.smart.integ.interfaces.ProviderClaimsInterface;
//// import com.smart.integ.model.stg_edi_claim.Claim;
//// import com.smart.integ.repository.AbacusRepository;
//// import com.smart.integ.threads.ThreadInterface;
//// import java.util.List;
//// import java.util.logging.Level;
//// import java.util.logging.Logger;
//// import org.springframework.beans.factory.annotation.Autowired;
//// import org.springframework.scheduling.annotation.EnableScheduling;
//// import org.springframework.scheduling.annotation.Scheduled;
//// import org.springframework.stereotype.Component;
//
//// /**
////  *
////  * @author John.Simiyu
////  */
//// @Component
//// @EnableScheduling
//// public class EDIClaimsDaemon {
//
////     @Autowired
////     private ClaimInterface claimInterface;
//
////     @Autowired
////     AbacusRepository abacusRepository;
//
////     @Autowired
////     private ProviderClaimsInterface providerClaimsInterface;
////     Logger log = Logger.getLogger(RenewToken.class.getName());
//
////     // @Scheduled(cron = "0 */5 * * * *")            //every 15 minutes between 1 and 3
////     @Scheduled(fixedDelay = 1000 * 60 * 60)          //every 5 minutes after previous
////     public void LoadClaims() {
////         log.log(Level.INFO, "**************************POST CLAIM TO EDI  SERVICE ACTIVATED***********************");
////         ThreadInterface PostEdiThread = new ThreadInterface(providerClaimsInterface, claimInterface, abacusRepository);
////         PostEdiThread.postToEdiClaims();
//// //        log.info("============================POSTING CLAIMS TO EDI=====================================");
//// //        List<Claim> claims = claimInterface.getUnswitchedCalims();
//// //        log.log(Level.INFO, "================ {0}  CLAIMS PROCESSED TO  EDI =======================", claims.size());
////     }
//
//// }
