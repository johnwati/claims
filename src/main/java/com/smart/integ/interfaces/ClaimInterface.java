/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.interfaces;

import com.smart.integ.model.stg_edi_claim.Claim;
import java.util.List;

/**
 *
 * @author John.Simiyu
 */
public interface ClaimInterface {

    public Void fetchClaim();
    public String  getClaimsToSwich(Claim ediClaim);
    public List<Claim> getUnswitchedCalims();
    public void PostClaimsToEdi(String claimJsonString,String Claim_code);
    public void postclaimsToEdi2(String claimJsonString);     
    public void processClaimToEdi(Claim claim);
}
