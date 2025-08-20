package com.codingwithkaylah.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.codingwithkaylah.model.Cat;
import com.codingwithkaylah.service.CatService;



@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class CatController {

	
		private CatService catService;
		
		
	public CatController(CatService catService) {
			super();
			this.catService = catService;
		}


			// checks in a cat and returns whether a success or not
			@PostMapping(value = "/checkincat", consumes = MediaType.APPLICATION_JSON_VALUE)
			public ResponseEntity<String> checkIn(@RequestBody Cat cat){
				
				boolean s = catService.checkInCat(cat);
				
				if (s == true) {
					System.out.println("Success!!");
					return  ResponseEntity.status(HttpStatus.ACCEPTED)
							.contentType(MediaType.TEXT_PLAIN).body("success!!!");
					
				}
				else {
					return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("failed..");
				}
			}
			
			// returns all cats
			@GetMapping(value ="/cats", produces = MediaType.APPLICATION_JSON_VALUE)
			public List<Cat> getAllCats(){
				
				if (catService.getAllCats() == null) {
					return null;
				}
				return catService.getAllCats();
			}
			
			// checks cat out
			@PostMapping("/checkoutcat/{id}/{groompet}")
			public ResponseEntity<String> checkOut(@PathVariable String id, @PathVariable boolean groompet){
				boolean checkOutCat = catService.checkOutCat(id, groompet);
				
				if (checkOutCat == true) {
					return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
				}
				else {
					return new ResponseEntity<>("failed to check cat out", HttpStatus.BAD_REQUEST);
				}
			}
			
			// updates cat
			@PutMapping("/updatecat")
			public ResponseEntity<String> updateCat(@RequestBody Cat cat){
				
				boolean s = catService.updateCat(cat);
				
				if (s == true) {
					return  ResponseEntity.status(HttpStatus.ACCEPTED)
							.contentType(MediaType.TEXT_PLAIN).body(" has been successfully updated.");
				}
				else {
					return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.contentType(MediaType.TEXT_PLAIN).body("Could not update from database.");
				}
				
			}
			
			// deletes cat
			@DeleteMapping("/deletecat/{id}")
			public ResponseEntity<String> deleteCat(@PathVariable String id){
				
				boolean s = catService.deleteCat(id);
				
				if (s == true) {
					return  ResponseEntity.status(HttpStatus.ACCEPTED)
							.contentType(MediaType.TEXT_PLAIN).body(" has been successfully deleted.");
				}
				else {
					return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
							.contentType(MediaType.TEXT_PLAIN).body("Could not delete from database.");
				}
				
			}
}
