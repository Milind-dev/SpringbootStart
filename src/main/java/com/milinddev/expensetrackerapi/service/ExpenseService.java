package com.milinddev.expensetrackerapi.service;

import java.util.List;

import com.milinddev.expensetrackerapi.entity.Expense;

public interface ExpenseService {
	List<Expense> getAllExpenses();	
}
