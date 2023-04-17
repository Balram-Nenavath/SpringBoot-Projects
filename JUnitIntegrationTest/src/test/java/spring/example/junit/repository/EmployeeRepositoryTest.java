package spring.example.junit.repository;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit.jupiter.SpringExtension;


import spring.example.junit.entity.Employee;
@ExtendWith(SpringExtension.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class EmployeeRepositoryTest {

	
	 @Autowired
	  EmployeeRepository employeeRepository;
	 
	@Test
	void testFindByIdInteger() {
		Iterable<Employee> employees = employeeRepository.findAll();    
	    Assertions.assertThat(employees).extracting(Employee::getName);
	    System.out.println("size :: "+ employeeRepository.findAll().size());
	}

	@Test
	@Rollback(false)
	public void SaveEmployee()
	{
		Employee employee = new Employee(235,"ECE","Amrit", "23k");
		employeeRepository.save(employee);
	}

}
