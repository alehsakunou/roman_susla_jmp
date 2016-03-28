package com.killpekeinside.spring.jconf.persistence;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.annotation.PersistenceExceptionTranslationPostProcessor;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Properties;

/**
 * Created by Raman_Susla on 23.03.2015 0:23.
 */
@Configuration
public abstract class AbstractPersistenceConfiguration
{
    public abstract DataSource getDataSource();
    public abstract String getPackageToScan();
    public abstract JpaVendorAdapter getVendorAdaptor();
    public abstract Properties getProperties();

    @Bean
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean  entityManager = new LocalContainerEntityManagerFactoryBean ();
        entityManager.setDataSource(getDataSource());
        entityManager.setPackagesToScan(getPackageToScan());

        entityManager.setJpaVendorAdapter(getVendorAdaptor());
        entityManager.setJpaProperties(getProperties());

        return entityManager;
    }

    @Bean
    public PlatformTransactionManager transactionManager(EntityManagerFactory emf){
        JpaTransactionManager transactionManager = new JpaTransactionManager();
        transactionManager.setEntityManagerFactory(emf);
        return transactionManager;
    }

    @Bean
    public PersistenceExceptionTranslationPostProcessor exceptionTranslation(){
        return new PersistenceExceptionTranslationPostProcessor();
    }
}
