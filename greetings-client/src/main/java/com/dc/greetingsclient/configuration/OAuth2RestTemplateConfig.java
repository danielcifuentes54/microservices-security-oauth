package com.dc.greetingsclient.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.security.oauth2.client.token.grant.client.ClientCredentialsResourceDetails;

import java.util.Arrays;

@Configuration
public class OAuth2RestTemplateConfig {

    @Bean(name = "oauth2RestTemplate")
    @LoadBalanced
    public OAuth2RestTemplate restTemplate() {
        OAuth2RestTemplate restTemplate = new OAuth2RestTemplate(resourceDetails());
        return restTemplate;
    }

    public ClientCredentialsResourceDetails resourceDetails() {
        ClientCredentialsResourceDetails clientCredentialsResourceDetails = new ClientCredentialsResourceDetails();
        clientCredentialsResourceDetails.setId("1");
        clientCredentialsResourceDetails.setClientId("greetings-client");
        clientCredentialsResourceDetails.setClientSecret("12345");
        clientCredentialsResourceDetails.setAccessTokenUri("http://localhost:9000/oauth/token");
        clientCredentialsResourceDetails.setScope(Arrays.asList("read", "write"));
        clientCredentialsResourceDetails.setGrantType("client_credentials");
        return clientCredentialsResourceDetails;
    }
}
