package com.samplejunit.junitmockito.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Student {
	@Id
	private int stuid;
	
	private String section;
	private String name;
	private String grade;
	public Student(int stuid, String section, String name, String grade) {
		super();
		this.stuid = stuid;
		this.section = section;
		this.name = name;
		this.grade = grade;
	}
	public int getStuid() {
		return stuid;
	}
	public void setStuid(int stuid) {
		this.stuid = stuid;
	}
	public String getSection() {
		return section;
	}
	public void setSection(String section) {
		this.section = section;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	
	@Override
	public String toString() {
		return "Student [stuid=" + stuid + ", section=" + section + ", name=" + name + ", grade=" + grade + "]";
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
