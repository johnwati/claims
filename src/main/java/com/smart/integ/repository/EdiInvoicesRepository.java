package com.smart.integ.repository;

import com.smart.integ.db.abacus.EdiClaimDto;
import com.smart.integ.db.abacus.KraEdiClaim;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

@Repository
public class EdiInvoicesRepository {

    /**
     *
     */
    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    Logger log = Logger.getLogger(EdiInvoicesRepository.class.getName());

    public List<EdiClaimDto> findAll(Integer size) {
        log.log(Level.INFO, "---------GETTING  KRA INVOICES---------------\n");
        String sql = "SELECT \n"
                + "'1' AS POLICY_NUMBER  ,\n"
                + "a.PROV_CODE AS PROVIDER_CODE,\n"
                + "d.MEMBER_NUMBER AS MEMBERSHIP_NUMBER ,\n"
                + "(mem.FIRST_NAME ||' '||mem.SECOND_NAME || ' '|| mem.SURNAME ) AS MEMBER_NAME,\n"
                + "mem.CARD_SERIAL_NUMBER  AS CARD_SERIAL,\n"
                + "a.INVOICE_DATE  AS TRANSACTION_DATE,\n"
                + "NVL(d.BENEFIT_DESC,'404') AS SERVICE_DESCRIPTION,\n"
                + "a.POOL_NUMBER  AS BENEFIT_CODE,\n"
                + "a.AMOUNT  AS AMOUNT ,\n"
                + "a.INVOICE_DATE  AS DATE_RECEIVED,\n"
                + "a.CENTRAL_ID  AS PROVIDER_CLAIM_ID,\n"
                + "a.INVOICE_NUMBER  AS SMART_INVOICE_NR,\n"
                + "a.ADMIT_ID  AS ADMIT_ID,\n"
                + "a.CLAIM_ID AS CLAIM_ID ,\n"
                + "a.INSERT_TIME AS INSERT_DATE,\n"
                + "'-' AS STAFF_NUMBER,\n"
                + "UPPER(a.COUNTRY_CODE)  AS COUNTRY_CODE,\n"
                + "a.POLICY_CURRENCY_CODE   AS CURRENCY_CODE,\n"
                + "d.EXCHANGE_RATE  AS CURRENCY_CONV_RATE,\n"
                + "d.IS_ROAMER  AS IS_ROAMING,\n"
                + "a.ROAMING_AMOUNT  AS ROAMING_AMOUNT,\n"
                + "NVL(a.ROAMING_COUNTRY , 'NA')  AS ROAMING_COUNTRY,\n"
                + "NVL(d.DIAG_CODE , '-')  AS DIAGNOSIS_CODE,\n"
                + "NVL(d.DIAG_DESC,'-')  AS DIAGNOSIS_DESCRIPTION,\n"
                + "a.POLICY_CURRENCY_CODE  AS POLICY_CURRENCY_CODE,\n"
                + "IS_OPENTICKET ,\n"
                + "IS_OPENBATCH ,\n"
                + "b.BATCH_NO ,\n"
                + "b.BATCH_AMT ,\n"
                + " CASE   b.BATCH_TYPE \n"
                + " WHEN 'a' THEN 'APPROVED' \n"
                + " WHEN 'd' THEN 'DECLINED'\n"
                + " END AS BATCH_TYPE,\n"
                + "d.VISIT_NUMBER ,\n"
                + "d.CURRENCY ,\n"
                + "d.REJECT_COUNT,\n"
                + "b.CLOSE_TIME AS BATCH_CLOSE_TIME,\n"
                + "BATCH_TIME, \n"
                + "(fu.FNAME ||' '||fu.SNAME ) AS CLOSED_BY,\n"
                + "fu.EMAIL  AS USER_EMAIL,\n"
                + "b.USER_ID \n"
                + "FROM edi_claims_inv  a\n"
                + "JOIN ABACUS.EDI_BATCHES b ON b.ID  = a.BATCH_ID \n"
                + "JOIN fin_providers c ON a.prov_id=c.prov_id \n"
                + "join fin_member_details mem on a.global_id=mem.global_id   \n"
                + "JOIN ABACUS.EDI_CLAIMS d ON d.ID  = a.CLAIM_ID \n"
                + "LEFT OUTER \n"
                + "JOIN ABACUS.FIN_USERS2 fu ON  b.CLOSE_USER_ID = fu.USER_ID \n"
                + "WHERE \n"
                + "a.CUST_ID  = 610 AND \n"
                + "b.BATCH_TYPE='a' AND \n"
                + "STEP  = '3a' AND \n"
                + " b.CLOSE_USER_ID  > 0\n"
                + " FETCH  FIRST ? ROWS  ONLY ";
        List<EdiClaimDto> invoiceList = abacusJdbcTemplate.query(sql, new Object[]{size}, BeanPropertyRowMapper.newInstance(EdiClaimDto.class));
        return invoiceList;
    }

    public Integer TotalRecords() {
        log.log(Level.INFO, "---------GETTING  KRA INVOICES---------------\n");
        String sql = "SELECT count(*) FROM edi_claims_inv  a\n"
                + "JOIN ABACUS.EDI_BATCHES b ON b.ID  = a.BATCH_ID \n"
                + "JOIN fin_providers c ON a.prov_id=c.prov_id \n"
                + "join fin_member_details mem on a.global_id=mem.global_id   \n"
                + "JOIN ABACUS.EDI_CLAIMS d ON d.ID  = a.CLAIM_ID \n"
                + "LEFT OUTER \n"
                + "JOIN ABACUS.FIN_USERS2 fu ON  b.CLOSE_USER_ID = fu.USER_ID \n"
                + "WHERE \n"
                + "a.CUST_ID  = 610 AND \n"
                + "b.BATCH_TYPE='a' AND \n"
                + "STEP  = '3a' AND \n"
                + " b.CLOSE_USER_ID  > 0\n"
                + " "; 

        return abacusJdbcTemplate.queryForObject(sql, Integer.class);

    }
}
