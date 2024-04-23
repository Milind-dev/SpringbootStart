package com.milinddev.expensetrackerapi.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milinddev.expensetrackerapi.entity.Expense;
import com.milinddev.expensetrackerapi.repository.ExpenseRepository;

//all business logic write on this class
@Service 
public class ExpenseServiceImpl implements ExpenseService {

	//here it inject expenses repo
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public List<Expense> getAllExpenses() {
		// TODO Auto-generated method stub
		return expenseRepo.findAll();
	}
	
	
}
