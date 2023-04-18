package spring.manytomanydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.manytomanydemo.entity.Student;

import java.util.List;

public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findByNameContaining(String name);
}
