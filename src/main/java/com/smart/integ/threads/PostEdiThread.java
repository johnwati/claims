/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.threads;

import com.smart.integ.interfaces.ClaimInterface;
import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.stg_edi_claim.Claim;
import java.util.List;

/**
 *
 * @author John.Simiyu
 */
public class PostEdiThread extends Thread {
    private ClaimInterface claimInterface;
    private int listIndex;
    private List<Claim> partition;

    public PostEdiThread(ClaimInterface claimInterface, int listIndex, List<Claim> partition) {
        this.claimInterface = claimInterface;
        this.listIndex = listIndex;
        this.partition = partition;
    }

    public void run() {
        try {
            // Displaying the thread that is running 
            System.out.println("Thread " + Thread.currentThread().getId() + " is running" + "Partition " + listIndex + ": " + partition);
            partition.forEach((claim) -> {
                claimInterface.processClaimToEdi(claim);
            });
        } catch (Exception e) {
            // Throwing an exception 
            System.out.println("Exception is caught");
        }

    }
}
