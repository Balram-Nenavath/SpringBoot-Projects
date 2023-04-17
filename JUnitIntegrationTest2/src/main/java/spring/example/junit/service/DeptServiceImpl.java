package spring.example.junit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import spring.example.junit.entity.Dept;
import spring.example.junit.repository.DeptRepository;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

@Component
public class DeptServiceImpl  implements DeptService{

    private DeptRepository companyRepository;

    @Autowired
    public DeptServiceImpl(DeptRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public Stream<Dept> getDetails() {
        return StreamSupport.stream(companyRepository.findAll().spliterator(), true);
    }
}
