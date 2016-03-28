package com.killpekeinside.config.spring;

import com.killpekeinside.config.spring.persistence.DataInitializerConfiguration;
import com.killpekeinside.config.spring.persistence.hibernate.HibernatePersistenceConfiguration;
import com.killpekeinside.config.spring.social.SocialConfiguration;
import com.killpekeinside.config.spring.util.UtilConfiguration;
import com.killpekeinside.config.spring.web.WebConfiguration;
import org.springframework.context.annotation.*;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

import static com.killpekeinside.config.properties.ConfigConstants.PROPERTY_SOURCE;

/**
 * Created by Raman_Susla on 22.03.2015 23:21.
 */
@Configuration
@Import({WebConfiguration.class,
        HibernatePersistenceConfiguration.class,
        DataInitializerConfiguration.class,
        UtilConfiguration.class,
        SocialConfiguration.class

})
@PropertySource( PROPERTY_SOURCE )
@ComponentScan
public class MainConfiguration {
    @Bean
    public static PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }
}
