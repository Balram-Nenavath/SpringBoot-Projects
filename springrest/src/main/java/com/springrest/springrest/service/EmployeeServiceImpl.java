package com.springrest.springrest.service;


import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springrest.springrest.SpringrestApplication;
import com.springrest.springrest.dao.EmployeeDao;
import com.springrest.springrest.entity.Employee;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	@Autowired
	private EmployeeDao EmpDao;
	//List<Employee> list;
	public EmployeeServiceImpl()
	{
		/*
		 * list=new ArrayList<>(); 
		 * list.add(new Employee(3324,"Balram","Technical Associate")); 
		 * list.add(new Employee(1024,"Sai","Senior Technical Associate")); 
		 * list.add(new Employee(2124,"Kishore","Technical Lead"));
		 */
	}
	

	@Override
	public List<Employee> getEmployeesDetails() {
		// TODO Auto-generated method stub
		return EmpDao.findAll();
	}
	

	@Override
	public Employee getEmployeeDetail(long empId) {
		// TODO Auto-generated method stub
		/*
		 * Employee e=null;
		 *  for(Employee emp : list)
		 *   {
		 *    if(emp.getEmpid()==empId)
		 *     {
		 * e=emp; break; 
		 * }
		 *  }
		 */
		return (Employee) EmpDao.getOne(empId);
	}

	@Override
	public Employee addEmployeeDetail(Employee emp) {
		// TODO Auto-generated method stub
		//list.add(emp);
		EmpDao.save(emp);
		return emp;
	}


	@Override
	public Employee updateEmployeeDetail(Employee emp) {
		// TODO Auto-generated method stub
		/*
		 * list.forEach(e -> { if(e.getEmpid()==emp.getEmpid()) {
		 * e.setName(emp.getName()); e.setDesignation(emp.getDesignation()); } });
		 */
		EmpDao.save(emp);
	return emp;
	}
	

	
	
	@Override 
	public void deleteEmployeeDetail(long empId) { // TODO
	//	list = this.list.stream().filter(e->e.getEmpid()!=empId).collect(Collectors.toList());
	Employee entity=(Employee) EmpDao.getOne(empId);
	EmpDao.delete(entity);
	}
	 
	 

}
