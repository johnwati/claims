// /*
//  * To change this license header, choose License Headers in Project Properties.
//  * To change this template file, choose Tools | Templates
//  * and open the template in the editor.
//  */
// package com.smart.integ.daemon;

// import com.smart.integ.interfaces.ClaimInterface;
// import com.smart.integ.interfaces.ProviderClaimsInterface;
// import com.smart.integ.model.ClaimRequest;
// import com.smart.integ.repository.AbacusRepository;
// import com.smart.integ.threads.ThreadInterface;
// import java.util.List;
// import java.util.logging.Level;
// import java.util.logging.Logger;
// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.scheduling.annotation.EnableScheduling;
// import org.springframework.scheduling.annotation.Scheduled;
// import org.springframework.stereotype.Component;

// /**
//  *
//  * @author John.Simiyu
//  */
// @Component
// @EnableScheduling
// public class ProviderClaimsDaemon {

//     @Autowired
//     private ProviderClaimsInterface providerClaimsInterface;

//     @Autowired
//     AbacusRepository abacusRepository;

//     @Autowired
//     private ClaimInterface claimInterface;
//     Logger log = Logger.getLogger(RenewToken.class.getName());

//     // @Scheduled(cron = "0 */5 * * * *")            //every 15 minutes between 1 and 3
//     @Scheduled(fixedDelay = 1000 * 60 * 20)          //every 5 minutes after previous
//     public void fetchProviderClaims() {
// //        log.info("==========================FETCHING CLAIMS FROM THE PROVIDER=================================");
// //        List<ClaimRequest> requests = providerClaimsInterface.fetchProviderClaims();
// //        log.log(Level.INFO, "============= {0} CLAIMS PROCESSED FROM THE PROVIDER=========", requests.size());
//         log.log(Level.INFO, "*****************************PROVIDER CLAIMS SERVICE ACTIVATED********************************");
//         ThreadInterface threadInterface = new ThreadInterface(providerClaimsInterface, claimInterface, abacusRepository);
//         threadInterface.getProviderClaims();
//     }

//     // @Scheduled(cron = "0 */5 * * * *")            //every 15 minutes between 1 and 3
//     @Scheduled(fixedDelay = 1000 * 60 * 60)          //every 5 minutes after previous
//     public void fetchProviderUnsubmittedInvoices() {
//          log.log(Level.INFO, "**************************LOG PROVIDER UNSUBMITTED CLAIMS SERVICE ACTIVATED***********************");
//         ThreadInterface PostEdiThread = new ThreadInterface(providerClaimsInterface, claimInterface,abacusRepository);
//         PostEdiThread.logProviderUnsubmittedInvoices();
//     }
// }
