package com.springrest.springrest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
@SpringBootApplication
@EnableResourceServer
public class SpringrestApplication {

	public static void main(String[] args) {
		Logger logger = LogManager.getLogger(SpringrestApplication.class);
		System.setProperty("logfile", "C:\\Users\\bnenavath\\Documents\\workspace-spring-tool-suite-4-4.13.1.RELEASE\\springrest");
		logger.info("Hello ---- > Spring boot application is starting");
		
		SpringApplication.run(SpringrestApplication.class, args);
		
	}

}
