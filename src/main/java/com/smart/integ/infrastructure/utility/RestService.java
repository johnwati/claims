package com.smart.integ.infrastructure.utility;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class RestService {

    private final RestTemplate restTemplate;
    private  Map param=null;
    private String url = "";

    public void RestService(Map param){
        this.param = param;

    }

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplate = restTemplateBuilder.build();

    }

    public String getPostsPlainJSON(String url) {
        return this.restTemplate.getForObject(url, String.class);
    }
}
