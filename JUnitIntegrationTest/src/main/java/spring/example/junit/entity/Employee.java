package spring.example.junit.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;


@Entity
@Table(name="EMP_TBL")
@ApiModel
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer empid;
	@NotBlank(message = "Dept is mandatory")
	private String dept;
	@NotNull(message = "Name cannot be null")
	private String name;
	//@Min(value = 20, message = "Age should not be less than 15")
	private String sal;

    @ApiModelProperty(position = 1, required = true, value = "1")
	public Integer getEmpid() {
		return empid;
	}
	public void setEmpid(Integer empid) {
		this.empid = empid;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", dept=" + dept + ", name=" + name + ", sal=" + sal + "]";
	}
	public Employee(Integer empid, String dept, String name, String sal) {
		super();
		this.empid = empid;
		this.dept = dept;
		this.name = name;
		this.sal = sal;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

}
