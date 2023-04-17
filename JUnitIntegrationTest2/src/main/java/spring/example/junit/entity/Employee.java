package spring.example.junit.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="EMP_TBL")
public class Employee {
	
	@Id
	private Integer empid;
	private String name;
	private String dept;

	private String sal;
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ",  name=" + name + ",dept=" + dept + ", sal=" + sal + "]";
	}
	public Employee(Integer empid, String name, String dept, String sal) {
		super();
		this.empid = empid;
		this.name = name;
		this.dept = dept;
		this.sal = sal;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
