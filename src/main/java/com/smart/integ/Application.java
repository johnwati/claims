package com.smart.sample;

import org.springframework.boot.SpringApplication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.context.config.annotation.RefreshScope;

import org.springframework.web.client.RestTemplate;

@RefreshScope
@EnableDiscoveryClient
@SpringBootApplication
public class Application {

  public static void main(String[] args) {
    SpringApplication.run(Application.class, args);
    }

  @LoadBalanced
  @Bean
  RestTemplate restTemplate() {
      return new RestTemplate();
      }

}
