package com.openfeign.serviceD;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@Autowired
	ServiceAproxy proxy;
	
	@GetMapping("/demoProxy")
	public List<Object> getAllItems(){
		return proxy.getDemoItems();
		
	}
}
