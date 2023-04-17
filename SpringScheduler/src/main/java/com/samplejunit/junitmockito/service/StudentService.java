package com.samplejunit.junitmockito.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.samplejunit.junitmockito.entity.Student;
import com.samplejunit.junitmockito.repository.StudentRepo;
@Service
public class StudentService {

	@Autowired
	StudentRepo repo;
	  private static final Logger logger = LoggerFactory.getLogger(StudentService.class);



    public Student getStudent(int stuid)
	{
		logger.info("Fetching GetStudent value with id : "+ repo.findById(stuid).get().toString());
		return repo.findById(stuid).get();
		
	}
	public Student addStudent(Student student)
	{
		logger.info("Added student detail and saved.");
		return repo.save(student);
	}
	
	 public List<Student> getAllStudents()
		{
			logger.info("Fetching All students : ");
			return repo.findAll();
			
		}
	
}
