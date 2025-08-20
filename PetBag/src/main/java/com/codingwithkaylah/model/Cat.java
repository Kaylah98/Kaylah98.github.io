package com.codingwithkaylah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="cats")
public class Cat extends Pet{

	@Id
	private String id;
	
	public Cat(String firstName, String breed, int age, int numOfDays, Owner owner, 
			boolean isDog, boolean isGroomed, double weight) {
		super(owner, firstName, breed, age, numOfDays, isDog, weight,
				isGroomed);
		super.setGroomed(false); 
		
	}
	
	public Cat(String id, String firstName, String breed, int age, int numOfDays, Owner owner, 
			boolean isDog, boolean isGroomed, double weight) {
		super(owner, firstName, breed, age, numOfDays, isDog, weight,
				isGroomed);
		this.id = id;
		
	}
	
	public Cat() {}
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	};
	
	
	
	
}
