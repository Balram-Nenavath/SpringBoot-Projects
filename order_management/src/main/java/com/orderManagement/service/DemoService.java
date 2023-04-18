package com.orderManagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.orderManagement.demo.entity.Demo;
import com.orderManagement.demo.repository.DemoRepository;

@Service
public class DemoService implements IDemoService {
	@Autowired
	DemoRepository demoRepo;

	@Override
	public List<Demo> getAll() {
		// TODO Auto-generated method stub
		return demoRepo.findAll();
	}

}
