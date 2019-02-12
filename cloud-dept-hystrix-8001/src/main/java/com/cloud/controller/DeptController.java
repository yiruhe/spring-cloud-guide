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
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.test.entity.Dept;

@RestController
@RequestMapping("/dept")
public class DeptController {
	
	@Autowired
    private IDeptService deptServiceImpl;
	
	@Autowired
	private DiscoveryClient client;
 

	@GetMapping("/info/{id}")
	//一旦调用服务方法出现错误,会自动调用@HystrixCommand指定的方法
    @HystrixCommand(fallbackMethod = "processHystrix")
    public Dept info(@PathVariable(value = "id") Long id){
        Dept dept = deptServiceImpl.get(id);
        if (dept == null) {
            throw new RuntimeException("没有找到id=" + id + "的部门");
        }
        return dept;
    }
    public Dept processHystrix(@PathVariable(value = "id") Long id){
    	
    	Dept dept = new Dept();
    	
    	dept.setDname("没有找到id=" + id + "的部门");
        
        return dept;
                         
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
