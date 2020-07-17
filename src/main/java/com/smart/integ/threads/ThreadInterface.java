/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.threads;

import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.interfaces.ProviderClaimsInterface;
import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.stg_edi_claim.Claim;
import java.sql.Connection;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 *
 * @author John.Simiyu
 */
@Component
public class ThreadInterface {

    private ProviderClaimsInterface providerClaimsInterface;

    private ClaimInterface claimInterface;

  

    public ThreadInterface(ProviderClaimsInterface providerClaimsInterface, ClaimInterface claimInterface) {
        this.providerClaimsInterface = providerClaimsInterface;
        this.claimInterface = claimInterface;
    }
    
    

    private final Logger log = Logger.getLogger(getClass().getName());

    public void getProviderClaims() {
        log.info("==========================FETCHING CLAIMS FROM THE PROVIDER=================================");
        List<ClaimRequest> requests = providerClaimsInterface.fetchProviderClaims();
        log.log(Level.INFO, "=============== {0} CLAIMS FETCHED FROM THE PROVIDER=========", requests.size());

        // size of each partition
        int size = 100;
        // partition a list into partitions of given size
        List<ClaimRequest>[] partition = ListProcessor.partition(requests, size);
        // print the partitions
        for (int i = 0; i < partition.length; i++) {
            try {
                ProvClaimsThread object = new ProvClaimsThread(providerClaimsInterface, (i + 1), partition[i]);
                object.start();
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void postToEdiClaims() {
        log.info("============================POSTING CLAIMS TO EDI=====================================");
        List<Claim> claims = claimInterface.getUnswitchedCalims();
        log.log(Level.INFO, "================ {0} CLAIMS  FETCHED READY TO BE PROCESSED TO  EDI =======================", claims.size());
        // size of each partition
        int size = 10;
        // partition a list into partitions of given size
        List<Claim>[] partition = ListProcessor.partition(claims, size);
        // print the partitions
        for (int i = 0; i < partition.length; i++) {
            try {
                PostEdiThread object = new PostEdiThread(claimInterface, (i + 1), partition[i]);
                object.start();
                TimeUnit.SECONDS.sleep(4);
            } catch (InterruptedException ex) {
                Logger.getLogger(ThreadInterface.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
