package spring.example.junit.service;

import spring.example.junit.entity.Dept;

import java.util.stream.Stream;

public interface DeptService {

    Stream<Dept> getDetails();
}
