package com.milinddev.expensetrackerapi.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;
import com.milinddev.expensetrackerapi.entity.exceptions.ItemAlreadyExistsException;
import com.milinddev.expensetrackerapi.entity.exceptions.ResourceNotFoundException;
import com.milinddev.expensetrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PasswordEncoder bcryptEncoder;
	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(UserModal user) {
		if(userRepository.existsByEmail(user.getEmail())) {
			throw new ItemAlreadyExistsException("email already exists");
		}
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		newUser.setPassword(bcryptEncoder.encode(newUser.getPassword()));
		return userRepository.save(newUser);
	}


	@Override
	public User readUser(Long id) {
		return userRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("user not found"+id));
	}

	@Override
	public User updateUser(UserModal user, Long id) {
//		User existingUser = new User(); //if i used on put then name will change but other are null
		User existingUser = readUser(id);
		existingUser.setName(user.getName() != null ? user.getName() : existingUser.getName());
		existingUser.setEmail(user.getEmail() != null ? user.getEmail() : existingUser.getEmail());
//		existingUser.setPassword(user.getPassword() != null ? user.getPassword() : existingUser.getPassword());
		existingUser.setPassword(user.getPassword() != null ? bcryptEncoder.encode(user.getPassword()) : existingUser.getPassword());
		existingUser.setAge(user.getAge() != null ? user.getAge() : existingUser.getAge());
		return userRepository.save(existingUser);
	}


	@Override
	public void deleteUser(Long id) {
		// TODO Auto-generated method stub
		User existingUser = readUser(id);
		userRepository.delete(existingUser);
	}
}
