package com.samplejunit.junitmockito.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.samplejunit.junitmockito.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Integer>{
    Optional<Student> findById(Integer stuid);

	List<Student> findByActiveFalse();

}
