package com.codingwithkaylah.repository;

import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingwithkaylah.model.Dog;



public interface DogRepository extends MongoRepository<Dog, String>{
	
	
	Dog findDogByFirstName(String firstName);
	List<Dog> findAll();
}
