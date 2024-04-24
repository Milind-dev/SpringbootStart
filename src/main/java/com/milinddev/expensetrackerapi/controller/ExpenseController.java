package com.milinddev.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.milinddev.expensetrackerapi.entity.Expense;
import com.milinddev.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	 @Autowired
	 private ObjectMapper objectMapper; // Autowire ObjectMapper

	@Autowired
	private ExpenseService expenseService;
	
//	@GetMapping("/expenses")
//	public List<Expense> getAllExpenses() {
//		return expenseService.getAllExpenses();
//	}
	@GetMapping("/expenses")
	public Page<Expense> getAllExpenses(Pageable page) {
		return expenseService.getAllExpenses(page);
	}
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		return expenseService.getExpenseById(id);
	}
	@DeleteMapping("/expenses")
	public void deleteExpenseId(@RequestParam("id") Long id) {
		expenseService.deleteExpenseById(id);
	}

	@ResponseStatus(value=HttpStatus.CREATED)
	@PostMapping("/expenses")
	public Expense saveExpenseDetails(@RequestBody Expense expense) {
		return expenseService.saveExpenseDetails(expense);
	}
	@ResponseStatus(value=HttpStatus.NO_CONTENT)
	@PutMapping("/expenses/{id}")
	public Expense updateExpenseDetails(@RequestBody Expense expense, @PathVariable Long id) {
		return expenseService.updateExpenseDetails(id, expense);
	}
}
