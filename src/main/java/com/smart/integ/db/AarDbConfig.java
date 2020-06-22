/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.db;

import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "aarEntityManagerFactory",
  basePackages = { "com.smart.integ.db.aar" }
)
public class AarDbConfig {
  
//    @Primary
    @Bean(name = "aarDataSource")
    @ConfigurationProperties(prefix = "aar.datasource")
    public DataSource dataSource() {
      return DataSourceBuilder.create().build();
      }
    
//    @Primary
    @Bean(name = "aarJdbcTemplate")
    public JdbcTemplate aarJdbcTemplate(@Qualifier("aarDataSource") DataSource ds) {
      return new JdbcTemplate(ds);
    }

//    @Primary
    @Bean(name = "aarEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean 
    aarEntityManagerFactory(
      EntityManagerFactoryBuilder builder,
      @Qualifier("aarDataSource") DataSource dataSource
    ) {
      return builder
        .dataSource(dataSource)
        .packages("com.smart.integ.db.aar")
        .persistenceUnit("aar")
        .build();
      }
      

}