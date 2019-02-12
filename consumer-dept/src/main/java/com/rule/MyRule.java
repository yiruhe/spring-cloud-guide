package com.rule;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;


@Configuration
public class MyRule {
	
	
	  @Bean
	    public IRule myRule(){
	        return new RandomRule();
	    }
}
