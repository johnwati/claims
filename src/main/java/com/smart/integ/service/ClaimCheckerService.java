//package com.smart.integ.service;
//
//import com.smart.integ.interfaces.ClaimCheckerInterface;
//import com.smart.integ.model.EdiSlClaims;
//import com.smart.integ.repository.AbacusRepository;
//import com.smart.integ.repository.ProviderRepository;
//import java.util.List;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.jdbc.core.BeanPropertyRowMapper;
//import org.springframework.stereotype.Service;
//
//import com.smart.integ.model.*;
//import com.smart.integ.util.DateHandler;
//import java.time.LocalDateTime;
//import java.time.format.DateTimeFormatter;
//
///**
// *
// * @author John.Simiyu
// */
//@Service
//public class ClaimCheckerService implements ClaimCheckerInterface {
//
//    @Autowired
//    AbacusRepository abacusRepository;
//
//    @Autowired
//    ProviderRepository providerRepository;
//
//    Logger log = Logger.getLogger(ClaimCheckerService.class.getName());
//
//    public void ProviderInvoiceChecker() {
//        log.log(Level.INFO, "================= FETCHING SMART LINK CLAIMS  TO CHECK IN PROVIDER ====================");
//        abacusRepository.fechClaims().forEach((invoiceNumber -> {
//            log.log(Level.INFO, "================= CHECKING INVOICE : {0} ====================", invoiceNumber.getINVOICE_NUMBER().toString());
//            System.out.println(invoiceNumber.getINVOICE_NUMBER().toString());
//            Integer ClaimCount = providerRepository.fetchProviderClaims(invoiceNumber.getINVOICE_NUMBER().toString());
//            System.out.println(ClaimCount);
//            if (ClaimCount <= 0) {
//
//                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//                LocalDateTime now = LocalDateTime.now();
//                System.out.println(dtf.format(now));
//                String start_date = "2021-01-12 14:43:04";
//                String firstFourChars = "";
//                if (start_date.length() > 20) {
//                    start_date = start_date.substring(0, 10);
//                } else {
//                    start_date = start_date;
//                }
//
//                System.out.println(start_date);
//                String end_date = dtf.format(now);
//                // Function Call 
////                System.out.println(findDifference(start_date, end_date));
//                DateHandler datehandler = new DateHandler();
//                long no_of_delayed_days = datehandler.findDifference(invoiceNumber.getINSERT_TIME(), dtf.format(now));
//
//                UnsubmitedInvoicesModel unsubmitedInvoice = new UnsubmitedInvoicesModel();
//                unsubmitedInvoice.setClaim_datetime(start_date.toString());
//                unsubmitedInvoice.setInvoice_number(invoiceNumber.getINVOICE_NUMBER().toString());
//                unsubmitedInvoice.setPayer_name(invoiceNumber.getPAYER_NAME().toString());
//                unsubmitedInvoice.setClinic_name(invoiceNumber.getLOCATION_NAME().toString());
////                DateHandler datehandler = new DateHandler();
////                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
////                LocalDateTime now = LocalDateTime.now();
////                System.out.println(dtf.format(now));
////                long no_of_delayed_days = datehandler.findDifference(invoiceNumber.getINSERT_TIME(), dtf.format(now));
//                unsubmitedInvoice.setNo_of_delayed_days(no_of_delayed_days);
//                providerRepository.logUnsubmittedInvoices(unsubmitedInvoice);
//
////   claim_datetime;invoice_number;payer_name;clinic_name;no_of_delayed_days;edi_delivery_status;edi_delivery_datetime
//            }
//
//        }));
//
//    }
//
//
//}
//
//
//

