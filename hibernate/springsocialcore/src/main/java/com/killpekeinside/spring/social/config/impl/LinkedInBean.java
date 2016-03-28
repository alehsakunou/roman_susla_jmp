package com.killpekeinside.spring.social.config.impl;

import com.killpekeinside.spring.social.config.Social;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.linkedin.api.LinkedIn;
import org.springframework.social.linkedin.connect.LinkedInConnectionFactory;

public interface LinkedInBean extends Social
{
    default LinkedIn createLinkedIn(ConnectionRepository repository)
    {
        return construct(repository, LinkedIn.class);
    }

    default LinkedInConnectionFactory createLinkedInFactory(String consumerKey, String consumerSecret)
    {
        return new LinkedInConnectionFactory(consumerKey, consumerSecret);
    }
}
