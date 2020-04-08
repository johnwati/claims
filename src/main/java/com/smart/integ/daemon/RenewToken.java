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
import org.springframework.context.annotation.Profile;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.dao.EmptyResultDataAccessException;

import java.util.logging.Logger;
import com.smart.integ.interfaces.TokenInterface;
import com.smart.integ.Application;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component    
@EnableScheduling
//@Profile({"onpremise"})       //smart, ril, jic, apa
//@Profile({"default", "dev", "lab"})
public class RenewToken{

   

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    private TokenInterface tokenService;   
    private String bearerToken = ""; // GLOBAL VARIABLE

    Logger log = Logger.getLogger(RenewToken.class.getName());

    
    public RenewToken(){
        }

    //https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-redis-example-2/
    //@Scheduled(fixedDelay=1000 * 60 * 60)        //every 60 minutes after previous
    public void getNewToken() {
        log.info("GETTING NEW TOKEN");
        Application.BEARER_TOKEN = tokenService.getToken("RESOECLAIMS", "zDPxTn6V3fql3oh00xIKLbNgkj4");
        log.info("UPDATING TOKEN : " + Application.BEARER_TOKEN);
        }

}
