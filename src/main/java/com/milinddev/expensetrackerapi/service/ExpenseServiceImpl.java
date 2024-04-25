package com.milinddev.expensetrackerapi.service;

import java.sql.Date;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

import javax.management.RuntimeErrorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.milinddev.expensetrackerapi.entity.Expense;
import com.milinddev.expensetrackerapi.entity.exceptions.ResourceNotFoundException;
import com.milinddev.expensetrackerapi.repository.ExpenseRepository;

//all business logic write on this class
@Service
public class ExpenseServiceImpl implements ExpenseService {

	//here it inject expenses repo
	@Autowired
	private ExpenseRepository expenseRepo;
	
	@Override
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseRepo.findAll(page);
	}


	@Override
	public Expense getExpenseById(Long id) {
	   Optional<Expense> expense= expenseRepo.findById(id);
		if(expense.isPresent()) {
			return expense.get();
		}
		throw new ResourceNotFoundException("Expense  not found for this id " + id); 
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


	@Override
	public List<Expense> readByCategory(String category, Pageable page) {
		return  expenseRepo.findByCategory(category, page).toList();
	}


	@Override
	public List<Expense> findByNameContaining(String keyword, Pageable page) {
		// TODO Auto-generated method stub
		return expenseRepo.findByNameContaining(keyword, page).toList();		
	}


	@Override
	public List<Expense> readByDate(Date startDate, Date endDate, Pageable page) {
		
			if(startDate == null) {
				startDate = new Date(0); 
			}
			if(endDate == null) {
				endDate = new Date(System.currentTimeMillis());
			}
		return expenseRepo.findByDateBetween(startDate, endDate, page).toList();
	}

}
