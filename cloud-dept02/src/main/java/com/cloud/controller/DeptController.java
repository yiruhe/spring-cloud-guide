package com.cloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloud.service.IDeptService;
import com.test.entity.Dept;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
    private IDeptService deptServiceImpl;
	
	   @Autowired
	private DiscoveryClient client;
 

    @GetMapping("/info/{id}")
    public Dept info(@PathVariable(value = "id") Long id){
        return deptServiceImpl.get(id);
    }

    @PostMapping("/add")
    public boolean add(@RequestBody Dept dept){
        return deptServiceImpl.add(dept);
    }

    @GetMapping("/list")
    public List<Dept> list(){
        return deptServiceImpl.list();
    }
    
    @GetMapping("/discovery")
    public Object discovery(){
        List<String> services = client.getServices();
        System.out.println(services);
        List<ServiceInstance> instances = client.getInstances("SPRINGCLOUD-DEPT");
        for (ServiceInstance serviceInstance : instances) {
           System.out.println(serviceInstance.getHost()+"======"+serviceInstance.getUri());
        }
        return this.client;
    }

}
