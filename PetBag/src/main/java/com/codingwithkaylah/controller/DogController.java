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

import com.codingwithkaylah.model.Dog;
import com.codingwithkaylah.service.DogService;

@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
public class DogController {

	private DogService dogService;
	
	public DogController(DogService dogService) {
		this.dogService = dogService;
	}
	
		// checks in a dog and returns whether a success or not
		@PostMapping(value = "/checkindog", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<String> checkIn(@RequestBody Dog dog){
			
			boolean s = dogService.checkInDog(dog);
			
			if (s == true) {
				System.out.println("Success!!");
				return  ResponseEntity.status(HttpStatus.ACCEPTED)
						.contentType(MediaType.TEXT_PLAIN).body("success!!!");
				
			}
			else {
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.contentType(MediaType.TEXT_PLAIN).body("unable to check dog in");
			}
		}
		
		// returns all dogs
		@GetMapping(value ="/dogs", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<Dog> getAllDogs(){
			
			if (dogService.getAllDogs() == null) {
				return null;
			}
			return dogService.getAllDogs();
		}
	
		
		// checks pet out
		@PostMapping("/checkoutdog/{id}/{groompet}")
		public ResponseEntity<String> checkOut(@PathVariable String id, @PathVariable boolean groompet){
			boolean checkOutDog = dogService.checkOutDog(id, groompet);
			
			if (checkOutDog == true) {
				return new ResponseEntity<>("success", HttpStatus.ACCEPTED);
			}
			else {
				return new ResponseEntity<>("failed to check pet out", HttpStatus.BAD_REQUEST);
			}
		}
		
		// deletes pet
		@DeleteMapping("/deletedog/{id}")
		public ResponseEntity<String> deleteDog(@PathVariable String id){
			
			boolean s = dogService.deleteDog(id);
			
			if (s == true) {
				return  ResponseEntity.status(HttpStatus.ACCEPTED)
						.contentType(MediaType.TEXT_PLAIN).body(" has been successfully deleted.");
			}
			else {
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.contentType(MediaType.TEXT_PLAIN).body("Could not delete from database.");
			}
			
		}
		
		@PutMapping("/updatedog")
		public ResponseEntity<String> updateDog(@RequestBody Dog dog){
			
			boolean s = dogService.updateDog(dog);
			
			if (s == true) {
				return  ResponseEntity.status(HttpStatus.ACCEPTED)
						.contentType(MediaType.TEXT_PLAIN).body(" has been successfully updated.");
			}
			else {
				return  ResponseEntity.status(HttpStatus.BAD_REQUEST)
						.contentType(MediaType.TEXT_PLAIN).body("Could not update from database.");
			}
			
		}
}
