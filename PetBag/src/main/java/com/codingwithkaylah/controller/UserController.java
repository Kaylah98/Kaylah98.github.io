package com.codingwithkaylah.controller;
/*
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.codingwithkaylah.model.User;
import com.codingwithkaylah.service.UserService;

@Controller
@CrossOrigin(origins="http://localhost:4200")
public class UserController {
	
	
		private UserService userService;
		

		public UserController(UserService userService) {
			super();
			this.userService = userService;
		}


		// logs in the user or sends a not found error
		@PostMapping(value="/login", consumes = MediaType.APPLICATION_JSON_VALUE)
		public ResponseEntity<UserDetails> login(@RequestBody User user) {
			
			UserDetails s = userService.login(user.getUname(), user.getPassword());
			
			return  ResponseEntity.status(HttpStatus.ACCEPTED)
					.contentType(MediaType.TEXT_PLAIN).body(s);
			
		}
}

*/
