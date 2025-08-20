/*
package com.codingwithkaylah.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.codingwithkaylah.repository.UserRepository;

@Service
public class UserService {

	
	private CustomUserDetailsService userDetailsService;
	
	
	
	public UserService(CustomUserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	public UserDetails login(String uname, String password) {
		UserDetails userDetails = userDetailsService.loadUserByUsername(uname);
		return userDetails;
		
	}
}

*/
