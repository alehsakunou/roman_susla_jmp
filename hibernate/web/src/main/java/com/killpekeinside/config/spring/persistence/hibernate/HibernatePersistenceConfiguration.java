package com.killpekeinside.config.spring.persistence.hibernate;

import com.killpekeinside.config.properties.ConfigConstants;
import com.killpekeinside.spring.jconf.persistence.AbstractPersistenceConfiguration;
import com.killpekeinside.config.spring.persistence.DataSourceConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Raman_Susla on 28.03.2015 0:13.
 */
@Configuration
@EnableTransactionManagement
@Import(DataSourceConfiguration.class)
@PropertySource({ConfigConstants.PROPERTY_SOURCE})
public class HibernatePersistenceConfiguration extends AbstractPersistenceConfiguration {
    @Autowired
    protected DataSource dataSource;

    @Autowired
    Environment environment;

    public static String HBM2DDL_AUTO = "hibernate.hbm2ddl.auto";
    public static String DIALECT = "hibernate.dialect";
    public static String GENERATE_DDL = "hibernate.generateDdl";

    @Override
    public Properties getProperties() {
        return new Properties() {{
            setProperty(HBM2DDL_AUTO, environment.getProperty(HBM2DDL_AUTO));
            setProperty(DIALECT, environment.getProperty(DIALECT));
            setProperty(GENERATE_DDL, environment.getProperty(GENERATE_DDL));
        }};
    }

    @Override
    public DataSource getDataSource() {
        return dataSource;
    }

    @Override
    public String getPackageToScan() {
        return ConfigConstants.Packages.ENTITY;
    }

    @Override
    @Bean
    public JpaVendorAdapter getVendorAdaptor() {
        return new HibernateJpaVendorAdapter();
    }
}
