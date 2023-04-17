package com.springrest.springrest;

import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entity.Employee;
import com.springrest.springrest.service.EmployeeServiceImpl;

import junit.framework.Assert;
@SpringBootTest
@ExtendWith(MockitoExtension.class)
class JUnitTesting {

	/*
	 * @Autowired private EmployeeServiceImpl EmpServImpl ;
	 */

@InjectMocks
private EmployeeServiceImpl EmpServImpl ;

@MockBean
private EmployeeDao repo;


	@SuppressWarnings("deprecation")
	@Test
	final void testGetEmployeesDetails() {
	
		List list=new ArrayList<>(); 
		list.add(new Employee(3324,"Balram","Technical Associate", null, null)); 
		list.add(new Employee(1024,"Sai","Senior Technical Associate", null, null)); 
		list.add(new Employee(2124,"Kishore","Technical Lead", null, null));
		when(repo.findAll()).thenReturn(list);
		Assert.assertEquals(2, EmpServImpl.getEmployeesDetails().size());
		
		}

	/*
	 * @Test final void testGetEmployeeDetail() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test final void testAddEmployeeDetail() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test final void testUpdateEmployeeDetail() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 * @Test final void testDeleteEmployeeDetail() { fail("Not yet implemented"); //
	 * TODO }
	 * 
	 
	 */
	

}
