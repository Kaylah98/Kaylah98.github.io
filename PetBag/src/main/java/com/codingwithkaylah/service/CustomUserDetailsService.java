package com.codingwithkaylah.service;
/*
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import com.codingwithkaylah.model.User;
import com.codingwithkaylah.repository.UserRepository;

public class CustomUserDetailsService implements UserDetailsService {

	private UserRepository userRepository;
	
	
	
	public CustomUserDetailsService(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
			
		User findUser = userRepository.findByUsername(username);
		
		if (findUser == null) {
			throw new UsernameNotFoundException("could not be found");
		}
		
		return org.springframework.security.core.userdetails.User.builder().username(username)
				.password(findUser.getPassword()).authorities("DEFAULT").build();
	}

}

*/