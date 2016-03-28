package com.killpekeinside.spring.social.config.impl;

import com.killpekeinside.spring.social.config.Social;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.vkontakte.api.VKontakte;
import org.springframework.social.vkontakte.connect.VKontakteConnectionFactory;

/**
 * Created by Raman_Susla1 on 12/3/2015.
 */
public interface VkBean extends Social
{
    default VKontakte createVk(ConnectionRepository repository){
        return construct(repository,VKontakte.class);
    }

    default VKontakteConnectionFactory createVkFactory(String consumerKey, String consumerSecret)
    {
        return new VKontakteConnectionFactory(consumerKey, consumerSecret);
    }
}
