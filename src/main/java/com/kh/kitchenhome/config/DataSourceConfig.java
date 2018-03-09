package com.kh.kitchenhome.config;

import javax.sql.DataSource;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class DataSourceConfig {
    @Bean
    @Primary
    //@ConfigurationProperties(prefix="first.datasource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        DataSource ds =  DataSourceBuilder.create().build();
        return ds;
    }

//    @Bean
//    @ConfigurationProperties(prefix="second.datasource")
//    public DataSource secondDataSource() {
//        DataSource ds =  DataSourceBuilder.create().build();
//        return ds;
//    }
}