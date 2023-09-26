package com.revature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDemoApplication {

	public static void main(String[] args) {
		// the 'run' method is a Static method in the 'SpringApplication' class, which will run our Spring Boot App
		SpringApplication.run(SpringDemoApplication.class, args);
	}

}
