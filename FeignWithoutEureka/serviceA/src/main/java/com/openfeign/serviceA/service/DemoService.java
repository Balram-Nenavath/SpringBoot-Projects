package com.openfeign.serviceA.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired; 
import org.springframework.stereotype.Service;

import com.openfeign.serviceA.entity.Demo;
import com.openfeign.serviceA.repository.DemoRepository;

@Service
//@Scope(value="prototype" ,proxyMode=ScopedProxyMode.TARGET_CLASS)
public class DemoService implements IDemoService {

	@Autowired
	DemoRepository demoRepository;

	@Override
	public List<Demo> getAllDemo() {
		System.out.println("serviceA called");
		return demoRepository.findAll();

	}
	@Override
	public Demo getDemoById(Long id) {
		Optional<Demo> demo = demoRepository.findById(id);
		if (!demo.isEmpty() && demo != null) {
			return demo.get();
			
		} else {
			return null;
		}
	}

}
