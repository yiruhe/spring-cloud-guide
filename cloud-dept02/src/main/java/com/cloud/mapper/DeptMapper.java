package com.cloud.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.test.entity.Dept;

@Mapper
public interface DeptMapper {
	
	
	 boolean addDept(Dept dept);

	 Dept findById(Long id);

	 List<Dept> findAll();

}
