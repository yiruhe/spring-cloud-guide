package com.test.entity;

import java.util.List;

import org.springframework.stereotype.Component;

import feign.hystrix.FallbackFactory;

@Component
public class DeptClientServiceFallbackFactory  implements FallbackFactory<DeptClientService>{

	@Override
	public DeptClientService create(Throwable cause) {
		
		 return new DeptClientService() {
            @Override
            public Dept get(long id) {
            	 Dept dept = new Dept();
            	 dept.setDname("无当前id对应名称");
                return dept;
            }

            @Override
            public List<Dept> list() {
                return null;
            }

            @Override
            public boolean add(Dept dept) {
                return false;
            }
        };
	}

}
