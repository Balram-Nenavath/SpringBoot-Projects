package com.spring.hibernate2levelcache.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.spring.hibernate2levelcache.entity.City;
import com.spring.hibernate2levelcache.service.CityService;

@RestController
public class CityController {

    @Autowired
    private CityService cityService;

    @GetMapping("/cities/{id}")
    public ResponseEntity<City> getCityById(@PathVariable(name = "id") Integer id){
        return new ResponseEntity<>(cityService.getCityById(id), HttpStatus.OK);
    }

    @PostMapping("/cities")
    public ResponseEntity<City> saveCity(@RequestBody City city){
        return new ResponseEntity<>(cityService.saveCity(city), HttpStatus.CREATED);
    }
}
