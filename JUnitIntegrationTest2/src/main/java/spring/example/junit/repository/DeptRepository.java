package spring.example.junit.repository;

import org.springframework.data.repository.CrudRepository;
import spring.example.junit.entity.Dept;


public interface DeptRepository extends CrudRepository<Dept, Integer> {

}
