package com.milinddev.expensetrackerapi.service;


import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;
import com.milinddev.expensetrackerapi.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository userRepository;
	
	@Override
	public User createUser(UserModal user) {
		// TODO Auto-generated method stub
		User newUser = new User();
		BeanUtils.copyProperties(user, newUser);
		return userRepository.save(newUser);
	}

}
