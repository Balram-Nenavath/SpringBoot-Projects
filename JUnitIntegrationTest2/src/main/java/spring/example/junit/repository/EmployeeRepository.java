package spring.example.junit.repository;

import org.springframework.data.repository.CrudRepository;
import spring.example.junit.entity.Employee;
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {

}
