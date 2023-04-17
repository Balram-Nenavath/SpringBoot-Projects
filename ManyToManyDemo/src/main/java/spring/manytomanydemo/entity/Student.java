package spring.manytomanydemo.entity;

import java.util.Set;

import jakarta.persistence.*;

@Entity
@Table(name="STUDENT_TBL")
public class Student {
	
	@jakarta.persistence.Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long Id;
	private String name;
	private int age;
	private String dept;
	@ManyToMany(fetch = FetchType.LAZY, cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        })
	@JoinTable(name="STUDENT_COURSE", joinColumns= {
			@JoinColumn(name="student_id", referencedColumnName="id")
	},
			inverseJoinColumns= {
					@JoinColumn(name="course_id", referencedColumnName="id")
			}
	)
	private Set<Course> courses;
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
	public Set<Course> getCourses() {
		return courses;
	}
	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
	@Override
	public String toString() {
		return "Student [Id=" + Id + ", name=" + name + ", age=" + age + ", dept=" + dept + ", courses=" + courses
				+ "]";
	}
	public Student(Long id, String name, int age, String dept, Set<Course> courses) {
		super();
		Id = id;
		this.name = name;
		this.age = age;
		this.dept = dept;
		this.courses = courses;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	
//	public void addCourse(Course course) {
//	    this.courses.add(course);
//	    course.getStudents().add(this);
//	  }
//	  
//	  public void removeCourse(long courseId) {
//	    Course course = this.courses.stream().filter(t -> t.getId() == courseId).findFirst().orElse(null);
//	    if (course != null) {
//	      this.courses.remove(course);
//	      course.getStudents().remove(this);
//	    }
//	  }

}
