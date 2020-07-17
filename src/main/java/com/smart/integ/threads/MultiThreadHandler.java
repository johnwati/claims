///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.smart.integ.threads;
//
//import com.smart.edi.akuh.jdbc.EDIConnection;
//import com.smart.edi.akuh.model.EDIClaim;
//import com.smart.edi.akuh.service.EDIClientService;
//import io.micrometer.core.instrument.util.TimeUtils;
//import java.sql.Connection;
//import java.util.List;
//import java.util.concurrent.TimeUnit;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//
///**
// *
// * @author John.Simiyu
// */
//public class MultiThreadHandler extends Thread {
//
//    private EDIClientService ediClient;
//
//    private int listIndex;
//    private List<EDIClaim> partition;
//
////    public MultiThreadHandler(int listIndex, List<EDIClaim> partition) {
////        this.listIndex = listIndex;
////        this.partition = partition;
////    }
//    public MultiThreadHandler(EDIClientService ediClient, int listIndex, List<EDIClaim> partition) {
//        this.ediClient = ediClient;
//        this.listIndex = listIndex;
//        this.partition = partition;
//    }
//
//    public void run() {
//        try {
//            Connection smartConnection = EDIConnection.getConnection();
//            // Displaying the thread that is running 
//            System.out.println("Thread " + Thread.currentThread().getId() + " is running" + "Partition " + listIndex + ": " + partition);
//
//            partition.forEach((claim) -> {
//                ediClient.sendClaimToEDI(claim.getJson().trim(), claim.getInvoiceNo(), smartConnection);
//
//            });
//        } catch (Exception e) {
//            // Throwing an exception 
//            System.out.println("Exception is caught");
//        }
//    }
//
//}
