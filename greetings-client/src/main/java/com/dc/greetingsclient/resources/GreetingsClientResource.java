package com.dc.greetingsclient.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.security.oauth2.client.OAuth2RestTemplate;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsClientResource {

    @Autowired
    @Qualifier("oauth2RestTemplate")
    @LoadBalanced
    private OAuth2RestTemplate myOauth2RestTemplate;

    @GetMapping("/hello")
    public String callGreetings() {
        String result = myOauth2RestTemplate.getForObject("http://localhost:8080/hello", String.class);
        return result;
    }

    @GetMapping("/secure/hello")
    public String getSecureData() {
        String result = myOauth2RestTemplate.getForObject("http://localhost:8080/secure/hello", String.class);
        return result;
    }

    @PostMapping("/secure/hello")
    public String postSecureGreetings() {
        String result = myOauth2RestTemplate.postForObject("http://localhost:8080/secure/hello", String.class, String.class);
        return result;
    }

    @DeleteMapping("/secure/hello")
    public void deleteSecureGreetings() {
        myOauth2RestTemplate.delete("http://localhost:8080/secure/hello");
    }

}
