package com.milinddev.expensetrackerapi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.milinddev.expensetrackerapi.entity.Expense;
import com.milinddev.expensetrackerapi.service.ExpenseService;

@RestController
public class ExpenseController {
	
	@Autowired
	private ExpenseService expenseService;
	
	@GetMapping("/expenses")
	public List<Expense> getAllExpenses() {
		return expenseService.getAllExpenses();
	}
//	@GetMapping("/expenses/{id}")
//	public String getExpenseById(@PathVariable("id") Long id) {
//		return "The Expense Id is " + id;
//	}
	@GetMapping("/expenses/{id}")
	public Expense getExpenseById(@PathVariable("id") Long id) {
		return expenseService.getExpenseById(id);
	}
//	@DeleteMapping("/expenses")
//	public String deleteExpenseId(@RequestParam("id") Long id) {
//		return "delete expense id " + id;
//	}
	@DeleteMapping("/expenses")
	public void deleteExpenseId(@RequestParam("id") Long id) {
		expenseService.deleteExpenseById(id);
	}
}
