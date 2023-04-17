package spring.example.junit.controller;

import com.fasterxml.jackson.databind.ObjectMapper;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.apache.http.client.HttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.assertj.core.api.Assertions;
import org.json.JSONObject;
import org.junit.Assert;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;
import spring.example.junit.entity.Employee;
import spring.example.junit.repository.EmployeeRepository;
import spring.example.junit.service.RestTemplateConfig;

import static org.apache.tomcat.util.net.SocketEvent.TIMEOUT;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.springframework.http.RequestEntity.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.net.URI;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
class EmployeeControllerTest {

@Autowired
	private WebApplicationContext webApplicationContext;

	private static MockMvc mockMvc;
	

	@BeforeEach
	public void setup()
	{
		if(mockMvc == null)
		{
			synchronized(EmployeeControllerTest.class) {
				if(mockMvc == null)
				{
					mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
				}
			}
		}


	}





	@Test
	@Order(3)
	void testGetEmployee() throws Exception {
		 mockMvc.perform(get("/getEmployeebyId/123"))
			.andExpect(status().isOk())
			.andExpect(jsonPath("$.name").value("JFP"));
	}

	@Test
	@DisplayName("Test Should Add the Employe Detail")
	@Order(1)
	void testAddEmployee() throws Exception {
		Employee emp = new Employee(123,"Sai","JFP","27k");
		ObjectMapper objMap = new ObjectMapper();
		String str= objMap.writeValueAsString(emp);
		MvcResult mvcResult = mockMvc.perform(post("/addEmployee").contentType(MediaType.APPLICATION_JSON).content(str)).andReturn();
		assertEquals(200,mvcResult.getResponse().getStatus());
		
	}

	@Test
	@DisplayName("Test Should Update the Employee Detail")
	@Order(2)
	void testUpdateEmployee() throws Exception {
		ObjectMapper objectMapper = new ObjectMapper();
		mockMvc.perform(MockMvcRequestBuilders.put("/updateEmployee")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(
						new Employee(345, "DDS", "Jai", "23k")))
		).andExpect(status().isOk());
	}
	@Test
	@Order(4)
	void testGetAllEmployees() throws Exception {
		TestRestTemplate template = new TestRestTemplate();
	    /*Test Get Employees using Test Rest Template @AutoWired*/
		String url = "http://localhost:9090/getAllSEmployees";
		UriComponents builder = UriComponentsBuilder.fromHttpUrl(url).build();
		HttpEntity<String> requestEntity = new HttpEntity<>(null, null);
		ResponseEntity<String> response1 = template.exchange(builder.toString(), HttpMethod.GET, requestEntity,
				String.class);
		System.out.println("response :: "+response1.getBody());
		assertEquals(HttpStatus.OK, response1.getStatusCode());

	}
	
	@Test
	@Order(5)
	void testGetAllEmployees1() throws Exception {
		/*Test Get Employees using mock mvc*/
	 mockMvc.perform(get("/getAllSEmployees"))
			.andExpect(status().isOk());
		
	}
	
	@Test
	@Order(6)
	void testGetAllEmployees2() throws Exception {
		
		/*Test Get Employees using TestRestTemplate*/
			TestRestTemplate template = new TestRestTemplate();
			ResponseEntity<?> response = template.getForEntity("http://localhost:9090/getAllSEmployees", ArrayList.class);
			assertEquals(HttpStatus.OK,response.getStatusCode());
		
	}
	
	@Test
	@Order(7)
	void testGetAllEmployees3() throws Exception {
		
		/*Test Get Employees using Rest Template*/
		 RestTemplate restTemplate = new RestTemplate();
		 String url = "http://localhost:9090/getAllSEmployees";
		Employee[] employees = restTemplate.getForObject(url, Employee[].class);
		System.out.println("employees in controller "+ employees.toString());
	    Assertions.assertThat(employees).extracting(Employee::getName);
		
	}


	@Test
	@Order(8)
	@DisplayName("Test Should Update patch of the Employee Detail")
	//@Disabled
	void testPatchEmployee() throws Exception {


		String url="http://localhost:9090/patchUpdateEmp/234";
		RestTemplate restTemplate = new RestTemplate();
		HttpClient httpClient = HttpClientBuilder.create().build();
		restTemplate.setRequestFactory(new
				HttpComponentsClientHttpRequestFactory(httpClient));
		HttpHeaders reqHeaders = new HttpHeaders();
		reqHeaders.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> requestEntity = new HttpEntity<String>("{\"dept\": \"EDE\", \"sal\": \"26k\" }", reqHeaders);
		ResponseEntity<String> responseEntity=restTemplate.exchange(url, HttpMethod.PATCH,
				requestEntity, String.class);
	}

	@Test
	@Order(9)
	//@Disabled
	public void deleteByIdTest() throws Exception {


		mockMvc.perform(MockMvcRequestBuilders.delete("/deleteEmployee/{empid}", 123)
				).andDo(print()).
				andExpect(status().isOk());



	}
	


}
