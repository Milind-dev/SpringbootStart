package com.milinddev.expensetrackerapi.service;

import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;

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
		return expenseRepo.findAll();
	}

	@Override
	public Expense getExpenseById(Long id) {
	   Optional<Expense> expense= expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		else {
			throw new RuntimeException("Expense is not found");
		}
	}

	@Override
	public void deleteExpenseById(Long id) {
		expenseRepo.deleteById(id);
	}
	
	
	@Override
	public Expense saveExpenseDetails(Expense expense) {
		return expenseRepo.save(expense);

	}

	@Override
	public Expense updateExpenseDetails(Long id, Expense expense) {
		// TODO Auto-generated method stub
		Expense existingExpense =  getExpenseById(id);
		existingExpense.setName(expense.getName() != null ? expense.getName():existingExpense.getName());
		existingExpense.setDescription(expense.getDescription() != null ? expense.getDescription() : existingExpense.getDescription());
		existingExpense.setCategory(expense.getCategory() != null ? expense.getCategory() : existingExpense.getCategory());
		existingExpense.setDate(expense.getDate() != null ? expense.getDate() : existingExpense.getDate());
		existingExpense.setAmount(expense.getAmount() != null ? expense.getAmount() : existingExpense.getAmount());
		return expenseRepo.save(existingExpense);
	}

}
