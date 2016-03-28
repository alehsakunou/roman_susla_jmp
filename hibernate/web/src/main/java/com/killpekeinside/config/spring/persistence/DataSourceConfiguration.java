package com.killpekeinside.config.spring.persistence;

import com.killpekeinside.spring.jconf.persistence.AbsstractDataSourceConfiguration;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import static com.killpekeinside.config.properties.ConfigConstants.DbConfigPaths;
import static com.killpekeinside.config.properties.ConfigConstants.DbConfigValues;

/**
 * Created by Raman_Susla on 28.03.2015 0:01.
 */
@Configuration
@PropertySource({DbConfigPaths.POSTGRES})
public class DataSourceConfiguration extends AbsstractDataSourceConfiguration {
    @Value(DbConfigValues.DRIVER)
    @Getter
    private String driverClassName;

    @Value(DbConfigValues.URL)
    @Getter
    private String url;

    @Value(DbConfigValues.USER)
    @Getter
    private String user;

    @Value(DbConfigValues.PASSWORD)
    @Getter
    private String password;
}
