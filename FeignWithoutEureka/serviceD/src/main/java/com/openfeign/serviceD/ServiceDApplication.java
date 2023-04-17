package com.openfeign.serviceD;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients("com.openfeign.serviceD")
public class ServiceDApplication {

	public static void main(String[] args) {
		SpringApplication.run(ServiceDApplication.class, args);
	}

}
