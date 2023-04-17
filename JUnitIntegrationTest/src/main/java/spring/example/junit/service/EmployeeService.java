package spring.example.junit.service;

import java.lang.reflect.Field;
import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.ReflectionUtils;
import org.springframework.web.client.RestTemplate;

import spring.example.junit.entity.Airport;
import spring.example.junit.entity.Employee;
import spring.example.junit.exception.EmployeeAlreadyExistsException;
import spring.example.junit.exception.NoSuchEmployeeExistsException;
import spring.example.junit.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Value("${api-key}")
	String apikey;
	@Value("${api-host}")
	String apiHost;
	@Value("${airport-url}")
	String airportUrl;


	@Value("${phone-api-key}")
	String phoneApiKey;
	@Value("${phone-api-host}")
	String phoneApiHost;
	@Value("${phone-url}")
	String phoneUrl;
	@Autowired
	EmployeeRepository EmpRepo;

	@Autowired
	private RestTemplate template;

	@Autowired
	@Qualifier(value="covid")
	private RestTemplate rtemplate;
	private static final Logger logger = LoggerFactory.getLogger(EmployeeService.class);


	public Employee getEmployee(int empid)
	{
		logger.info("Fetching emp value with id : "+ EmpRepo.findById(empid).get().toString());
		return EmpRepo.findById(empid).get();

	}
	public Employee addEmployee(Employee emp)
	{
		logger.info("Added Employee detail and saved.");
		return EmpRepo.save(emp);
	}

	public List<Employee> getAllEmployees()
	{
		logger.info("Fetching All Employees : ");
		return EmpRepo.findAll();

	}

	public Employee updateEmployee(Employee emp) {
		logger.info("Update Employee detail and saved.");
		return EmpRepo.save(emp);

	}

	public String updateNewEmployee(Employee emp) {
		logger.info("Update Employee detail and saved.");

		Employee existingEmployee  = EmpRepo.findById(emp.getEmpid()).orElse(null);
		if (existingEmployee == null)
			throw new NoSuchEmployeeExistsException(
					"No Such Customer exists!!");
		else {
			existingEmployee.setName(emp.getName());
			existingEmployee.setDept(emp.getDept());
			existingEmployee.setSal(emp.getSal());
			EmpRepo.save(existingEmployee);
			return "Record updated Successfully";
		}
	}

	public Employee updatePatchEmployee(int empid, Map<String, Object> fields) {
		logger.info("Patch Employee detail and saved.");
		Optional<Employee> existingEmployee = EmpRepo.findById(empid);

		if (existingEmployee.isPresent()) {
			fields.forEach((key, value) -> {
				Field field = ReflectionUtils.findField(Employee.class, key);
				field.setAccessible(true);
				ReflectionUtils.setField(field, existingEmployee.get(), value);
			});
			Employee empResponse = EmpRepo.save(existingEmployee.get());
			return empResponse;
		}
		return null;
	}


	public long deleteEmployee(int empid) {
		logger.info("Delete Employee detail.");
		EmpRepo.deleteById(empid);
		return EmpRepo.count();
	}


	public String getDetailsofAirport(String iata, String icao)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key",apikey);
		headers.set("X-RapidAPI-Host", apiHost);

		HttpEntity<?> requestEntity = new HttpEntity<>(headers);

		String url=airportUrl+"iata="+iata+"&icao="+icao;

		ResponseEntity<String> response = template.exchange(
				url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}


	public String getDetailsofCovid(String search)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key",phoneApiKey);
		headers.set("X-RapidAPI-Host", phoneApiHost);

		HttpEntity<?> requestEntity = new HttpEntity<>(headers);

		String url=phoneUrl+"search="+search;

		ResponseEntity<String> response = rtemplate.exchange(
				url, HttpMethod.GET, requestEntity, String.class);
		return response.getBody();
	}

	public String addNewEmployee(@Valid Employee emp) {
		// TODO Auto-generated method stub
		//return EmpRepo.save(emp);
		Employee existingEmployee= EmpRepo.findById(emp.getEmpid()).orElse(null);
		if (existingEmployee == null) {
			EmpRepo.save(emp);
			return "Customer added successfully";
		}
		else
			throw new EmployeeAlreadyExistsException(
					"Customer already exists!!");
	}

	@Transactional
	public 	List<Employee> addAllEmployees(@Valid List<Employee> emps) throws RuntimeException {
		List<Employee> temp = new ArrayList<>();
		for (Employee emp : emps) {
			if ( emp.getDept()!=null && emp.getName()!=null && emp.getSal()!=null) {
				temp.add(emp);
			}
			else
			{
				throw new RuntimeException("Exception in saving all records : Rolling Back");
			}

		}
		EmpRepo.saveAll(temp);
		return temp;
	}
	/*
	 * private Employee dummy() throws Exception { // TODO Auto-generated method
	 * stub throw new RuntimeException(); }
	 */


	@Transactional
	public void deleteAllEmployees(Integer[] empids) {
		List<Integer> temp = new ArrayList<>();
		for (Integer empid : empids) {
			temp.add(empid);

		}
		EmpRepo.deleteAllById(temp);
	}



	@Transactional
	public 	List<Employee> updateAllEmployees(@Valid List<Employee> emps) throws RuntimeException {
		List<Employee> temp = new ArrayList<>();
		for (Employee emp : emps) {
			if ( emp.getDept()!=null && emp.getName()!=null && emp.getSal()!=null) {
				temp.add(emp);
			}
			else
			{
				throw new RuntimeException("Exception in updating all records : Rolling Back");
			}

		}
		EmpRepo.saveAll(temp);
		return temp;
	}

	@Transactional
	public List<Employee> patchUpdateAllEmployees(List<Employee> empl){

		List<Employee> temp = new ArrayList<>();
		for (Employee emp : empl) {
			if ( emp.getDept()!=null | emp.getName()!=null | emp.getSal()!=null) {
				temp.add(emp);
			}
			else
			{
				throw new RuntimeException("Exception in updating all records : Rolling Back");
			}


			/*	List<Employee> newEmployeeList = EmpRepo.findById1(empid);

		for(Employee employee :  newEmployeeList) {
			employee.setName(empl.getName());
			employee.setDept(empl.getDept());
			employee.setSal(empl.getSal());
		}*/

		}
		EmpRepo.saveAll(temp);

		return temp;

	}



	public String postDetailsofAirport(Airport air)
	{
		HttpHeaders headers = new HttpHeaders();
		headers.set("X-RapidAPI-Key",apikey);
		headers.set("X-RapidAPI-Host", apiHost);

		HttpEntity<?> requestEntity = new HttpEntity<>(air,headers);

		String url ="https://rapidapi.com/Active-api/api/airport-info";

		ResponseEntity<String> response = template.postForEntity(url, requestEntity, String.class);


		//ResponseEntity<String> response = template.exchange(
		//	url, HttpMethod.POST, requestEntity, String.class);
		return response.getBody();
	}
}
