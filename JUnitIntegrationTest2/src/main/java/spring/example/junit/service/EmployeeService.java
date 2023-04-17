package spring.example.junit.service;

import spring.example.junit.entity.Employee;

import java.util.stream.Stream;

public interface EmployeeService {
	Stream<Employee> getAllEmployees();
}
