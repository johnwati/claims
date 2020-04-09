/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.controller;

import com.smart.integ.Application;
import com.smart.integ.daemon.RenewToken;
import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.interfaces.TokenInterface;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author John.Simiyu
 */
@RestController
@RequestMapping(path = "/service")
public class ServiceController {

    @Autowired
    private TokenInterface tokenService;

    @Autowired
    private ClaimInterface claimInterface;
    private String bearerToken = ""; // GLOBAL VARIABLE

    Logger log = Logger.getLogger(RenewToken.class.getName());

    @RequestMapping("/get-token")
    public String getNewToken() {
        log.info("GETTING NEW TOKEN");
        Application.BEARER_TOKEN = tokenService.getToken("RESOECLAIMS", "zDPxTn6V3fql3oh00xIKLbNgkj4");
        log.info("UPDATING TOKEN : " + Application.BEARER_TOKEN);
        return Application.BEARER_TOKEN;
    }
    
    @RequestMapping("/get-claims")
    public String getEDIClaims() {
        claimInterface.fetchClaim();
        return Application.BEARER_TOKEN;
    }
}
