package com.example.ald;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.sql.DataSource;

@Configuration
public class DBConfig {

    @Bean(name = "ald")
    @ConfigurationProperties(prefix = "spring.datasource.ald")
    public DataSource dataSource1() {
        return DataSourceBuilder.create().build();
    }

    @Bean(name = "aldJdbcTemplate")
    public JdbcTemplate aldJdbcTemplate(@Qualifier("ald") DataSource ds) {
        return new JdbcTemplate(ds);
    }

    @Bean(name = "dl")
    @ConfigurationProperties(prefix = "spring.datasource.dl")
    public DataSource dataSource2() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "dlJdbcTemplate")
    public JdbcTemplate dlJdbcTemplate(@Qualifier("dl") DataSource ds) {
        return new JdbcTemplate(ds);
    }


    @Bean(name = "cpr")
    @ConfigurationProperties(prefix = "spring.datasource.cpr")
    public DataSource dataSource3() {
        return  DataSourceBuilder.create().build();
    }

    @Bean(name = "cprJdbcTemplate")
    public JdbcTemplate cprJdbcTemplate(@Qualifier("cpr") DataSource ds) {
        return new JdbcTemplate(ds);
    }
}
