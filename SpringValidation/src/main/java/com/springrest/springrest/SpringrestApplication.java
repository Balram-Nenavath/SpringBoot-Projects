package com.springrest.springrest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SpringrestApplication {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(SpringrestApplication.class);
		System.setProperty("logfile", "C:\\Users\\bnenavath\\Desktop\\db");
		logger.info("Hello ---- > Spring boot application is starting");
		
		SpringApplication.run(SpringrestApplication.class, args);
		
	}

}
