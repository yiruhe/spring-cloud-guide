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
import com.test.entity.DeptClientService;

@RestController
@RequestMapping("/consumer/dept")
public class DeptController_Consumer {
	
	
	    @Autowired
	    private DeptClientService deptClientService;

	    @GetMapping("/info/{id}")
	    public Dept info(@PathVariable(value = "id") Long id){
	        return deptClientService.get(id);
	    }
	    @PostMapping("/add")
	    public boolean add(@RequestBody Dept dept){
	        return deptClientService.add(dept);
	    }
	    @GetMapping("/list")
	    public List<Dept> list() {
	        return deptClientService.list();
	    }
}
