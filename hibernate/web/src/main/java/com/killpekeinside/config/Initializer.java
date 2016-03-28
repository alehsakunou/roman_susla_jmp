package com.killpekeinside.config;

import com.killpekeinside.config.properties.ConfigConstants;
import com.killpekeinside.config.properties.ConfigConstants.DispatcherProperties;
import com.killpekeinside.config.properties.ConfigConstants.Packages;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.ContextLoaderListener;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.FilterRegistration;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

/**
 * Created by Raman_Susla on 22.03.2015 23:30.
 */
public class Initializer implements WebApplicationInitializer {

    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        WebApplicationContext context = getContext();

        servletContext.addListener(new ContextLoaderListener(context));

        ServletRegistration.Dynamic dispatcher = servletContext.addServlet(DispatcherProperties.SERVLET, new DispatcherServlet(context));
        dispatcher.setLoadOnStartup(DispatcherProperties.ON_STARTUP);
        dispatcher.addMapping(DispatcherProperties.URL_PATTERN);

        FilterRegistration.Dynamic securityFilter = servletContext.addFilter(ConfigConstants.SecurityValues.FILTER_NAME, DelegatingFilterProxy.class);
        securityFilter.addMappingForUrlPatterns(null, false, ConfigConstants.SecurityValues.FILTER_URL_PATTERN);
    }

    private AnnotationConfigWebApplicationContext getContext() {
        return new AnnotationConfigWebApplicationContext() {{
            setConfigLocation(Packages.CONFIG);
        }};
    }
}
