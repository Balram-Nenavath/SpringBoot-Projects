package spring.example.junit.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.ArgumentMatchers.anyMap;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;

import org.json.JSONObject;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.runners.AllTests;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import spring.example.junit.entity.Employee;
import spring.example.junit.repository.EmployeeRepository;
@ExtendWith(MockitoExtension.class)
class EmployeeServiceTest {

	 @InjectMocks
	    EmployeeService service;
	 @Mock
	    EmployeeRepository empRepo;
	 List<Employee> list = new ArrayList<Employee>();

	 @Test
		@Order(1)
		void testAddEmployee() {

			 Employee employee =  new Employee(239,"CCE","Krishna", "27k");
	         
		        service.addEmployee(employee);
		          
		        verify(empRepo, times(1)).save(employee);
		}
	 
	//@Test
	//@DisplayName("Test Should get the Employe Detail")
	@RepeatedTest(value = 5,
    name = "Repeating Test Get Employee Creation Test {currentRepetition} of {totalRepetitions}")
	@Order(2)
	void testGetEmployeebyId() {
	
		Optional<Employee> emp1 = Optional.of(new Employee(232,"EEE","Abhi", "22k"));
      
		when(empRepo.findById(232)).thenReturn(emp1);
		Employee emp = service.getEmployee(232);
        
       assertEquals(emp1.get().getName(),emp.getName());
	}

	

	@Test
	@Order(3)
	void testGetAllEmployees() {
		Employee emp1 = new Employee(230,"CSE","Chinna", "25k");
		Employee emp2 = new Employee(232,"EEE","Abhi", "22k");
		Employee emp3 = new Employee(235,"ECE","Amrit", "23k");

		list.add(emp1);
		list.add(emp2);
		list.add(emp3);
        
		when(empRepo.findAll()).thenReturn(list);
		List<Employee> empList = service.getAllEmployees();
        
        assertEquals(3, empList.size());
        verify(empRepo, times(1)).findAll();
	}

	@Test
	@Order(4)
	void testUpdateEmployee() throws Exception {

		
		Employee employee = new Employee(235,"ECE","Amrit", "23k");
		given(empRepo.save(employee)).willReturn(employee);
		employee.setDept("EOE");
		employee.setName("Madhuri");
		Employee updatedEmployee = service.updateEmployee(employee);

		assertThat(updatedEmployee.getDept()).isEqualTo("EOE");
		assertThat(updatedEmployee.getName()).isEqualTo("Madhuri");
		System.out.println(" Updated employee"+ employee);
	}
	
	@Test
	@DisplayName("Test Should Patch Update the Employee Detail")
	@Order(5)
	void testPatchUpdateEmployee() throws Exception {
		/*
		 * Optional<Employee> employee = Optional.of(new Employee(235,"ECE","Amrit",
		 * "23k")); when(empRepo.findById(235)).thenReturn(employee); //Employee emp =
		 * new Employee(235,"EFE","Amrit", "23k"); Map<String, Object> hm= new
		 * HashMap<String, Object>(); hm.put("dept", "EFE"); Employee Result =
		 * service.updatePatchEmployee(235,hm);
		 * assertEquals(employee.get().getDept(),Result.getDept());
		 * 
		 * //assertThat(Result.getDept()).isEqualTo("EFE");
		 * //System.out.print("Updated patch employee"+ employee);
		 * //assertEquals(emp.getDept(), Result.getDept()); //verify(empRepo,
		 * times(1)).save(hm);
		 */
		
		 Optional<Employee> emp = Optional.of(new Employee(235,"ECE","Amrit", "23k"));
		 Employee empResp = new Employee(235, "ECE", "Madhu","23k");

		 when(empRepo.findById(235)).thenReturn(emp);
		 Map<String, Object> Map = new HashMap<String, Object>();
		 Map.put("name", "Madhu");
		 when(empRepo.save(any())).thenReturn(empResp);
		 Employee result = service.updatePatchEmployee(235, Map);
		 assertEquals("Madhu", result.getName());
		 }

	 @Test
	 void updatePartialDetailsTest_ElseCondition() {
		 Employee empResp = new Employee(235,"ECE","Amrit", "23k");
	 when(empRepo.findById(235)).thenReturn(Optional.empty());
	 Map<String, Object> testMap = new HashMap<String, Object>();
	 testMap.put("name", "Kishore");
	 Employee result = service.updatePatchEmployee(235, testMap);
	 assertNull(null, result);
	 verify(empRepo, times(0)).save(empResp);
	 }
	

	@Test
	@Order(6)
	public void deleteByIdTest() throws Exception {
		Optional<Employee> employee = Optional.of(new Employee(235,"ECE","Amrit", "23k"));
		//when(empRepo.findById(235)).thenReturn(employee);
		service.deleteEmployee(235);
		verify(empRepo, times(1)).deleteById(235);

	}
	
	@AfterEach
	public void tearDown() {
		System.out.println("Testing completed successfully");
		
	}
	
}
