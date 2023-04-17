package com.springrest.springrest.service;

import java.util.List;
import java.util.Set;

import com.springrest.springrest.entity.Employee;

public interface EmployeeService {

	
	public List<Employee> getEmployeesDetails();
	public Employee getEmployeeDetail(long empId);
	public Employee addEmployeeDetail(Employee emp);
	public Employee updateEmployeeDetail(Employee emp);
	public void deleteEmployeeDetail(long empId);
}
