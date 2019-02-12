package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
//本服务启动后会自动注册进eureka服务中
@EnableEurekaClient
//服务发现
@EnableDiscoveryClient
//开启服务熔断机制
@EnableCircuitBreaker
public class DeptProvider8001_App {
	
	
	public static void main(String[] args) {
		
		SpringApplication.run(DeptProvider8001_App.class, args);
	}

}
