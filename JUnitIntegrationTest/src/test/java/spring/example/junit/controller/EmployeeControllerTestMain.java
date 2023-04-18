package spring.example.junit.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import java.util.HashMap;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.util.LinkedMultiValueMap;
import spring.example.junit.entity.Airport;

import spring.example.junit.entity.Employee;
import spring.example.junit.exception.EmployeeAlreadyExistsException;
import spring.example.junit.exception.NoSuchEmployeeExistsException;
import spring.example.junit.repository.EmployeeRepository;
import spring.example.junit.service.EmployeeService;

@ExtendWith(SpringExtension.class)
@WebMvcTest(EmployeeController.class)
public class EmployeeControllerTestMain
{
	@Autowired
	MockMvc	mockMvc;
	@MockBean
	EmployeeService service;
	
	@MockBean
	EmployeeRepository repo;

	@Test
	public void getAllEmployeesTest()
			throws
			Exception
	{
		mockMvc.perform(get("/getAllSEmployees").contentType("application/json")).andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void getEmployeeByIdTest() throws Exception
	{
		mockMvc.perform(get("/getEmployeebyId/123").contentType("application/json")).andDo(print()).andExpect(status().isOk());//.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(1));    
	}
	@Test
	public void	saveEmployees() throws JsonProcessingException,Exception
	{
		Employee emp = new Employee(123,"Sai","JFP","27k");
		ObjectMapper mapper=new	ObjectMapper();
		when(service.addEmployee(any())).thenReturn(emp);
		mockMvc.perform(post("/addEmployee").contentType("application/json").content(mapper.writeValueAsString(emp)))
		.andDo(print()).andExpect(status().isOk());
	}

	@Test
	public void	AddEmployeeeTestFailed() throws Exception
	{
		Employee emp = new Employee(123,"Sai","JFP","27k");
		ObjectMapper mapper=new	ObjectMapper();
		when(service.addNewEmployee(any())).thenThrow(EmployeeAlreadyExistsException.class);
		mockMvc.perform(post("/addNewEmployee").contentType("application/json").content(mapper.writeValueAsBytes(emp)))
		.andDo(print()).andExpect(status().isConflict());
	}

	@Test
	public void getAirportDetailsTest() throws	Exception
	{
		//String testAirport1="DEL";
		//String testAirport2="VIDP";
		//{"id":1734,"iata":"DEL","icao":"VIDP","name":"Indira Gandhi International Airport","location":"Delhi, India","street_number":"","street":"","city":"New Delhi","county":"","state":"Delhi","country_iso":"IN","country":"India","postal_code":"110037","phone":"+91 124 337 6000","latitude":28.556162,"longitude":77.09996,"uct":330,"website":"http://www.newdelhiairport.in/"}
		Airport	resp=new Airport(1734,"DEL","VIDP","Indira Gandhi International Airport","Delhi, India","","","New Delhi","","Delhi","IN","India","110037","+91 124 337 6000",28.556162,77.09996,330,"http://www.newdelhiairport.in/");
	//	Airport	resp=new Airport(1734,"DEL","VIDP","Indira Gandhi International Airport","Delhi, India","","","New Delhi","","Delhi","IN","India","110037","+91 124 337 6000",28.556162,77.09996,330,"http://www.newdelhiairport.in/");

	LinkedMultiValueMap<String, String> requestParams = new LinkedMultiValueMap<>();
		requestParams.add("iata", "DEL");
		requestParams.add("icao", "VIDP");
		when(service.getDetailsofCovid(any())).thenReturn(String.valueOf(resp));
		mockMvc.perform(get("/test").params(requestParams)).andExpect(status().isOk());
	}

	@Test
	public void getCovidTest() throws Exception
	{
	//String search = "India";
	//mockMvc.perform(get("/covidTest").contentType("application/json").content(search)).andDo(print())
		mockMvc.perform(get("/covidTest").param("search","India")).andExpect(status().isOk());
	}
	
	@Test
	public void	getAirportDetailsFailed() throws Exception
	{
		String testAirport1="DEL";
		String testAirport2="VIDP";
		//{"id":1734,"iata":"DEL","icao":"VIDP","name":"Indira Gandhi International Airport","location":"Delhi, India","street_number":"","street":"","city":"New Delhi","county":"","state":"Delhi","country_iso":"IN","country":"India","postal_code":"110037","phone":"+91 124 337 6000","latitude":28.556162,"longitude":77.09996,"uct":330,"website":"http://www.newdelhiairport.in/"}

		Airport	resp=new Airport(1734,"DEL","VIDP","Indira Gandhi International Airport","Delhi, India","","","New Delhi","","Delhi","IN","India","110037","+91 124 337 6000",28.556162,77.09996,330,"http://www.newdelhiairport.in/");
		when(service.getDetailsofAirport(testAirport1, testAirport2)).thenReturn(null);
		mockMvc.perform(get("/test").contentType("application/json").content(testAirport1)).andDo(print())
		.andExpect(status().isBadRequest());

	}

	@Test
	public void	updateDetailsTest() throws Exception
	{

		Employee emp = new Employee(123,"Sai","JFP","27k");
		ObjectMapper mapper	=new ObjectMapper();
		when(service.updateEmployee(any())).thenReturn(emp);
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.put("/updateEmployee")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)
				.content(mapper.writeValueAsString(emp));
		this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		/*.andExpect(MockMvcResultMatchers.content().string(emp))
										.andDo(MockMvcResultHandlers.print());*/
	}

	@Test
	public void	updateDetailsNullTest()	throws Exception
	{

		Employee emp = new Employee(123,"Sai","JFP","27k");
		//repo.findById(emp.getEmpid()).orElse(null);
		ObjectMapper mapper	=new ObjectMapper();
		when(repo.findById(emp.getEmpid()).orElse(null)).thenThrow(NoSuchEmployeeExistsException.class);
		mockMvc.perform(put("/updateNewEmployee",emp).contentType("application/json").content(mapper.writeValueAsString(emp)))
		.andDo(print()).andExpect(status().isNotFound());
	}
	@Test
	public void	updateDetailsTestFailed() throws Exception
	{
		Employee emp = new Employee(123,"Sai","JFP","27k");
		ObjectMapper mapper	=new ObjectMapper();
		when(service.updateNewEmployee(emp)).thenThrow(NoSuchEmployeeExistsException.class);
		mockMvc.perform(put("/updateNewEmployee",emp).contentType("application/json").content(mapper.writeValueAsString(emp)))
		.andDo(print()).andExpect(status().isNotFound());
	}

	@Test
	public void	updateEmployeeUsingPatchTest() throws Exception
	{
		Employee emp = new Employee(324,"Sai","DDD","27k");
		Map<String,Object>	value=new HashMap<String,Object>();
		value.put("dept","DDD");
		String request="{\"dept\": \"EDE\"}";
		ObjectMapper mapper =  new ObjectMapper();
		when(service.updatePatchEmployee(324,mapper.readValue(request,Map.class)))
		.thenReturn(emp);
		MockHttpServletRequestBuilder builder=MockMvcRequestBuilders.patch("/patchUpdateEmp/324")
				.contentType(MediaType.APPLICATION_JSON_VALUE).accept(MediaType.APPLICATION_JSON)								
				.characterEncoding("UTF-8").content(request);
		this.mockMvc.perform(builder).andExpect(MockMvcResultMatchers.status().isOk());
		/*.andExpect(MockMvcResultMatchers.content().string("updatedsuccessfully"))               
										.andDo(MockMvcResultHandlers.print());    */
	}
}

