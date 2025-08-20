package com.codingwithkaylah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingwithkaylah.model.Cage;


public interface CageRepository extends MongoRepository<Cage, Integer>{
		Cage findByCageNumber(int value);
}
