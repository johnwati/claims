/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.interfaces;

import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.EdiSlClaims;
import com.smart.integ.model.stg_edi_claim.Claim;
import java.util.List;

/**
 *
 * @author John.Simiyu
 */
public interface ProviderClaimsInterface {

    List<ClaimRequest> fetchProviderClaims();

    List<Claim> invoice_CLAIM_EXIST(ClaimRequest claimRequest);

    public void processProviderClaim(ClaimRequest request);

    public void provMarkBack(ClaimRequest claimRequest);

    public void  logProviderUnsubmittedInvoices(EdiSlClaims ediSlClaims);

}




