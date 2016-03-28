package com.killpekeinside.spring.jconf.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;

/**
 * Created by Raman_Susla1 on 6/9/2015.
 */
@Configuration
public abstract class AbsstractDataSourceConfiguration {
    public abstract String getUrl();
    public abstract String getUser();
    public abstract String getDriverClassName();
    public abstract String getPassword();

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName(getDriverClassName());
        dataSource.setUrl(getUrl());
        dataSource.setUsername(getUser());
        dataSource.setPassword(getPassword());
        return dataSource;
    }
}
