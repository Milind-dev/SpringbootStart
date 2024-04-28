package com.milinddev.expensetrackerapi.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milinddev.expensetrackerapi.entity.AuthModel;
import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;
import com.milinddev.expensetrackerapi.service.UserService;

import jakarta.validation.Valid;

@RestController
public class AutoController {
	
	   @Autowired
	   private AuthenticationManager authenticationManager;
	
		@Autowired
		private UserService userService;
	
//	    @PostMapping("/login")
//	       public ResponseEntity<String> login(){
//	    	return new ResponseEntity<String>("User log in",HttpStatus.OK);
//	      }

	    @PostMapping("/login")
	       public ResponseEntity<HttpStatus> login(@RequestBody AuthModel authModel ){
	    	//-------user module------
	    	Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authModel.getEmail(), authModel.getPassword()));
			SecurityContextHolder.getContext().setAuthentication(authentication);
			//------------------------//
			return new ResponseEntity<HttpStatus>(HttpStatus.OK);
	      }
	    
	    @PostMapping("/register")
	  	public ResponseEntity<User> save(@Valid @RequestBody UserModal user) {
	  			return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	  	}
  	
      
}
