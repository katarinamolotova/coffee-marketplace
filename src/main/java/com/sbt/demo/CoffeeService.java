package com.sbt.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoffeeService {
    @Value("${internal.url}")
    private String internalUrl;

    public String getInfoAboutCoffee() {
        RestTemplate template = new RestTemplate();
        ResponseEntity<String> response = template.getForEntity(internalUrl, String.class);
        return response.getBody();
    }
}
