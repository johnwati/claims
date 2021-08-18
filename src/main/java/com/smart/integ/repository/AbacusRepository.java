package com.smart.integ.repository;
 
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author John.Simiyu
 */
@Repository
public class AbacusRepository {
  @Autowired
  @Qualifier("abacusJdbcTemplate")
  private JdbcTemplate abacusJdbcTemplate;

   
}
