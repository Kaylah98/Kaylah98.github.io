package com.codingwithkaylah.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingwithkaylah.model.Cat;


public interface CatRepository extends MongoRepository<Cat, String>{

	Cat findCatByFirstName(String firstName);
	List<Cat> findAll();
}
