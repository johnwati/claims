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

import java.util.logging.Logger;

//Ref: https://www.callicoder.com/spring-boot-file-upload-download-jpa-hibernate-mysql-database-example/

@Service
public class SLClaimsFetchService implements FetchSLInterface{

    Logger log = Logger.getLogger(SLClaimsFetchService.class.getName());
       
    @Autowired
    @Qualifier("abacusJdbcTemplate")
    private JdbcTemplate abacusJdbcTemplate;

    @Autowired
    @Qualifier("integJdbcTemplate")
    private JdbcTemplate integJdbcTemplate;

    @Async
    public void fetchSLClaims(String _sql){
   
        //String statusSql = "UPDATE reports SET status = ?, status_message = ? WHERE id = ?";
        //String statusSql = "UPDATE stg_slink_claims SET is_edi=?, edi_status_msg=? WHERE central_id=?";

        try {

            SLFetchHandler handler = new SLFetchHandler();
            
            //if(al.getDatasource().equals("ABACUS")){
                abacusJdbcTemplate.query(_sql, handler);                     
            //     }
            // else if(al.getDatasource().equals("INTEG")){
            //     integJdbcTemplate.query(al.getAttachementSql(), handler);                     
            //     }
            // else{
            //     log.warning("UNKNOWN DATASOURCE: valid values INTEG, ABACUS");
            //     Object[] params = {3, "UNKNOWN DATASOURCE: valid values INTEG, ABACUS", al.getId()};
            //     int[] types = {Types.SMALLINT, Types.VARCHAR, Types.BIGINT};            
            //     alertsJdbcTemplate.update(statusSql, params, types);
            //     //continue;
            //     //return;
            //     }              

            // CreateWorksheetCallbackHandler handler = new CreateWorksheetCallbackHandler();
            // abacusJdbcTemplate.query(sql, handler);                

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



    public boolean deleteFile(String attName){
        
        LocalDateTime now = LocalDateTime.now();
        String FILE_NAME = "./generated/" + attName + "-" + now.getDayOfMonth() + "-" + now.getMonth() + "-" + now.getYear() + ".xlsx";       
        Path filePath = Paths.get(FILE_NAME).toAbsolutePath().normalize();

        log.info("DELETING file " + FILE_NAME);

        try{
            boolean deleted = Files.deleteIfExists(filePath);   // Surround it in try catch block
            log.info("FILE deleted ? = " + deleted);
            return deleted;
            }
        catch(IOException e){
            log.severe("OOPS !" + e.getMessage());
            return false;
            }        
        }


}