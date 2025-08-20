package com.codingwithkaylah.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="owners")
public class Owner {
	
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private boolean hasPaid;
	private boolean hasCheckedIn;
	private List<Pet> pets;
	
	
	
	public Owner(String firstName, String lastName, boolean hasPaid, boolean hasCheckedIn) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.hasPaid = hasPaid;
		this.hasCheckedIn = hasCheckedIn;
		
	}

	public Owner() {
		
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public boolean isHasPaid() {
		return hasPaid;
	}

	public void setHasPaid(boolean hasPaid) {
		this.hasPaid = hasPaid;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public boolean isHasCheckedIn() {
		return hasCheckedIn;
	}

	public void setHasCheckedIn(boolean hasCheckedIn) {
		this.hasCheckedIn = hasCheckedIn;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}
	
	
	
	
}
