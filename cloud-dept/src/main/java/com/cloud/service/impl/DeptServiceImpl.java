package com.cloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloud.mapper.DeptMapper;
import com.cloud.service.IDeptService;
import com.test.entity.Dept;


@Service
public class DeptServiceImpl implements IDeptService{
	
	   @Autowired
	    private DeptMapper deptDao;

	    @Override
	    public boolean add(Dept dept) {
	        return deptDao.addDept(dept);
	    }

	    @Override
	    public Dept get(Long id) {
	        return deptDao.findById(id);
	    }

	    @Override
	    public List<Dept> list() {
	        return deptDao.findAll();
	    }

}
