package com.smart.sample.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.beans.factory.annotation.Value;

import org.springframework.web.client.RestTemplate;
import org.springframework.web.bind.annotation.CrossOrigin; 

//@CrossOrigin
@RestController
@RequestMapping(path="/sample")
public class SampleController {

    Logger log = LoggerFactory.getLogger(SampleController.class);

    //values loaded by Config Server always have higher priority.
    @Value("${app.message:MESSAGE NOT FOUND}")
    String message;
    
    @Autowired
    RestTemplate restTemplate;

    //@Autowired
    //RestTemplateLB restTemplate;
    
    
    // @RequestMapping(value = "/integ/clientmap/{schoolname}", method = RequestMethod.GET)
    // public String getStudents(@PathVariable String schoolname) {
    //     System.out.println("Getting School details for " + schoolname); 
    //     String response = restTemplate.exchange("http://student-service/getStudentDetailsForSchool/{schoolname}",
    //                             HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolname).getBody();
 
    //     System.out.println("Response Received as " + response); 
    //     return "School Name -  " + schoolname + " \n Student Details " + response;
    //     }
 
    //@RequestMapping(value = "/recommendations", method = RequestMethod.GET)
    @GetMapping(path="/clientmap/list")
    //@ResponseBody
    public @ResponseBody String getClientMap() {
        //Movie[] result = restTemplate.getForObject("http://movie-service/movies", Movie[].class);
        String result = restTemplate.getForObject("http://sample-crud-api/crudapi/clientmap/list", String.class);
        return result;
        }
    
    // @PostMapping(path="/add")
    // @ApiOperation(value = "Add a new mapping", response = ClientMap.class)
    // public @ResponseBody ClientMap addNewClientMap (@RequestBody ClientMap obj){
    //     clientMapRepository.save(obj);
    //     return obj;
    //     }

}