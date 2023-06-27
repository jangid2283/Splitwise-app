package com.splitwise.splitapp.Services;

import java.util.List;

import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.User;

public interface PaymentStrategyService {
	public void calculatePaidAmount(Expense expense,List<User> participants);
}
