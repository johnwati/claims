/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.smart.integ.controller;

/**
 *
 * @author John.Simiyu
 */
import com.smart.integ.repository.AbacusRepository;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class StartupRunner implements ApplicationRunner {
 
    @Autowired
    AbacusRepository abacusRepository;

    @Autowired
    private RestTemplate restTemplate;
    Logger log = Logger.getLogger(StartupRunner.class.getName());

    @Override
    public void run(ApplicationArguments args) throws Exception {
         
    }
}


