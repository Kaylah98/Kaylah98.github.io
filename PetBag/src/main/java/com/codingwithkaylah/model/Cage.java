package com.codingwithkaylah.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "cages")
public class Cage {
	@Id
	private int id;
	private int cageNumber;
	private boolean isCageReady;
	
	public Cage(int cageNumber, boolean isCageReady) {
		super();
		this.cageNumber = cageNumber;
		this.isCageReady = isCageReady;
	}

	public int getCageNumber() {
		return cageNumber;
	}

	public void setCageNumber(int cageNumber) {
		this.cageNumber = cageNumber;
	}

	public boolean isCageReady() {
		return isCageReady;
	}

	public void setCageReady(boolean isCageReady) {
		this.isCageReady = isCageReady;
	}
	
	
	
}
