package com.openfeign.serviceA.service;

import java.util.List;

import com.openfeign.serviceA.entity.Demo;

public interface IDemoService {
	List<Demo> getAllDemo();

	Demo getDemoById(Long id);
}
