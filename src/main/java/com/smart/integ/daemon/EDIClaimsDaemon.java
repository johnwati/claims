/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.daemon;

import com.smart.integ.interfaces.ClaimInterface;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 *
 * @author John.Simiyu
 */
@Component
@EnableScheduling
public class EDIClaimsDaemon {

     @Autowired
    private ClaimInterface claimInterface;
     
    Logger log = Logger.getLogger(RenewToken.class.getName());

    // @Scheduled(cron = "0 */5 * * * *")            //every 15 minutes between 1 and 3
    @Scheduled(fixedDelay = 1000 * 60 * 5)          //every 5 minutes after previous
    public void LoadClaims() {
        log.info("FETCHING CLAIMS FROM EDI");
        claimInterface.fetchClaim();
    }

}
