package com.springrest.springrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.springrest.springrest.SpringrestApplication;
import com.springrest.springrest.entity.Employee;
import com.springrest.springrest.service.EmployeeService;

@RestController
public class MyController {
	@Autowired
	private EmployeeService EmployeeService;
	Logger logger = LogManager.getLogger(SpringrestApplication.class);
	
	
	//Get employee details
	@GetMapping("/employees")
	public List<Employee> getEmployeesDetails()
	{
		logger.debug("Getting details");
		return this.EmployeeService.getEmployeesDetails();
	}
	

	@GetMapping("/employees/{empId}")
	public Employee getEmployeeDetail(@PathVariable long empId)
	{
		return this.EmployeeService.getEmployeeDetail(empId);
	}
	
	
	//Add Employees...
	@PostMapping(path="/employees",consumes="application/json")
	public Employee addEmployeeDetail(@RequestBody @Valid Employee emp)
	{
		return this.EmployeeService.addEmployeeDetail(emp);
		
	}
	@PutMapping(path="/employees",consumes="application/json")
	public Employee updateEmployeeDetail(@RequestBody Employee emp)
	{
		return this.EmployeeService.updateEmployeeDetail(emp);
		
	}
	
	@DeleteMapping("/employees/{empId}") 
	public ResponseEntity<HttpStatus>	deleteEmployeeDetail(@PathVariable long empId) {
		try {
		this.EmployeeService.deleteEmployeeDetail(empId); 
		return new ResponseEntity<>(HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}



	
}
