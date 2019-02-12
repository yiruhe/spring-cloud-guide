package com.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;


@SpringBootApplication
//EurekaServer 服务启动类 接受其他微服务注册进来
@EnableEurekaServer
public class EurekaServer7001_App {

	
	public static void main(String[] args) {
        SpringApplication.run(EurekaServer7001_App.class, args);
    }
}
