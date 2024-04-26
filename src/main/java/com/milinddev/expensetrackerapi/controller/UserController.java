package com.milinddev.expensetrackerapi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;
import com.milinddev.expensetrackerapi.service.UserService;

import jakarta.validation.Valid;

@RestController
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping("/register")
	public ResponseEntity<User> save(@Valid @RequestBody UserModal user) {
			return new ResponseEntity<User>(userService.createUser(user),HttpStatus.CREATED);
	}
}
