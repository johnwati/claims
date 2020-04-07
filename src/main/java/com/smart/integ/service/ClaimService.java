package com.smart.integ.service;

import java.util.List;
import java.util.Map;
import java.util.HashMap;

import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.scheduling.annotation.Async;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ParameterizedPreparedStatementSetter;
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
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
   
        String successSql = "UPDATE stg_slink_claims SET is_edi=?, edi_status_msg=? WHERE central_id IN (?) ";
        String failedSql = "UPDATE stg_slink_claims SET is_edi=?, edi_status_msg=? WHERE central_id=? ";

        try {

            SLFetchHandler handler = new SLFetchHandler(plainRestTemplate);
            
            abacusJdbcTemplate.query(_sql, handler);                     

            List<Long> lsSuccess = handler.getLsSuccess();
            List<Map<String,String>> lsFailed = handler.getLsFailed(); 

            int countSuccess = lsSuccess.size();
            int countFailed = lsFailed.size();

            log.info("TASK COMPLETED: SUCCEEDED = " + countSuccess + ", FAILED = " + countFailed);

            //A. UPDATE SUCCESSFULL

            int[] types = {Types.SMALLINT, Types.VARCHAR, Types.ARRAY};      
            
            Object[] successParams = {1, "", lsSuccess};
        
            if(lsSuccess.size() > 0){
                abacusJdbcTemplate.update(successSql, successParams, types);    
                }
            

            //B. UPDATE FAILURES            
            abacusJdbcTemplate.batchUpdate(failedSql, new BatchPreparedStatementSetter() {
                @Override              
                public void setValues(PreparedStatement ps, int i) throws SQLException {              
                    Map<String,String> err = lsFailed.get(i);
                    
                    log.info(i + ". Logging failed: central_id = " + err.get("central_id"));

                    ps.setInt(1, 2);              
                    ps.setString(2, "TESTING: " + err.get("status_msg").toString());              
                    ps.setLong(3, Long.parseLong(err.get("central_id").toString()));
                    }
              
                @Override              
                public int getBatchSize() {              
                    return lsFailed.size();            
                    }
              
               });
            



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