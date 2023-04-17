package com.springrest.springrest.entity;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.springrest.springrest.validation.ValidateEmployeeType;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="someThing")
public class Employee {
	@Id
	private long empid;
	@NotBlank(message = "Name shouldn't be null or empty")
	private String name;
	@Email(message = "Invalid email id")
	String employeeEmail;
	@NotNull(message = "designation shouldn't be null")
    @NotEmpty(message = "designation shouldn't be empty")
	private String designation;

	 //custom annotation
    @ValidateEmployeeType
    private String employeeType; //permanent or contract

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

	public String getEmployeeEmail() {
		return employeeEmail;
	}

	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	@Override
	public int hashCode() {
		return Objects.hash(designation, empid, employeeEmail, employeeType, name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(designation, other.designation) && empid == other.empid
				&& Objects.equals(employeeEmail, other.employeeEmail)
				&& Objects.equals(employeeType, other.employeeType) && Objects.equals(name, other.name);
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", employeeEmail=" + employeeEmail + ", designation="
				+ designation + ", employeeType=" + employeeType + "]";
	}

	public Employee(long empid, @NotBlank(message = "Name shouldn't be null or empty") String name,
			@Email(message = "invalid email id") String employeeEmail,
			@NotNull(message = "department shouldn't be null") @NotEmpty(message = "department shouldn't be empty") String designation,
			String employeeType) {
		super();
		this.empid = empid;
		this.name = name;
		this.employeeEmail = employeeEmail;
		this.designation = designation;
		this.employeeType = employeeType;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
