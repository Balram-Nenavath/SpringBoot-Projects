package spring.example.junit.service;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;
@Configuration
public class RestTemplateConfig {

	@Bean(name="airport")
	@Primary
	public RestTemplate restTemplateAirport(RestTemplateBuilder builder)
	{
		 return builder.setConnectTimeout(Duration.ofMinutes(2)).build();
		
	}
	
	
	
	  @Bean(name="covid")
	  public RestTemplate restTemplate(RestTemplateBuilder
	  builder)
	  { 
		  return builder.build(); 
		  }
	 
}
