package spring.example.demoxml.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import spring.example.demoxml.service.DemoService;

@RestController
public class Controller {
	
	@Autowired
	private DemoService demoService;
	
	
//	public void setDemoService(DemoService demoService)
//	{
//		this.demoService = demoService;
//	}
//	
	
	
	
	//Field Dependency Injection using some field 
	@Autowired
	private DemoService field;
	
	public String getField()
	{
		return field.getResult();
	}
	
	
	
	//Setter Dependency Injection
	@Autowired
	public void setDemoService(DemoService demoService)
	{
		this.demoService = demoService;
		demoService.getResult();
	}
	
	
	//Constructor Dependency Injection
	@Autowired
	public Controller(DemoService demoService) {
		this.demoService=demoService;
		demoService.getResult();
	}
	
	

	
	
	@GetMapping("/")
	public String hello()
	{
		return demoService.getResult();
	}

}
