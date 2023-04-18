package com.orderManagement.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.orderManagement.demo.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
