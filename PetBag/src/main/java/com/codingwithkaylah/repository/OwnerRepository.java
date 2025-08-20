package com.codingwithkaylah.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.codingwithkaylah.model.Owner;



public interface OwnerRepository extends MongoRepository<Owner, String> {
		public Owner findByFirstNameAndLastName(String firstName, String lastName);
}
