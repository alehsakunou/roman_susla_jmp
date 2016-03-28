package com.killpekeinside.config.spring.persistence;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.init.DataSourceInitializer;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;

import javax.sql.DataSource;

import static com.killpekeinside.config.properties.ConfigConstants.DbConfigPaths;

/**
 * Created by Raman_Susla1 on 6/8/2015.
 */
@Configuration
public class DataInitializerConfiguration {
    @Value(DbConfigPaths.SCHEMA_SQL)
    protected Resource schemaScript;

    @Value(DbConfigPaths.DATA_SQL)
    protected Resource dataScript;

    @Bean
    public DataSourceInitializer dataSourceInitializer(final DataSource dataSource) {
        final DataSourceInitializer initializer = new DataSourceInitializer();
        initializer.setDataSource(dataSource);
        initializer.setDatabasePopulator(databasePopulator());
        return initializer;
    }

    protected DatabasePopulator databasePopulator() {
        final ResourceDatabasePopulator populator = new ResourceDatabasePopulator();
        populator.setContinueOnError(true);
        populator.addScript(schemaScript);
        populator.addScript(dataScript);
        populator.addScript(new ClassPathResource("JdbcUsersConnectionRepository.sql",JdbcUsersConnectionRepository.class));
        return populator;
    }
}
