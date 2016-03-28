package com.killpekeinside.spring.social.config;

import com.killpekeinside.spring.social.util.SimpleSignInAdapter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.encrypt.TextEncryptor;
import org.springframework.social.UserIdSource;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.config.annotation.SocialConfigurer;
import org.springframework.social.connect.ConnectionFactoryLocator;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.connect.UsersConnectionRepository;
import org.springframework.social.connect.jdbc.JdbcUsersConnectionRepository;
import org.springframework.social.connect.web.ConnectController;
import org.springframework.social.connect.web.ProviderSignInController;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.social.security.AuthenticationNameUserIdSource;

import javax.sql.DataSource;

/**
 * Created by Raman_Susla1 on 10/5/2015.
 */
@Configuration
@EnableSocial
public abstract class AbstractSocialConfiguration implements SocialConfigurer
{
    @Autowired
    private DataSource dataSource;
    @Autowired
    private TextEncryptor textEncryptor;
    @Autowired
    private SimpleSignInAdapter adapter;


    @Override
    public abstract void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment);

    public void addInterceptors(ConnectController connectController)
    {

    }

    @Bean
    public ProviderSignInUtils providerSignInUtils(ConnectionFactoryLocator factoryLocator, UsersConnectionRepository repository)
    {
        return new ProviderSignInUtils(factoryLocator, repository);
    }

    @Bean
    public UserIdSource getUserIdSource()
    {
        return new AuthenticationNameUserIdSource();
    }

    @Override
    public UsersConnectionRepository getUsersConnectionRepository(ConnectionFactoryLocator connectionFactoryLocator)
    {
        return new JdbcUsersConnectionRepository(dataSource, connectionFactoryLocator, textEncryptor);
    }

    @Bean
    public ConnectController connectionController(ConnectionFactoryLocator factoryLocator, ConnectionRepository repository)
    {
        ConnectController connectController = new ConnectController(factoryLocator, repository);
        addInterceptors(connectController);
        return connectController;
    }

    @Bean
    public ProviderSignInController providerSignInController(ConnectionFactoryLocator connectionFactoryLocator, UsersConnectionRepository usersConnectionRepository) {
        return new ProviderSignInController(connectionFactoryLocator, usersConnectionRepository, adapter);
    }
}
