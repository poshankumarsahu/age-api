package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgeApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgeApiApplication.class, args);
		System.out.println("Running Age API");
	}

}
