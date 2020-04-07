/**
* Allows streaming in the absence of persistent entity [this is used by vanilla sql]
**/
package com.smart.integ.util;

import java.util.List;
import java.util.ArrayList;


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
public class SLFetchHandler implements RowCallbackHandler {
    
    Logger log = Logger.getLogger(SLFetchHandler.class.getName());
     
    int columnCount = 0;        //need to get the actual column count
    int rowNum = 1;

    private List<String> lsSuccess = new ArrayList<String>(); 
    private List<String> lsFailed = new ArrayList<String>();

    RestTemplate restTemplate;

    public SLFetchHandler(RestTemplate _restTemplate){
        this.restTemplate = _restTemplate;
    }

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        log.info("processing row " + rowNum);
        rowNum++;

        String url = "https://data.smartapplicationsgroup.com/api/abacus_dev/edi/claim?integ_app_code=JUBILEEECLAIMS&prov_code=" + rs.getString("ip_address") + "&centralId=" + rs.getString("central_id");      

        //String url = "https://data.smartapplicationsgroup.com/api/abacus_dev/edi/claim?prov_code=" + rs.getString("ip_address") + "&centralId=" + rs.getString("central_id");                  
        log.info("Preparing request to ... " + url);
        
        //Set the headers you need send
        HttpHeaders headers = new HttpHeaders();
        headers.set("Accept", "application/json");
        headers.set("Content-Type", "application/json");
        headers.set("Authorization", "Bearer " + Application.BEARER_TOKEN);     //INTEGEDI @ production/qa

        //BODY ??

        //HttpEntity<String> entity = new HttpEntity<String>(headers);
        HttpEntity<String> entity = new HttpEntity<String>(rs.getString("edi_data"), headers);

        //NB: Endpoint will return 404 if you use GET instead of POST
        ResponseEntity<Response> respEntity = restTemplate.exchange(url, HttpMethod.POST, entity, Response.class);  
        Response resp = respEntity.getBody();

        log.info("Response successful=" + resp.isSuccessful() + ", status_msg=" + resp.getStatus_msg());

        //return resp.getBody().getAccess_token();

        if(resp.isSuccessful() == true){
            lsSuccess.add(rs.getString("central_id"));
            }
        else{
            lsFailed.add(rs.getString("central_id"));
            }
    

        }
            
   
    /**
     * @return List<String> return the lsSuccess
     */
    public List<String> getLsSuccess() {
        return lsSuccess;
    }

    /**
     * @param lsSuccess the lsSuccess to set
     */
    public void setLsSuccess(List<String> lsSuccess) {
        this.lsSuccess = lsSuccess;
    }

    /**
     * @return List<String> return the lsFailed
     */
    public List<String> getLsFailed() {
        return lsFailed;
    }

    /**
     * @param lsFailed the lsFailed to set
     */
    public void setLsFailed(List<String> lsFailed) {
        this.lsFailed = lsFailed;
    }

}