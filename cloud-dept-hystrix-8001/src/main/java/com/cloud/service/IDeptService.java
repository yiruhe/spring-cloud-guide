package com.cloud.service;

import java.util.List;

import com.test.entity.Dept;

public interface IDeptService {

	boolean add(Dept dept);

	Dept get(Long id);

	List<Dept> list();

}
