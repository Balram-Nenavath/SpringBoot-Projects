package spring.manytoonedemo.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="STUDENT_TBL")
public class Employee {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private int age;
	private String dept;
	@ManyToOne(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
//	@JoinTable(name="STUDENT_COURSE", joinColumns= {
			@JoinColumn(name="student_id", referencedColumnName="id")
//	},
//			inverseJoinColumns= {
//					@JoinColumn(name="course_id", referencedColumnName="id")
//			}
//	)
	private Set<Department> departments;
	public Long getId() {
		return Id;
	}
	public void setId(Long id) {
		Id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public Set<Department> getCourses() {
		return departments;
	}
	public void setCourses(Set<Department> departments) {
		this.departments = departments;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + Id + ", name=" + name + ", age=" + age + ", dept=" + dept + ", departments=" + departments
				+ "]";
	}
	public Employee(Long id, String name, int age, String dept, Set<Department> departments) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.departments = departments;
	}
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public void addCourse(Department course) {
//	    this.courses.add(course);
//	    course.getStudents().add(this);
//	  }
//	  
//	  public void removeCourse(long courseId) {
//	    Department course = this.courses.stream().filter(t -> t.getId() == courseId).findFirst().orElse(null);
//	    if (course != null) {
//	      this.courses.remove(course);
//	      course.getStudents().remove(this);
//	    }
//	  }

}
