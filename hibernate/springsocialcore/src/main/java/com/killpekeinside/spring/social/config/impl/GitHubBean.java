package com.killpekeinside.spring.social.config.impl;

import com.killpekeinside.spring.social.config.Social;
import org.springframework.social.connect.ConnectionRepository;
import org.springframework.social.github.api.GitHub;
import org.springframework.social.github.connect.GitHubConnectionFactory;

/**
 * Created by Raman_Susla1 on 10/5/2015.
 */
public interface GitHubBean extends Social
{
    default GitHub createGitHub(ConnectionRepository repository){
        return construct(repository,GitHub.class);
    }

    default GitHubConnectionFactory createGitHubFactory(String consumerKey, String consumerSecret)
    {
        return new GitHubConnectionFactory(consumerKey, consumerSecret);
    }
}

