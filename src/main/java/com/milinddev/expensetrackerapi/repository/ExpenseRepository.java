package com.milinddev.expensetrackerapi.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.sql.Date;


import com.milinddev.expensetrackerapi.entity.Expense;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense,Long> {
	//select * from tbl_expenses where	category = ?
	Page<Expense> findByCategory(String category,Pageable page); 
	Page<Expense> findByNameContaining(String keyword,Pageable page);
	Page<Expense> findByDateBetween(Date start,Date end,Pageable page);
}
