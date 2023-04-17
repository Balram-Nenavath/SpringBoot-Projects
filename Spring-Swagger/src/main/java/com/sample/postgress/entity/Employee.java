package com.sample.postgress.entity;

import java.util.Objects;

public class Employee {

	@Override
	public int hashCode() {
		return Objects.hash(employeeAddress, employeeEmail, employeeId, employeeName);
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
		return Objects.equals(employeeAddress, other.employeeAddress)
				&& Objects.equals(employeeEmail, other.employeeEmail) && Objects.equals(employeeId, other.employeeId)
				&& Objects.equals(employeeName, other.employeeName);
	}
	String employeeId;
	String employeeName;
	String employeeEmail;
	String employeeAddress;
	
	
	public String getEmployeeEmail() {
		return employeeEmail;
	}
	public void setEmployeeEmail(String employeeEmail) {
		this.employeeEmail = employeeEmail;
	}
	public String getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(String employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeAddress() {
		return employeeAddress;
	}
	public void setEmployeeAddress(String employeeAddress) {
		this.employeeAddress = employeeAddress;
	}
	
	
}
