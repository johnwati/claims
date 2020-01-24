package com.smart.sample.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@RequestMapping(path="/instance")
public class ServiceInstanceController {

  Logger log = LoggerFactory.getLogger(ServiceInstanceController.class);

  //alues loaded by Config Server always have higher priority.
  @Value("${app.title:TITLE NOT FOUND}")
  String title;

  @Autowired
  private DiscoveryClient discoveryClient;

  @RequestMapping("/configcheck")
  public String test() {

    log.info("Title from config server : " + title);
    return title;
    //return this.discoveryClient.getInstances(applicationName);
    }

  @RequestMapping("/service/{applicationName}")
  public List<ServiceInstance> serviceInstancesByApplicationName(
      @PathVariable String applicationName) {
        //log.info("Title from config server : " + title);    
        return this.discoveryClient.getInstances(applicationName);
        }

    }