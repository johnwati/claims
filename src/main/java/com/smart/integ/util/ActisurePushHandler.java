/**
* Allows streaming in the absence of persistent entity [this is used by vanilla sql]
**/
package com.smart.integ.util;

import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.core.env.Environment;
import org.springframework.web.client.RestTemplate;


import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

import com.smart.integ.model.Response;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.client.RestTemplate;

import com.smart.integ.Application;

import java.util.logging.Logger;

//RowCallbackHandler is stateful
public class ActisurePushHandler implements RowCallbackHandler {
    
    Logger log = Logger.getLogger(ActisurePushHandler.class.getName());
     
    int columnCount = 0;        //need to get the actual column count
    int rowNum = 1;

    private List<Map<String,String>> lsSuccess = new ArrayList<Map<String,String>>();
    private List<Map<String,String>> lsFailed = new ArrayList<Map<String,String>>();

    Map<String,String> err;
    Map<String,String> pass;

    RestTemplate restTemplate;

    public ActisurePushHandler(RestTemplate _restTemplate){
        this.restTemplate = _restTemplate;
        pass = new HashMap<String,String>();
        err = new HashMap<String,String>();
    }

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        log.info("processing row " + rowNum);
        rowNum++;

        String url = "http://192.180.3.14:3115/Actisure/ClaimsLoadService";      

        log.info("Preparing request to ... " + url);
        
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        //headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/xml+soap");
       
        HttpEntity<String> entity = new HttpEntity<String>(rs.getString("claim_soap"), headers);

        //NB: Endpoint will return 404 if you use GET instead of POST
        ResponseEntity<String> respEntity = restTemplate.exchange(url, HttpMethod.POST, entity, String.class);  
        String resp = respEntity.getBody();

        log.info("ACTISURE RESPONSE \n" + resp);

        // log.info("Response successful=" + resp.isSuccessful() + ", status_msg=" + resp.getStatus_msg());


        // if(resp.isSuccessful() == true){
        //     pass = new HashMap<String,String>();
        //     pass.put("central_id", rs.getString("central_id"));
        //     pass.put("status_msg",resp.getStatus_msg());

        //     lsSuccess.add(pass);

        //     //lsSuccess.add(rs.getLong("central_id"));
        //     }
        // else{
        //     err = new HashMap<String,String>();
        //     err.put("central_id", rs.getString("central_id"));
        //     err.put("status_msg",resp.getStatus_msg());

        //     lsFailed.add(err);
        //     }
    

        }
            
   
   

    
    /**
     * @return List<Map<Long,String>> return the lsFailed
     */
    public List<Map<String,String>> getLsFailed() {
        return lsFailed;
    }

    /**
     * @param lsFailed the lsFailed to set
     */
    public void setLsFailed(List<Map<String,String>> lsFailed) {
        this.lsFailed = lsFailed;
    }


    /**
     * @return List<Map<String,String>> return the lsSuccess
     */
    public List<Map<String,String>> getLsSuccess() {
        return lsSuccess;
    }

    /**
     * @param lsSuccess the lsSuccess to set
     */
    public void setLsSuccess(List<Map<String,String>> lsSuccess) {
        this.lsSuccess = lsSuccess;
    }

}