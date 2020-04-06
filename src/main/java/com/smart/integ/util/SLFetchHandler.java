/**
* Allows streaming in the absence of persistent entity [this is used by vanilla sql]
**/
package com.smart.integ.util;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowCallbackHandler;

import java.util.logging.Logger;

//RowCallbackHandler is stateful
public class SLFetchHandler implements RowCallbackHandler {
    
    Logger log = Logger.getLogger(SLFetchHandler.class.getName());

     
    int columnCount = 0;        //need to get the actual column count
    int rowNum = 1;

    @Override
    public void processRow(ResultSet rs) throws SQLException {

        // if(rowNum == 0){
        //     ResultSetMetaData rsmd = rs.getMetaData();
        //     columnCount = rsmd.getColumnCount();
        //     log.info("Number of columns : " + columnCount);

        //     Row sHeader = worksheet.createRow(0);
            
        //     for (int i = 1; i <= columnCount; i++) {  
        //         sHeader.createCell(i).setCellValue(rsmd.getColumnName(i));
        //         }                
        //     rowNum++;
        //     }

        //PUSH TO EDI 
        //SUCCESS BATCH / map/list
        //FAILED BATCH  /map/list

        log.info("processing row " + rowNum);
        rowNum++;

        }
            
   

  }