package com.colud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.colud.config.ConfigBean;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"com"})
public class DeptConsumer80_App {
	
	
	public static void main(String[] args) {
		  SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
