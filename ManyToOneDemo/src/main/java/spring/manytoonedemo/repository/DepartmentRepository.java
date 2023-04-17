package spring.manytoonedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.manytoonedemo.entity.Department;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department, Long> {

    List<Department> findBySalaryLessThan(Double salary);
}
