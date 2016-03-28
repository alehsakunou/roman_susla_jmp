package com.killpekeinside.spring.social.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.social.ApiBinding;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionRepository;

/**
 * Created by Raman_Susla1 on 10/5/2015.
 */
public interface Social
{
    default <T extends ApiBinding> T construct(ConnectionRepository repository, Class<T> clazz)
    {
        Connection<T> connection = repository.findPrimaryConnection(clazz);
        return connection != null ? connection.getApi() : null;
    }
}
