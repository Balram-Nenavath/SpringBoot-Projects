package com.orderManagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.demo.entity.Demo;
import com.orderManagement.service.IDemoService;

@RestController
public class DemoController {
	@Autowired
	IDemoService demoService;

	@GetMapping("/demo")
	public ResponseEntity<?> getAllDemoItems() {
		List<Demo> demoItems = demoService.getAll();
		if (CollectionUtils.isEmpty(demoItems) && demoItems.isEmpty()) {
			return new ResponseEntity<String>("no record found", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<List<Demo>>(demoItems, HttpStatus.OK);
		}
	}
}
