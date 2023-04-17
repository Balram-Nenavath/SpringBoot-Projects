package com.samplejunit.junitmockito;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.RunWith;
import org.junit.runner.notification.Failure;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.samplejunit.junitmockito.controller.StudentController;
import com.samplejunit.junitmockito.entity.Student;

@RunWith(SpringRunner.class)
@SpringBootTest //(webEnvironment= WebEnvironment.RANDOM_PORT)
class SampleJUnitController {

//Integration test could be done using MockMVC and TestRestTemplate

	@Autowired
	private WebApplicationContext webApplicationContext;
	
	private static MockMvc mockMvc;
	
	@Autowired
	private TestRestTemplate template;
	
	@BeforeEach
	public void setup()
	{
		if(mockMvc == null)
		{
			synchronized(SampleJUnitController.class) {
				if(mockMvc == null)
				{
					mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
				}
			}
		}
	}
	
	@Test 
	public void testGetStudent() throws Exception {
	 mockMvc.perform(get("/studentapi/getStudentbyId/101"))
		.andExpect(status().isOk())
		.andExpect(jsonPath("$.name").value("Meenakshi"));
		
	}

	@Test
	public void testAddStudent() throws Exception
	{
		Student student = new Student(232,"Gamma","Sai Prasanna","Marvelous");
		ObjectMapper objMap = new ObjectMapper();
		String str= objMap.writeValueAsString(student);
		MvcResult mvcResult = mockMvc.perform(post("/studentapi/addStudent").contentType(MediaType.APPLICATION_JSON).content(str)).andReturn();
		assertEquals(200,mvcResult.getResponse().getStatus());
		
	}
	
	
/*	@Test
	public void testGetStudentwithRest() throws Exception {
		ResponseEntity<?> response = template.getForEntity("/getAllStudents", ArrayList.class);
		assertEquals(HttpStatus.OK,response.getStatusCode());
	}*/

	

}
