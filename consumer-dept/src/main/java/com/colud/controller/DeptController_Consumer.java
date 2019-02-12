package com.colud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.test.entity.Dept;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {
	
	
    //private final static String RESTPRE = "http://127.0.0.1:8001";
    // 设置成对外暴露的微服务的名字
    private final static String RESTPRE = "http://SPRINGCLOUD-DEPT";
	
	@Autowired
    private RestTemplate restTemplate;
	
	
	@GetMapping("/info/{id}")
    public Dept info(@PathVariable(value = "id") Long id){
        return restTemplate.getForObject(RESTPRE + "/dept/info/" + id, Dept.class);
    }

	
	@PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return restTemplate.postForObject(RESTPRE + "/dept/add", dept, Boolean.class);
    }
	
	@GetMapping("/list")
	 public List<Dept> list(){
	        return restTemplate.getForObject(RESTPRE + "/dept/list", List.class);
	    }
	
    @GetMapping("/discovery")
    public Object discovery(){
        return restTemplate.getForObject(RESTPRE + "/dept/discovery", Object.class);
    }
}
