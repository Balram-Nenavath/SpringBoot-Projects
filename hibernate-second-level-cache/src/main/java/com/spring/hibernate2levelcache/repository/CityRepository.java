package com.spring.hibernate2levelcache.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.hibernate2levelcache.entity.City;

@Repository
public interface CityRepository extends JpaRepository<City, Integer> {


}
