package com.smart.integ.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;


import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;

import org.springframework.core.io.UrlResource;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.web.multipart.MultipartFile;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileOutputStream;

import java.time.LocalDate;
import java.time.LocalDateTime;

import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.sql.ClientInfoStatus;
import java.sql.Types;

import org.json.simple.DeserializationException;
import org.json.simple.JsonArray;
import org.json.simple.JsonObject;
import org.json.simple.Jsoner;

import com.smart.integ.util.SLFetchHandler;
import com.smart.integ.interfaces.FetchSLInterface;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Logger;

//Ref: https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/

@Service
public class ClaimService implements FetchSLInterface{

    Logger log = Logger.getLogger(ClaimService.class.getName());
       
    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;

    @Autowired
    @Qualifier("plainRestTemplate")         //does not use ribbon
    private RestTemplate plainRestTemplate;

    @Async
    public void fetchSLClaims(String _sql){
   
        try {

            SLFetchHandler handler = new SLFetchHandler(plainRestTemplate);
            
            abacusJdbcTemplate.query(_sql, handler);                     

            int success = handler.getLsSuccess().size();
            int fail = handler.getLsFailed().size();

            log.info("TASK COMPLETED: SUCCEEDED = " + success + ", FAILED = " + fail);
            } 
        catch (DataAccessException dae){
            log.warning("Data Access Exception : " + dae.getMessage());
            //Object[] params = {2, dae.getMessage(), al.getId()};
            //int[] types = {Types.SMALLINT, Types.VARCHAR, Types.BIGINT};            
            //alertsJdbcTemplate.update(statusSql, params, types);
            
            }            
        // catch (FileNotFoundException fne) {

        //     log.warning("File Not Found Exception : " + fne.getMessage());
        //     //Object[] params = {3, fne.getMessage(), al.getId()};
        //     //int[] types = {Types.SMALLINT, Types.VARCHAR, Types.BIGINT};            
        //     //alertsJdbcTemplate.update(statusSql, params, types);
        
        //     } 
        // catch (IOException ioe) {
        //     log.warning("IOException : " + ioe.getMessage());
        //     //Object[] params = {3, ioe.getMessage(), al.getId()};
        //     //int[] types = {Types.SMALLINT, Types.VARCHAR, Types.BIGINT};            
        //     //alertsJdbcTemplate.update(statusSql, params, types);            
            
        //     }
        
        //log.info("Done Creating BIG Workbook");
        //return success;
        }





    
    

}