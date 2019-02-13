package com.cloud.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigClientRest {
	
    @Value("${spring.application.name}")
    private String applicationName;
 
    private String eurekaServers;
    @Value("${server.port}")
    private String port;
    
    @GetMapping("/config")
    public String getConfig() {
        String str = "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
        System.out.println(str);
        return "applicationName: " + applicationName + "\t eurekaServers:" + eurekaServers + "\t port: " + port;
    }
}
