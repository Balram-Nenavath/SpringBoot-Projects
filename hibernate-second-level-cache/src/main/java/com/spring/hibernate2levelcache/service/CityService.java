package com.spring.hibernate2levelcache.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.hibernate2levelcache.entity.City;
import com.spring.hibernate2levelcache.repository.CityRepository;

@Service
public class CityService {
	
    @Autowired
    private CityRepository cityRepository;

    public City getCityById(Integer id){
    	
    	
        City str = cityRepository.findById(id).get();
        
        System.out.println("Response from repo layer :"+ str.toString());
    	return str;
        
    }

    public City saveCity(City city){
        return cityRepository.save(city);
    }
}
