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
//import java.sql.Connection;
//import java.util.List;
//import org.json.JSONObject;
//import sun.jvm.hotspot.runtime.Threads;
//
///**
// *
// * @author John.Simiyu
// */
//public class DiagThreadHandler extends Thread {
//
//    private EDIClientService ediClient;
//    private int listIndex;
//    private List<JSONObject> partition;
//
//    public DiagThreadHandler(EDIClientService ediClient, int listIndex, List<JSONObject> partition) {
//        this.ediClient = ediClient;
//        this.listIndex = listIndex;
//        this.partition = partition;
//    }
//
//    public void run() {
//        Connection smartConnection = EDIConnection.getConnection();
//        // Displaying the thread that is running 
//        System.out.println("Thread " + Thread.currentThread().getId() + " is running" + "Partition " + listIndex + ": " + partition);
//        if (partition != null) {
//            partition.forEach((json) -> {
//                ediClient.sendDiagnosisToEdi(json, smartConnection);
//            });
//        }
//    }
//
//}
