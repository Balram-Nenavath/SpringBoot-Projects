package com.springrest.springrest.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
@Entity(name="someThing")
public class Employee {
	@Id
	private long empid;
	private String name;
	private String designation;
	public Employee(long empid, String name, String designation) {
		
		super();
		this.empid = empid;
		this.name = name;
		this.designation = designation;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", designation=" + designation + "]";
	}
	public long getEmpid() {
		return empid;
	}
	public void setEmpid(long empid) {
		this.empid = empid;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDesignation() {
		return designation;
	}
	public void setDesignation(String designation) {
		this.designation = designation;
	}

}
