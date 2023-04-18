package com.openfeign.serviceA.controller;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.openfeign.serviceA.entity.Demo;
import com.openfeign.serviceA.service.IDemoService;

@RestController
public class DemoController {
	
	@Autowired
	IDemoService demoService;
	
	@GetMapping("/demo")
	public ResponseEntity<?> getAllDetails(){
		List<Demo> demos=demoService.getAllDemo();
		if(!demos.isEmpty()&& demos!=null && !CollectionUtils.isEmpty(demos)) {
			return new ResponseEntity<List<Demo>>(demos,HttpStatus.OK);
		}else {
			return new ResponseEntity<>("no data found",HttpStatus.NO_CONTENT);
		}
	}
	
//	@GetMapping("/demo/{id}")
//	public ResponseEntity<?> getDetailsById(@PathVariable("id") Long id){
//		Demo demos=demoService.getDemoById(id);
//		if( demos!=null && !ObjectUtils.isEmpty(demos)) {
//			return new ResponseEntity<Demo>(demos,HttpStatus.OK);
//		}else {
//			return new ResponseEntity<>("no data found",HttpStatus.NO_CONTENT);
//		}
//	}
}
