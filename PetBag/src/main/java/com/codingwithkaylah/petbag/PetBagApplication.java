package com.codingwithkaylah.petbag;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories(basePackages = "com.codingwithkaylah.repository")
@ComponentScan(basePackages = { "com.codingwithkaylah.model", "com.codingwithkaylah.security",
		"com.codingwithkaylah.service", "com.codingwithkaylah.controller"}
)
public class PetBagApplication {

	public static void main(String[] args) {
		SpringApplication.run(PetBagApplication.class, args);
	}

}
