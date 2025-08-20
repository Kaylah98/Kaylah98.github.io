package com.codingwithkaylah.service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;
import com.codingwithkaylah.model.Dog;
import com.codingwithkaylah.model.Owner;
import com.codingwithkaylah.repository.DogRepository;
import com.codingwithkaylah.repository.OwnerRepository;


@Service
public class DogService {
	
	private DogRepository dogRepository;
	private OwnerRepository ownerRepository;
	
	public DogService(DogRepository dogRepository, OwnerRepository ownerRepository) {
		super();
		this.dogRepository = dogRepository;
		this.ownerRepository = ownerRepository;
	}

	
		// checks in dog, saves to database and returns success
		public boolean checkInDog(Dog dog) {
			
			Dog findDog = dogRepository.findDogByFirstName(dog.getFirstName());
			Owner findOwner = ownerRepository.
				findByFirstNameAndLastName(dog.getOwner().getFirstName(), dog.getOwner().getLastName());
		
			// if no dog found, but owner in database
			if (findDog == null && findOwner != null) {
			
				findOwner.getPets().add(dog);
				findOwner.setHasCheckedIn(true);
				ownerRepository.save(findOwner);
				dogRepository.save(dog);
				return true;
		}
		
			else if (findDog != null && findOwner != null) {
			
				return false;
		}
			else if (findDog == null && findOwner == null) {
			
				dog.getOwner().setHasCheckedIn(true);
				ownerRepository.save(dog.getOwner());
				dogRepository.save(dog);
				return true;
			
		}
			return false;
			
			}
		
		// gets list of all dogs
		public List<Dog> getAllDogs() {
			
			return dogRepository.findAll();
		}
		
		
		// checks out dog, marks has paid as true and returns success or failure
		public boolean checkOutDog(String id, boolean groompet) {
			
				Optional<Dog> findDog = dogRepository.findById(id);
				
				if (findDog.isPresent()) {
				Owner owner = findDog.get().getOwner();
				owner.setHasPaid(true);
				ownerRepository.save(owner);
				return true;
			}
			
			return false;
		}
		
		// delete dog from database
		public boolean deleteDog(String id) {
				
				Optional<Dog> dog = dogRepository.findById(id);
				
				if (dog.isPresent()) {
					dogRepository.deleteById(id);
					return true;
				}
				else {
					System.out.println("Dog is not present");
					return false;
				}
			
				
			}
		
		// updates existing dog
		public boolean updateDog(Dog dog) {
			
			Optional<Dog> findDog = dogRepository.findById(dog.getId());
			
			if (findDog.isPresent()) {
				findDog.get().setAge(dog.getAge());
				findDog.get().setBreed(dog.getBreed());
				findDog.get().setFirstName(dog.getFirstName());
				findDog.get().setGroomed(dog.getIsGroomed());
				dogRepository.save(findDog.get());
				return true;
			}
			else {
				return false;
			}
		}
		
}
