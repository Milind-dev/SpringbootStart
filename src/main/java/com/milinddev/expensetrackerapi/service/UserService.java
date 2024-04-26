package com.milinddev.expensetrackerapi.service;

import com.milinddev.expensetrackerapi.entity.User;
import com.milinddev.expensetrackerapi.entity.UserModal;

public interface UserService {
	User createUser(UserModal user);
}
