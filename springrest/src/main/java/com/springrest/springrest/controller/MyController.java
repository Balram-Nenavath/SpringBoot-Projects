package com.springrest.springrest.controller;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.codec.binary.Base64;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
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
	@PostMapping(path="/employees",consumes="application/json")
	public Employee addEmployeeDetail(@RequestBody Employee emp)
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



@RequestMapping(value = "/showEmployees", method = RequestMethod.GET)
public String showEmployees(@RequestParam("code") String code) throws JsonProcessingException, IOException {
	ResponseEntity<String> response = null;
	System.out.println("Authorization Code------" + code);

	RestTemplate restTemplate = new RestTemplate();

	String credentials = "javainuse:secret";
	String encodedCredentials;
	encodedCredentials = new String(Base64.encodeBase64(credentials.getBytes()));
	

	HttpHeaders headers = new HttpHeaders();
	headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
	headers.add("Authorization", "Basic " + encodedCredentials);

	HttpEntity<String> request = new HttpEntity<String>(headers);

	String access_token_url = "http://localhost:8081/oauth/token";
	access_token_url += "?code=" + code;
	access_token_url += "&grant_type=authorization_code";
	access_token_url += "&redirect_uri=http://localhost:8081/showEmployees";

	response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);

	System.out.println("Access Token Response ---------" + response.getBody());

	// Get the Access Token From the recieved JSON response
	ObjectMapper mapper = new ObjectMapper();
	JsonNode node = mapper.readTree(response.getBody());
	String token = node.path("access_token").asText();

	String url = "http://localhost:8081/getEmployeesList";

	// Use the access token for authentication
	HttpHeaders headers1 = new HttpHeaders();
	headers1.add("Authorization", "Bearer " + token);
	HttpEntity<String> entity = new HttpEntity<>(headers1);

	ResponseEntity<String> employees = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);
	System.out.println(employees);
	String employeeArray = employees.getBody();

	//ModelAndView model = new ModelAndView("showEmployees");
	//model.addObject("employees", Arrays.asList(employeeArray));
	return employeeArray;
}
	
@GetMapping("/getEmployeesList")
public String getEmployeesList() {
	
	List<Employee> employees = new ArrayList<>();
    Employee emp = new Employee();
    emp.setEmpid(3324);
    emp.setName("Balram");
    emp.setDesignation("Technical Associate");
    employees.add(emp);
    return employees.toString();
	//return "this is a private endppoint";
	
}
	
}
