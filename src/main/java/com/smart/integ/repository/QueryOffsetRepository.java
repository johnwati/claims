/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.repository;

import com.smart.integ.service.EDIService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John.Simiyu
 */
@Repository
public class QueryOffsetRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;
    Logger log = Logger.getLogger(EDIService.class.getName());

    public int getOffSet(String _key) {
        //log.info("at getOffSet");          

        String offsetTo = "";

        String getOffsetSql = "SELECT value FROM INTEG_API.query_offset WHERE offset_key = '" + _key + "' ORDER BY query_offset_id ASC FETCH NEXT 1 ROWS ONLY";
        try {
            offsetTo = jdbcTemplate.queryForObject(getOffsetSql, String.class);
            return Integer.parseInt(offsetTo);
        } catch (EmptyResultDataAccessException erde) {
            log.severe("EXCEPTION NO DATA : " + erde.getMessage());
            return 0;
        }

    }

    public boolean setOffSet(String _key, String _val) {
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
