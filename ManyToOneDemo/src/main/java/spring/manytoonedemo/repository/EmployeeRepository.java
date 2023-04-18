package spring.manytoonedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import spring.manytoonedemo.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    List<Employee> findByNameContaining(String name);
}
