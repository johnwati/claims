///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package com.smart.integ.service.data;
//
//import static org.springframework.util.StringUtils.isEmpty;
//
//import com.smart.integ.interfaces.ProviderClaimsInterface;
//import com.smart.integ.model.abacus_stg.EdiDiagModel;
//import com.smart.integ.model.abacus_stg.StgAbacusDiagnosisModel;
//import com.smart.integ.model.tnh.CareEncounterDiagnosisModel;
//import com.smart.integ.model.tnh.ExchangeFilesModel;
//import com.smart.integ.repository.AbacusRepository;
//import com.smart.integ.repository.StgRepository;
//import com.smart.integ.repository.TnhRepository;
//import com.smart.integ.repository.TnhSmartRepository;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.jdbc.core.JdbcTemplate;
//import org.springframework.stereotype.Service;
//
///**
// *
// * @author John.Simiyu
// */
//@Service
//public class ProviderDiagnosisService {
//
//    static final Logger log = Logger.getLogger(ProviderDiagnosisService.class.getName());
//
//    @Autowired
//    @Qualifier("tnhSmartJdbcTemplate")
//    private JdbcTemplate tnhSmartJdbcTemplate;
//
//    @Autowired
//    AbacusRepository abacusRepository;
//
//    @Autowired
//    TnhSmartRepository tnhSmartRepository;
//
//    @Autowired
//    TnhRepository tnhRepository;
//
//    @Autowired
//    StgRepository stgRepository;
//
//    public void fetchClaimInvoices() {
//        List<ExchangeFilesModel> efms = new ArrayList();
//        efms = tnhSmartRepository.fetchClaimInvoices();
//        efms.forEach(
//                invoice -> {
//                    //System.out.println(invoice.getInvoice_Number() + " " + invoice.getKraniumEncounter_Nr());
//                    stgRepository
//                            .fetchInvoiceDiagnosis(invoice.getKraniumEncounter_Nr())
//                            .forEach(
//                                    diagnosis -> {
//                                        EdiDiagModel diagModel = new EdiDiagModel();
//                                        diagModel = abacusRepository.getDiagnosis(diagnosis.getCode());
//                                        System.out.println(diagModel.getFULL_NAME());
//                                        //System.out.println(diagnosis.getCode() + " " + diagnosis.getDate());
//                                        StgAbacusDiagnosisModel abacusDiagnosisModel = new StgAbacusDiagnosisModel();
//                                        abacusDiagnosisModel.setRECEIPT_NO(invoice.getInvoice_Number());
//                                        abacusDiagnosisModel.setBILL_DATE(diagnosis.getDate());
//                                        abacusDiagnosisModel.setAPPOINTMENT_DATE(diagnosis.getDate());
//                                        abacusDiagnosisModel.setCODING_DATE(diagnosis.getDate());
//                                        abacusDiagnosisModel.setAPPT_NO(invoice.getAdmit_ID());
//                                        abacusDiagnosisModel.setPIN(invoice.getMember_Nr());
//                                        abacusDiagnosisModel.setICD_CODE(diagnosis.getCode());
//                                        abacusDiagnosisModel.setDESCRIPTION(
//                                                !isEmpty(diagModel.getFULL_NAME())
//                                                ? diagModel.getFULL_NAME()
//                                                : "Primary"
//                                        );
//                                        abacusDiagnosisModel.setDIAG_TYPE("PRIMARY");
//                                        abacusDiagnosisModel.setIS_TRANSMITTED("0");
//                                        abacusDiagnosisModel.setPROVIDER_KEY("SKSP_2");
//                                        abacusDiagnosisModel.setVIEW_SOURCE("SMART_DIAG_OP");
//
//                                        stgRepository.saveDiagnosis(abacusDiagnosisModel);
//                                    }
//                            );
//                }
//        );
//    }
//}
//
//
//

