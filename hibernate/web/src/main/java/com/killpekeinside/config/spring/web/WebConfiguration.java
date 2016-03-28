package com.killpekeinside.config.spring.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.MediaType;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ContentNegotiationConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.util.HashMap;

import static com.killpekeinside.config.properties.ConfigConstants.Packages;
import static com.killpekeinside.config.properties.ConfigConstants.WebViewValues;
import static com.killpekeinside.config.properties.doc.MediaTypeKey.JSON;
import static com.killpekeinside.config.properties.doc.MediaTypeKey.XML;


/**
 * Created by Raman_Susla on 23.03.2015 0:22.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {Packages.BASE})
public class WebConfiguration extends WebMvcConfigurerAdapter {
    @Value(WebViewValues.DIRECTORY)
    private String viewDirectory;

    @Value(WebViewValues.EXTENSION)
    private String viewExtension;

    @Value(WebViewValues.TEMPLATE)
    private String template;

    @Value(WebViewValues.TEMPLATE_VARIABLE)
    private String templateVariable;

    @Value(WebViewValues.CONTENT_TYPE)
    private String contentType;

    @Autowired
    protected Environment environment;


    @Bean
    public ViewResolver getViewResolver() {
        JstlView.template = template;
        JstlView.templateVariable = templateVariable;
        JstlView.viewDirectory = viewDirectory;
        JstlView.viewContentType = contentType;

        return new InternalResourceViewResolver() {{
            setViewClass(JstlView.class);
            setPrefix(viewDirectory);
            setSuffix(viewExtension);
        }};
    }

    @Override
    public void configureContentNegotiation(ContentNegotiationConfigurer configurer) {
        configurer.favorPathExtension(false);
        configurer.favorParameter(true);
        HashMap<String, MediaType> mediaTypes = new HashMap<String, MediaType>() {{
            put(JSON.getKey(), MediaType.APPLICATION_JSON);
            put(XML.getKey(), MediaType.APPLICATION_XML);
        }};
        configurer.mediaTypes(mediaTypes);
    }


}
