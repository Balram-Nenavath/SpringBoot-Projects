package spring.manytomanydemo.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name="COURSE_TBL")

public class Course {
    @jakarta.persistence.Id
    @GeneratedValue
    private Long Id;
    private String title;
    private int module;

    private double fee;


    @ManyToMany(mappedBy="courses",  cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
        },fetch = FetchType.LAZY)
    //@JsonBackReference
    @JsonIgnore
    private Set<Student> students;


	public Long getId() {
		return Id;
	}


	public void setId(Long id) {
		Id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public int getModule() {
		return module;
	}


	public void setModule(int module) {
		this.module = module;
	}


	public double getFee() {
		return fee;
	}


	public void setFee(double fee) {
		this.fee = fee;
	}


	public Set<Student> getStudents() {
		return students;
	}


	public void setStudents(Set<Student> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Course [Id=" + Id + ", title=" + title + ", module=" + module + ", fee=" + fee + ", students="
				+ students + "]";
	}


	public Course(Long id, String title, int module, double fee, Set<Student> students) {
		super();
		Id = id;
		this.title = title;
		this.module = module;
		this.fee = fee;
		this.students = students;
	}


	public Course() {
		super();
		// TODO Auto-generated constructor stub
	}

}
