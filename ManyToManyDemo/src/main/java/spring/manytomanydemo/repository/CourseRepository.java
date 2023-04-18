package spring.manytomanydemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.manytomanydemo.entity.Course;

import java.util.List;

public interface CourseRepository extends JpaRepository<Course, Long> {

    List<Course> findByFeeLessThan(Double fee);
}
