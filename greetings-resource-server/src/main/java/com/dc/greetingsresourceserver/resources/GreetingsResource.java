package com.dc.greetingsresourceserver.resources;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingsResource {

    @GetMapping("/hello")
    public String getHello() {
        return "Hello World";
    }

    @GetMapping("/secure/hello")
    public String getSecureHello() {
        return "Get Secure Hello World";
    }

    @PostMapping("/secure/hello")
    public String postSecureHello() {
        return "Post Secure Hello World";
    }

    @DeleteMapping("/secure/hello")
    public String deleteSecureHello() {
        return "Delete Secure Hello World";
    }
}
