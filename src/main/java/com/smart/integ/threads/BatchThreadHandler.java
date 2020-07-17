///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.smart.integ.threads;
//
//import com.smart.edi.akuh.data.ScheduledRepository;
//import com.smart.edi.akuh.jdbc.EDIConnection;
//import com.smart.edi.akuh.model.SmartBatches;
//import com.smart.edi.akuh.service.EDIClientService;
//import java.sql.Connection;
//import java.util.List;
//import org.json.JSONObject;
//
///**
// *
// * @author John.Simiyu
// */
//public class BatchThreadHandler extends Thread {
//
////    private EDIClientService ediClient;
//    private int listIndex;
//    private List<SmartBatches> partition;
//    private ScheduledRepository repository;
//
//    public BatchThreadHandler(int listIndex, List<SmartBatches> partition, ScheduledRepository repository) {
//        this.listIndex = listIndex;
//        this.partition = partition;
//        this.repository = repository;
//    }
//
//    public void run() {
//        Connection smartConnection = EDIConnection.getConnection();
////        List<SmartBatches> list = repository.GetProviderBatches();
//        if (partition != null) {
//            partition.forEach((batch) -> {
//                if (repository.isBatchExisting(batch, smartConnection)) {
//                    System.err.println("BATCH exists in Abacus");
//                } else {
//                    System.err.println("=========== SAVING BATCH TO DB ===================");
//                    repository.SaveBatch(batch, "SMART_BATCHES");
//                }
//            });
//        }
//    }
//
//}
