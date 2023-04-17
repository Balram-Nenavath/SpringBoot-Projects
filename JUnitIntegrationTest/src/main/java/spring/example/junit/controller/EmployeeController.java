package spring.example.junit.controller;

import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import io.swagger.annotations.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponses;
import spring.example.junit.entity.Airport;
import spring.example.junit.entity.Employee;
import spring.example.junit.exception.EmployeeAlreadyExistsException;
import spring.example.junit.exception.ErrorResponse;
import spring.example.junit.service.EmployeeService;


@RestController
//@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@GetMapping("/getEmployeebyId/{empid}")	
	public Employee getEmployee(@PathVariable int empid) {
		return service.getEmployee(empid);
	}


	// @Valid When the target argument fails to pass the validation, 
	//Spring Boot throws a MethodArgumentNotValidException exception.
	@ApiOperation(value = "Add Employee", notes="Adds Employee to the Database greeting",nickname = "AddEmp")
	@ApiResponses(value = {
			@ApiResponse(code = 500, message = "Server error"),
			@ApiResponse(code = 404, message = "Service not found"),
			@ApiResponse(code = 200, message = "Successful retrieval",
			response = Employee.class, responseContainer = "List") })
	@PostMapping("/addEmployee")
	public Employee addEmployee(@ApiParam(value = "testId",
	required = true, defaultValue = "111") @Valid @RequestBody Employee emp)
	{
		return service.addEmployee(emp);

	}


	@PostMapping("/addNewEmployee")
	public String addNewEmployee(@Valid @RequestBody Employee emp)
	{
		return service.addNewEmployee(emp);

	}


	@PostMapping("/addAllEmployees")
	public ResponseEntity<?> addAllEmployees(@Valid @RequestBody List<Employee> emp) throws Exception
	{
		List<Employee> empl =service.addAllEmployees(emp);
		if(empl!=null) {
			return new ResponseEntity<>(empl,HttpStatus.OK);
		}

		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}


	@DeleteMapping("/deleteAllEmployees") 
	public void  deleteAllEmployees(@RequestParam("empid") @PathVariable Integer[] empids) 
	{ 
		service.deleteAllEmployees(empids);
	}


	@PutMapping("/updateAllEmployees")
	public ResponseEntity<?> updateAllEmployees(@Valid @RequestBody List<Employee> emp) throws Exception
	{
		List<Employee> empl =service.updateAllEmployees(emp);
		if(empl!=null) {
			return new ResponseEntity<>(empl,HttpStatus.OK);
		}

		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@PatchMapping("/patchUpdateAllEmployees")
	public ResponseEntity<?> patchUpdateAllEmployees(
			@Valid @RequestBody List<Employee> empl/* ,@PathVariable int empid */){

		List<Employee> impl =service.patchUpdateAllEmployees(empl);
		if(impl!=null) {
			return new ResponseEntity<>(impl,HttpStatus.OK);
		}

		return new ResponseEntity<>("something went wrong",HttpStatus.INTERNAL_SERVER_ERROR);

	}


	@GetMapping("/getAllSEmployees")	
	public List<Employee> getAllEmployees() {
		return service.getAllEmployees();
	}


	@PutMapping("/updateNewEmployee")
	public String updateNewEmployee(@RequestBody Employee emp)
	{
		return service.updateNewEmployee(emp);
	}

	@PutMapping("/updateEmployee")
	public Employee updateEmployee(@RequestBody Employee emp)
	{
		return service.updateEmployee(emp);
	}


	@PatchMapping("/patchUpdateEmp/{empid}")
	public Employee updatePatchEmployee(@PathVariable int empid,@RequestBody Map<String, Object> fields){
		return service.updatePatchEmployee(empid,fields);
	}

	@DeleteMapping("/deleteEmployee/{empid}")
	public long deleteEmployee(@PathVariable int empid) {
		return service.deleteEmployee(empid);
	}
	@GetMapping("/test")
	public ResponseEntity<String> getAirportDetails(@RequestParam(name = "iata") String iata, @RequestParam(name = "icao") String icao){
		String resp=service.getDetailsofAirport( iata,  icao);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}


	@GetMapping("/covidTest")
	public ResponseEntity<String> getCovidDetails(@RequestParam(name = "search") String search){
		String resp=service.getDetailsofCovid( search);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	@PostMapping("/postAirport")
	public ResponseEntity<String> postAirportDetails(@RequestBody Airport air){
		String resp=service.postDetailsofAirport(air);
		return new ResponseEntity<>(resp,HttpStatus.OK);
	}

	@ExceptionHandler(value	= EmployeeAlreadyExistsException.class)
	@ResponseStatus(HttpStatus.CONFLICT)
	public ErrorResponse handleEmpoyeeAlreadyExistsException(EmployeeAlreadyExistsException ex)
	{
		return new ErrorResponse(HttpStatus.CONFLICT.value(),ex.getMessage());
	}
}