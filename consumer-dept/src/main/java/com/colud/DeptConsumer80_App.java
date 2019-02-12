package com.colud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;

import com.colud.config.ConfigBean;
import com.rule.MyRule;

@SpringBootApplication
@EnableEurekaClient
//MyRule 这个自定义的类不能放在@ComponentScan 所在的同包或子包下
//@RibbonClient(name = "SPRINGCLOUD-DEPT", configuration = MyRule.class)
@RibbonClient(name = "SPRINGCLOUD-DEPT")
public class DeptConsumer80_App {
	
	
	public static void main(String[] args) {
		  SpringApplication.run(DeptConsumer80_App.class, args);
	}

}
