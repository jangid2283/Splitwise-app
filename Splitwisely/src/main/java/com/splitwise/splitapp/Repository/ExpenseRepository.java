package com.splitwise.splitapp.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.splitwise.splitapp.Models.Expense;

public interface ExpenseRepository extends JpaRepository<Expense,Long> {

}