/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.threads;
import com.smart.integ.interfaces.ProviderClaimsInterface;
import com.smart.integ.model.ClaimRequest;
import java.util.List;

/**
 *
 * @author John.Simiyu
 */
public class ProvClaimsThread extends Thread {
    
    ProviderClaimsInterface providerClaimsInterface;
    private int listIndex;
    private List<ClaimRequest> partition;
    
    public ProvClaimsThread(ProviderClaimsInterface providerClaimsInterface, int listIndex, List<ClaimRequest> partition) {
        this.providerClaimsInterface = providerClaimsInterface;
        this.listIndex = listIndex;
        this.partition = partition;
    }
    
    public void run() {        
        System.out.println("Thread " + Thread.currentThread().getId() + " is running" + "Partition " + listIndex + ": " + partition);
        partition.forEach((claim) -> {
            providerClaimsInterface.processProviderClaim(claim);            
        });
    }
    
}
