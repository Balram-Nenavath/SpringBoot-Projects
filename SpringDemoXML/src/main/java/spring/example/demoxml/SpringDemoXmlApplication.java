package spring.example.demoxml;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:Demo.xml")
public class SpringDemoXmlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDemoXmlApplication.class, args);
	}

}
