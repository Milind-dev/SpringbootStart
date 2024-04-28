package com.milinddev.expensetrackerapi.service;

import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;

public interface UserService {
	User createUser(UserModal user);
	User readUser(Long id);
	User updateUser(UserModal user,Long id);
	void deleteUser(Long id);


}
