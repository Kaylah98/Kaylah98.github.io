package com.codingwithkaylah.model;
import org.springframework.data.mongodb.core.mapping.DBRef;


public abstract class Pet {


	@DBRef
	private Owner owner;
	private String firstName;
	private String breed;
	private int age;
	private int numOfDays;
	private boolean isDog;
	private double weight;
	private boolean isGroomed;
	
	public Pet() {}
	
	
	public Pet(Owner owner, String firstName, String breed, int age, int numOfDays, boolean isDog, double weight,
			boolean isGroomed) {
		super();
		this.owner = owner;
		this.firstName = firstName;
		this.breed = breed;
		this.age = age;
		this.numOfDays = numOfDays;
		this.isDog = isDog;
		this.weight = weight;
		this.isGroomed = isGroomed;
	}



	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}


	public Owner getOwner() {
		return owner;
	}

	public void setOwner(Owner owner) {
		this.owner = owner;
	}


	public int getNumOfDays() {
		return numOfDays;
	}

	public void setNumOfDays(int numOfDays) {
		this.numOfDays = numOfDays;
	}

	public boolean getIsDog() {
		return isDog;
	}

	public void setDog(boolean isDog) {
		this.isDog = isDog;
	}

	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	public boolean getIsGroomed() {
		return isGroomed;
	}

	public void setGroomed(boolean isGroomed) {
		this.isGroomed = isGroomed;
	}
	
	
	
}
