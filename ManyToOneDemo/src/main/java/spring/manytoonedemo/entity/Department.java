package spring.manytoonedemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="DEPT_TBL")

public class Department {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long Id;
    private String project;
    private int account;

    private double salary;

//	@OneToMany(mappedBy="department",  cascade = {
//            CascadeType.PERSIST,
//            CascadeType.MERGE
//        },fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
    private Set<Employee> employees;

	public Long getId() {
		return Id;
	}

	public void setId(Long id) {
		Id = id;
	}

	public String getProject() {
		return project;
	}

	public void setProject(String project) {
		this.project = project;
	}

	public int getAccount() {
		return account;
	}

	public void setAccount(int account) {
		this.account = account;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Set<Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	@Override
	public String toString() {
		return "Department [Id=" + Id + ", project=" + project + ", account=" + account + ", salary=" + salary
				+ ", employees=" + employees + "]";
	}

	public Department(Long id, String project, int account, double salary, Set<Employee> employees) {
		super();
		Id = id;
		this.project = project;
		this.account = account;
		this.salary = salary;
		this.employees = employees;
	}

	public Department() {
		super();
		// TODO Auto-generated constructor stub
	}



}
