package com.killpekeinside.config.spring.social;

import com.killpekeinside.config.properties.ConfigConstants;
import com.killpekeinside.spring.social.config.AbstractSocialConfiguration;
import com.killpekeinside.spring.social.config.SocialConfigConstants;
import com.killpekeinside.spring.social.config.impl.VkBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;
import org.springframework.core.env.Environment;
import org.springframework.social.config.annotation.ConnectionFactoryConfigurer;
import org.springframework.social.config.annotation.EnableSocial;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.vkontakte.api.VKontakte;

/**
 * Created by Raman_Susla1 on 9/10/2015.
 */
@Configuration
@PropertySource ({ConfigConstants.SOCIAL_PROPERTY_SOURCE})
@EnableSocial
public class SocialConfiguration extends AbstractSocialConfiguration implements VkBean
{
    @Value (ConfigConstants.SocialValues.VK_ID)
    private String vkId;
    @Value (ConfigConstants.SocialValues.VK_SECRET)
    private String vkSecret;


    @Override
    public void addConnectionFactories(ConnectionFactoryConfigurer connectionFactoryConfigurer, Environment environment)
    {
        connectionFactoryConfigurer.addConnectionFactory(createVkFactory(vkId, vkSecret));
    }

    @Bean
    @Scope (value= SocialConfigConstants.REQUEST_SCOPE, proxyMode= ScopedProxyMode.INTERFACES)
    public VKontakte vk(ConnectionRepository repository)
    {
        return createVk(repository);
    }

}
