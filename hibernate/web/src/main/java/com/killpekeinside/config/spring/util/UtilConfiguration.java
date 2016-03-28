package com.killpekeinside.config.spring.util;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.encrypt.Encryptors;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;

/**
 * Created by Raman_Susla1 on 6/9/2015.
 */
@Configuration
public class UtilConfiguration
{
    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder()
    {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public TextEncryptor textEncryptor()
    {
        return Encryptors.noOpText();
    }

    @Bean
    public RequestCache requestCache()
    {
        return new HttpSessionRequestCache();
    }
}
