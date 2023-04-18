package spring.manytomanydemo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import spring.manytomanydemo.entity.Course;
import spring.manytomanydemo.entity.Student;
import spring.manytomanydemo.repository.CourseRepository;
import spring.manytomanydemo.repository.StudentRepository;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/student/course")
public class StudentCourseController {

    @Autowired
    private StudentRepository studentRepo;

    @Autowired
    private CourseRepository courseRepo;

	
	  @PostMapping 
	  public Student saveStudentWithCourse(@RequestBody Student student)
	  { 
		  return studentRepo.save(student); 
	}
	 
    
//    @PostMapping("/Students")
//    public ResponseEntity<Student> createStudent(@RequestBody Student Student) {
//      Student _Student = studentRepo.save(new Student());
//      return new ResponseEntity<>(_Student, HttpStatus.CREATED);
//    }
	/*
	 * @GetMapping public List<Student> findAllStudents() { return
	 * studentRepo.findAll(); }
	 */
    
    
    @GetMapping("/Students")
    public ResponseEntity<List<Student>> getAllStudents(@RequestParam(required = false) String name) {
      List<Student> Students = new ArrayList<Student>();

      if (name == null)
        studentRepo.findAll().forEach(Students::add);
      else
    	  studentRepo.findByNameContaining(name).forEach(Students::add);

      if (Students.isEmpty()) {
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(Students, HttpStatus.OK);
    }
    

    @GetMapping("/{studentId}")
            public Student findStudent(@PathVariable Long studentId)
    {
        return studentRepo.findById(studentId).orElse(null);
    }


    @GetMapping("/find/{name}")
    public List<Student> findStudentContainingName(@PathVariable String name)
    {
        return studentRepo.findByNameContaining(name);
    }

    @GetMapping("/search/{price}")
    public List<Course> findCoursesLessThanFee(@PathVariable double price)
    {
        return courseRepo.findByFeeLessThan(price);
    }
}
