/**
* Persist EDI Claims
* Get claims from EDI endpoint into an intermediary table
**/
package com.smart.integ.daemon;

import java.lang.Runnable;

import java.math.BigDecimal;

import java.util.Map;
import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Enumeration;
import java.util.Set;
import java.util.Iterator;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.Connection;

import java.net.URLEncoder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import org.springframework.core.env.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.logging.Logger;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.service.ClaimService;
import com.smart.integ.Application;
import com.smart.integ.interfaces.FetchSLInterface;

@Component    
@EnableScheduling
//@Profile({"default", "dev", "lab"})
public class SLClaims{

   

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;


    
    @Autowired
    private ClaimService claimService;


    @Value("${claims.fetch.slink:SELECT 1 FROM DUAL}")
    String dynamicQuery;

    @Value("${claims.fetch.clients:JIC}")
    String dynamicCustArray;

    @Value("${claims.fetch.providers:SKSP_505}")
    String dynamicProviderArray;

    Logger log = Logger.getLogger(SLClaims.class.getName());

    
    public SLClaims(){
        }


    @Scheduled(fixedDelay=1000 * 60 * 5)        //every 5 minutes after previous run
    public void fetchSLClaims() {
        log.info("Getting Smartlink Claims. STUB");
        
        String claimSql = dynamicQuery     
        // + " AND fc.central_id > " + lastCentralId + " " 
        // + " AND cust_id = " + cust + " "
        + " ORDER BY a.central_id ASC "
        + " FETCH FIRST 10 ROWS ONLY ";

        log.info("claimSql = " + claimSql);
        claimService.fetchSLClaims(claimSql);

        }

}
