package com.spring.multithreading.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.spring.multithreading.demo.entity.User;

public interface UserRepository extends JpaRepository<User,Integer> {
}
