package com.smart.integ.controller;

import com.finaccess.groboxcooperative.infrastructure.utility.PageDetails;
import com.finaccess.groboxcooperative.infrastructure.utility.Pager;
import com.smart.integ.db.abacus.EdiClaimDto;
import java.util.List;

import javax.validation.Valid;

import org.hibernate.service.spi.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import com.smart.integ.db.abacus.KraEdiClaim;
import com.smart.integ.infrastructure.common.PaginationUtil;
import com.smart.integ.service.EdiInvoicesService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/edi")
public class EdiInvoicesController {
 

    @Autowired
    private EdiInvoicesService kraediclaimService;

    @GetMapping(value = "/invoice")
    public ResponseEntity<?> index(
            @RequestParam(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false) Integer size
    ) {
        List<EdiClaimDto> EdiInvoice = kraediclaimService.findAll(size);
        PageDetails pageDetails = new PageDetails();
        pageDetails.setPerPage(size);
        pageDetails.setReportName("Edi Invoices");
        pageDetails.setPage(1);
        pageDetails.setTotalPage(kraediclaimService.totalRows());
        pageDetails.setTotalElements(kraediclaimService.totalRows().longValue());
        Pager pageable = PaginationUtil.toPager(EdiInvoice,pageDetails); 
        return ResponseEntity.ok(pageable);
    } 
    
     @GetMapping(value = "/invoice/markback")
    public String markback(
            @RequestParam(value = "statusMsg", required = false) Integer statusMsg,
            @RequestParam(value = "status", required = false) Integer status,
            @RequestParam(value = "claimId", required = false) Integer claimId
    ) {
//        List<EdiClaimDto> EdiInvoice = kraediclaimService.findAll(size);
//        PageDetails pageDetails = new PageDetails();
//        pageDetails.setPerPage(size);
//        pageDetails.setReportName("Edi Invoices");
//        pageDetails.setPage(1);
//        pageDetails.setTotalPage(kraediclaimService.totalRows());
//        pageDetails.setTotalElements(kraediclaimService.totalRows().longValue());
//        Pager pageable = PaginationUtil.toPager(EdiInvoice,pageDetails); 
//        return ResponseEntity.ok(pageable);
        
        return "sjsjsjsj";
    } 
}
