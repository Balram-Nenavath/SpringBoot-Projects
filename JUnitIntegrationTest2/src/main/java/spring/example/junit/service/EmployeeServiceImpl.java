package spring.example.junit.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.example.junit.entity.Employee;
import spring.example.junit.repository.EmployeeRepository;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeesRepository;

    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeesRepository) {
        this.employeesRepository = employeesRepository;
    }

    @Override
    public Stream<Employee> getAllEmployees() {
        return StreamSupport.stream(employeesRepository.findAll().spliterator(), true);
    }
}
