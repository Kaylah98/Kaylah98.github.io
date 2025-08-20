package com.codingwithkaylah.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.codingwithkaylah.model.Cage;
import com.codingwithkaylah.service.CageService;

@RestController
@CrossOrigin("http://localhost:4200")
public class CageController {

	@Autowired
	private CageService cageService;
	
	// receives request and forwards to service class 
	@PutMapping("/clean")
	public ResponseEntity<String> cleanCage(@RequestBody Cage cage){
		boolean cageclean = cageService.cleanCage(cage);
		
		if (cageclean == true) {
			return  ResponseEntity.status(HttpStatus.ACCEPTED)
					.contentType(MediaType.TEXT_PLAIN).body("success!!!");
		}
		else {
			return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
					.contentType(MediaType.TEXT_PLAIN).body("failed");
		}
		
	}
	
	@PutMapping("/available")
	public ResponseEntity<String> cageReady(@RequestBody Cage cage){
		boolean isCageReady = cageService.cageReady(cage);
		
		if (isCageReady == true) {
			return new ResponseEntity<>("Cage is now ready!", HttpStatus.ACCEPTED);
		}
		else {
			return new ResponseEntity<>("Action failed", HttpStatus.BAD_REQUEST);
		}
		
	}
	
}
