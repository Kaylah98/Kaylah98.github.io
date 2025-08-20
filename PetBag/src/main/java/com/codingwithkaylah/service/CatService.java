package com.codingwithkaylah.service;


import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.codingwithkaylah.model.Cat;
import com.codingwithkaylah.model.Owner;
import com.codingwithkaylah.repository.CatRepository;
import com.codingwithkaylah.repository.OwnerRepository;

@Service
public class CatService {

	
			private CatRepository catRepository;
			private OwnerRepository ownerRepository;
			
			
			
	
			public CatService(CatRepository catRepository, OwnerRepository ownerRepository) {
				super();
				this.catRepository = catRepository;
				this.ownerRepository = ownerRepository;
			}




			// checks in cat, saves to database and returns success
			public boolean checkInCat(Cat cat) {
				
				Cat findCat = catRepository.findCatByFirstName(cat.getFirstName());
				Owner findOwner = ownerRepository.
					findByFirstNameAndLastName(cat.getOwner().getFirstName(), cat.getOwner().getLastName());
			
				// if no dog found, but owner in database
				if (findCat == null && findOwner != null) {
				
					findOwner.getPets().add(cat);
					findOwner.setHasCheckedIn(true);
					ownerRepository.save(findOwner);
					catRepository.save(cat);
					return true;
			}
			
				else if (findCat != null && findOwner != null) {
				
					return false;
			}
				else if (findCat == null && findOwner == null) {
				
					cat.getOwner().setHasCheckedIn(true);
					ownerRepository.save(cat.getOwner());
				
					catRepository.save(cat);
					return true;
				
			}
				return false;
				
				}
			
			// checks out cat, marks has paid as true and returns success or failure
			public boolean checkOutCat(String id, boolean groompet) {
					
				Optional<Cat> findCat = catRepository.findById(id);
					
					if (findCat.isPresent()) {
					Owner owner = findCat.get().getOwner();
					owner.setHasPaid(true);
					ownerRepository.save(owner);
					return true;
				}
				
				return false;
			}
			
			public boolean updateCat(Cat cat) {
				Optional<Cat> findCat = catRepository.findById(cat.getId());
			
				if (findCat.isPresent()) {
					findCat.get().setAge(cat.getAge());
					findCat.get().setBreed(cat.getBreed());
					findCat.get().setFirstName(cat.getFirstName());
					findCat.get().setGroomed(cat.getIsGroomed());
					catRepository.save(findCat.get());
					return true;
				}
				else {
					return false;
				}
			}
			
			// gets list of all cats
			public List<Cat> getAllCats() {
				
				return catRepository.findAll();
			}
			
			// delete cat from database
			public boolean deleteCat(String id) {
					
				Optional<Cat> cat = catRepository.findById(id);
					
				if (cat.isPresent()) {
					catRepository.deleteById(id);
					return true;
					}
				else {
					System.out.println("Cat is not present");
					return false;
					}

				}

}
