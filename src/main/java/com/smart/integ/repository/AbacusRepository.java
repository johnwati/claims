package com.smart.integ.repository;

import com.smart.integ.model.EdiSlClaims;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John.Simiyu
 */
@Repository
public class AbacusRepository {

    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    public List<EdiSlClaims> fetchEdiClaims() {
        String sqlx = "SELECT INSERT_TIME,CLAIM_CODE AS INVOICE_NUMBER,PAYER_NAME,LOCATION_NAME \n"
                + "FROM ABACUS.EDI_CLAIMS  WHERE  PROV_CODE = ? AND TRUNC(INSERT_TIME) >= TRUNC(CURRENT_DATE)-30 ORDER BY INSERT_TIME DESC ";

        String sql = "SELECT INSERT_TIME,CLAIM_CODE AS INVOICE_NUMBER,PAYER_NAME,LOCATION_NAME, SCHEME_NAME  \n"
                + "FROM ABACUS.EDI_CLAIMS  WHERE  PROV_CODE =  ?  AND PAYER_NAME  IN ('UAP INSURANCE COMPANY LTD','JUBILEE INSURANCE COMPANY LIMITED') \n"
                + "AND TRUNC(INSERT_TIME) >= TRUNC(CURRENT_DATE)-30 ORDER BY INSERT_TIME DESC"; 
        List<EdiSlClaims> claimsList = abacusJdbcTemplate.query(sql, new Object[]{"SKSP_301"}, BeanPropertyRowMapper.newInstance(EdiSlClaims.class));
        return claimsList;

    }

}





