package com.smart.integ.repository;

import com.smart.integ.model.ClaimRequest;
import com.smart.integ.model.UnsubmitedInvoicesModel;
import com.smart.integ.util.CustomerRowMapper;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John.Simiyu
 */
@Repository
public class ProviderRepository {

    @Autowired
    @Qualifier("aarJdbcTemplate")
    private JdbcTemplate aarJdbcTemplate;

    Logger log = Logger.getLogger(ProviderRepository.class.getName());

    public Integer fetchProviderClaims(String invoiceNumber) {
        String sql = "SELECT * FROM smart_eclaims.dbo.smart_eclaims_submitted where claim_code  = ? ";
        List<ClaimRequest> requests = aarJdbcTemplate.query(sql, new Object[]{invoiceNumber}, new CustomerRowMapper());
        return requests.size();
    }

    public void logUnsubmittedInvoices(UnsubmitedInvoicesModel unsubmitedInvoice) {
        log.log(Level.INFO, "==================LOGGING UNSUMIITED INVOICE: {0}=========================", unsubmitedInvoice.toString());

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        Date date = new Date();
        System.out.println(formatter.format(date));
        String time = formatter.format(date);

        String CheckClaim = "SELECT count(*) from smart_eclaims.dbo.smart_eclaims_unsubmitted  where invoice_number  = ? ";

        int count = aarJdbcTemplate.queryForObject(CheckClaim, new Object[]{unsubmitedInvoice.getInvoice_number()}, Integer.class);
//        if (aarJdbcTemplate.queryForObject(CheckClaim, new Object[]{unsubmitedInvoice.getInvoice_number()}, Integer.class)
 

//        if (count >= 0) {
            String sqlInsert = "INSERT INTO smart_eclaims.dbo.smart_eclaims_unsubmitted ("
                    + "claim_datetime,"
                    + "invoice_number"
                    + ",payer_name"
                    + ",clinic_name"
                    + ",no_of_delayed_days"
                    + ",scheme_name)"
                    + "values(?,?,?,?,?,?)";
            aarJdbcTemplate.update(sqlInsert,
                    //                time,
                    unsubmitedInvoice.getClaim_datetime(),
                    unsubmitedInvoice.getInvoice_number(),
                    unsubmitedInvoice.getPayer_name(),
                    unsubmitedInvoice.getClinic_name(),
                    unsubmitedInvoice.getNo_of_delayed_days(),
                    unsubmitedInvoice.getScheme_name()
            );
//        }
    }

}






