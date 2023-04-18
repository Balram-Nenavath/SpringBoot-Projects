package com.openfeign.serviceA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.openfeign.serviceA.entity.Demo;

public interface DemoRepository extends JpaRepository<Demo, Long> {

}
