package com.smart.integ.service;

import com.smart.integ.db.abacus.EdiClaimDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import com.smart.integ.db.abacus.KraEdiClaim;
import com.smart.integ.repository.EdiInvoicesRepository;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
@Transactional(readOnly = true)
public class EdiInvoicesService {

	@Autowired
	private EdiInvoicesRepository kraediclaimRepository;

	public List<EdiClaimDto> findAll(Integer size) {
		return kraediclaimRepository.findAll(size);
	}

        public Integer totalRows() {
		return kraediclaimRepository.TotalRecords();
	}
	 
}
	
