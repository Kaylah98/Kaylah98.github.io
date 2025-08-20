package com.codingwithkaylah.service;

import org.springframework.stereotype.Service;

import com.codingwithkaylah.model.Cage;
import com.codingwithkaylah.repository.CageRepository;

@Service
public class CageService {

	
	private CageRepository cageRepository;
	
	
	
	public CageService(CageRepository cageRepository) {
		super();
		this.cageRepository = cageRepository;
	}


	// finds cage in database and sets cage as not ready
	public boolean cleanCage(Cage cage) {
		Cage cageFound = cageRepository.findByCageNumber(cage.getCageNumber());
		
		if (cageFound == null) {
			return false;
		}
		cageFound.setCageReady(false);
		cageRepository.save(cageFound);
		return true;
	}
	
	// finds cage in database and updates whether it's ready
	public boolean cageReady(Cage cage) {
		Cage cageFound = cageRepository.findByCageNumber(cage.getCageNumber());
		
		if (cageFound == null) {
			return false;
		}
		cageFound.setCageReady(true);
		cageRepository.save(cageFound);
		return true;
	}
}
