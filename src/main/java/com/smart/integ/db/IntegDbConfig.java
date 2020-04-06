package com.smart.integ.db;
 
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PropertiesLoaderUtils;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(
  entityManagerFactoryRef = "integEntityManagerFactory",
  basePackages = { "com.smart.integ.db.integ" }
)
public class IntegDbConfig {
  
    @Primary
    @Bean(name = "integDataSource")
    @ConfigurationProperties(prefix = "integ.datasource")
    public DataSource dataSource() {
      return DataSourceBuilder.create().build();
      }
    
    @Primary
    @Bean(name = "integJdbcTemplate")
    public JdbcTemplate integJdbcTemplate(@Qualifier("integDataSource") DataSource ds) {
      return new JdbcTemplate(ds);
    }

    @Primary
    @Bean(name = "integEntityManagerFactory")
    public LocalContainerEntityManagerFactoryBean 
    integEntityManagerFactory(
      EntityManagerFactoryBuilder builder,
      @Qualifier("integDataSource") DataSource dataSource
    ) {
      return builder
        .dataSource(dataSource)
        .packages("com.smart.integ.db.integ")
        .persistenceUnit("integ")
        .build();
      }
      

}