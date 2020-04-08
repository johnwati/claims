/**
* Push claims to actisure
* read from database
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
//import com.smart.integ.service.ClaimService;
import com.smart.integ.Application;
import com.smart.integ.interfaces.FetchClaimInterface;

@Component    
@EnableScheduling
//@Profile({"default", "dev", "lab"})
public class ActisureJob{

    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;
    
    @Autowired
    private FetchClaimInterface claimService;


    @Value("${claims.fetch.soap:SELECT 1 FROM DUAL}")
    String dynamicQuery;

    @Value("${claims.fetch.clients:JIC}")
    String dynamicCustArray;

    @Value("${claims.fetch.providers:SKSP_505}")
    String dynamicProviderArray;

    Logger log = Logger.getLogger(ActisureJob.class.getName());

    
    public ActisureJob(){
        }


    @Scheduled(fixedDelay=1000 * 60 * 5)        //every 5 minutes after previous run
    public void fetchClaimSoap() {
        log.info("Getting soap from db");
        
        String claimSoapSql = dynamicQuery             
        + " ORDER BY edi_claim_cache_id ASC "
        + " FETCH NEXT 50 ROWS ONLY";

        log.info("claimSoapSql = " + claimSoapSql);
        claimService.fetchClaimSoap(claimSoapSql);

        }

}
