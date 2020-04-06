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
import com.smart.integ.interfaces.EDIInterface;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.JdbcTemplate;

@Component    
@EnableScheduling
//@Profile({"onpremise"})       //smart, ril, jic, apa
//@Profile({"default", "dev", "lab"})
public class PersistEDIClaimsJob{

    Map <String, String> payload;
    List<DataSource> dsList;
    HashMap <String, String> hitSource;
    HashMap<String, HashMap<String, String>> alerts = new HashMap<String, HashMap<String, String>>();
    
    Logger log = Logger.getLogger(PersistEDIClaimsJob.class.getName());

    //http://appsdeveloperblog.com/reading-application-properties-spring-boot/
    @Autowired
    private Environment env;

    @Autowired
    private EDIInterface ediService;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    DataSource ds = null;

    String[] clients = {"ril"};             //codes
    String[] clientIds = {"61000954"};      //abacus cust_id
    String[] customerIds = {"156578462"};    //integ consolidated customerid
    
                             
    // {"SKSP_503"} = gertrudes
    // {"SKSP_148"} = melchizedek
    // {"SKSP_174"} = Baus
    // {"SKSP_358"} = Molars
    // {"SKSP_505"} = AKUH
    // OASIS = SKSP_2918
    // DR IAN   = SKSP_1333
    // PREMIER  = SKSP_2303
    // DIANI BEACH = SKSP_200
    // TABASAMU DENTAL = SKSP_760
    // ROYAL DENTAL KISUMU = SKSP_1844
    // OPTICA LIMITED = SKSP_204
    String[][] smartProviderCodes = {
        {"SKSP_2303","SKSP_174","SKSP_358", "SKSP_503"}
        };



    public PersistEDIClaimsJob(){
        }



    //https://examples.javacodegeeks.com/enterprise-java/spring/spring-data-redis-example-2/
    //@Scheduled(cron = "0 */5 * * * *")            //every 15 minutes between 1 and 3
    //@Scheduled(fixedDelay=1000 * 60 * 5)          //every 5 minutes after previous
    public void loadEdiClaims() {
    
        log.info("PERSISTING EDI claims");

        for (int i=0; i < clients.length; i++) {

            log.info("\tCLIENT: " + clients[i]);

            //2.Fetch EDI Claims:
            for(int j=0; j < smartProviderCodes[i].length; j++){

                    log.info("\t\tPROVIDER: " + smartProviderCodes[i][j]);
                
                    //1. Check the query offset (actualy iteration count) from cache. if none use zero
                    String cOffset = "integ:edi:claims:" + clients[i] + ":"  + smartProviderCodes[i][j] + ":offsets:fetch_id_to";
                    String claimsKey = "integ:edi:claims:outgoing:" + clients[i] + ":"  + smartProviderCodes[i][j] + ":json";
                    
                    int offset = getOffSet(cOffset);//global offset
                    JsonObject ediClaimsObject = ediService.fetchEDIClaimsObjectJson(Integer.parseInt(clientIds[i]),smartProviderCodes[i][j],offset);
                    JsonArray ediClaimsList = (JsonArray)ediClaimsObject.get("claims");

                    //3. Cache'em one by one
                    String prov = smartProviderCodes[i][j];
                    log.info("Provider = " + prov);

                    if(ediClaimsList == null){
                        log.warning("NO CLAIMS found... checking next provider");
                        continue;
                        }
                    
                    for(int k=0; k < ediClaimsList.size(); k++){
                        JsonObject clm = (JsonObject)ediClaimsList.get(k);
                        
                        log.info("FOUND Claim. code = " + clm.get("claim_code"));  
                                                
                        String cacheEdiSql = "INSERT INTO INTEG_API.edi_claim_cache(claims_key, claim_code, customer_id, smart_prov_code, request_url, claim_json) VALUES(?,?,?,?,?,?)"; 
                        jdbcTemplate.update(cacheEdiSql, claimsKey, clm.get("claim_code").toString(),customerIds[i], prov, "", clm.toJson());    //toJSONString                    
                        }  
                    
                    //4. Update offset....
                    String fetch_id_to = ediClaimsObject.get("fetch_id_to").toString();
                    if(fetch_id_to != null && !fetch_id_to.equals("0")){
                        setOffSet(cOffset, fetch_id_to);
                        }
                    else{
                        log.info("No new offset. Leaving the current one intact !!!");
                        }
                    
                    }//end for each provider

            }//END FOR EACH CLIENT

        }




    public int getOffSet(String _key){
        //log.info("at getOffSet");          

        String offsetTo = "";

        String getOffsetSql = "SELECT value FROM INTEG_API.query_offset WHERE offset_key = '" + _key +"' ORDER BY query_offset_id ASC FETCH NEXT 1 ROWS ONLY";
        try {
            offsetTo = jdbcTemplate.queryForObject(getOffsetSql, String.class);
            return Integer.parseInt(offsetTo);
            }
        catch(EmptyResultDataAccessException erde){
            log.severe("EXCEPTION NO DATA : " + erde.getMessage() );
            return 0;
            }       

        }
        

    public boolean setOffSet(String _key, String _val){
        log.info("at setOffSet key = " + _key + ", value = " + _val);    

        String mergeSql = "MERGE INTO integ_api.query_offset d "                    
                    + "USING (SELECT '" + _key + "' as offset_key, '" + _val + "' as value FROM dual) s "
                    + "ON (s.offset_key = d.offset_key) "
                    + "WHEN MATCHED THEN "
                    + "    UPDATE SET d.value = ? "
                    + "WHEN NOT MATCHED THEN  "
                    + "    INSERT (offset_key,value) "
                    + "    VALUES (s.offset_key,s.value) ";
        jdbcTemplate.update(mergeSql, _val);

        return true;    
        }



}
