package com.killpekeinside.config.properties;

/**
 * Created by Raman_Susla on 24.03.2015 23:30.
 */
public interface ConfigConstants {
    String PROPERTY_SOURCE = "classpath:properties/main.properties";
    String SOCIAL_PROPERTY_SOURCE = "classpath:properties/social.properties";

    interface DbConfigPaths {
        String POSTGRES = "classpath:properties/db/postgres.properties";
        String SCHEMA_SQL = "classpath:sql/db-schema.sql";
        String DATA_SQL = "classpath:sql/db-data.sql";
    }

    interface Packages {
        String BASE = "com.killpekeinside";
        String ENTITY = "com.killpekeinside.data.entity";
        String CONFIG = "com.killpekeinside.config.spring";
    }

    interface DbConfigValues{
        String DRIVER = "${db.driver}";
        String URL = "${db.url}";
        String USER = "${db.user}";
        String PASSWORD = "${db.password}";
    }

    interface WebViewValues{
        String DIRECTORY = "${view.directory}";
        String EXTENSION = "${view.ext}";
        String TEMPLATE = "${view.template}";
        String TEMPLATE_VARIABLE = "${view.template.variable}";
        String CONTENT_TYPE = "${view.content.type}";
    }

    interface DispatcherProperties {
        String URL_PATTERN = "/";
        String SERVLET = "DispatcherServlet";
        int ON_STARTUP = 1;
    }

    interface SecurityValues{
        String FILTER_NAME = "springSecurityFilterChain";
        String FILTER_URL_PATTERN = "/*";
    }

    interface SocialValues{
        String VK_ID = "${soc.vk.id}";
        String VK_SECRET = "${soc.vk.secret}";

        String LINKEDIN_ID = "${soc.linkedin.id}";
        String LINKEDIN_SECRET = "${soc.linkedin.secret}";

        String GITHUB_ID = "${soc.github.id}";
        String GITHUB_SECRET = "${soc.github.secret}";
    }
}