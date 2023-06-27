package com.splitwise.splitapp.Services;

import java.util.HashMap;
import java.util.List;

import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.User;

public interface SplitStrategyService {
	
	public void calculateOwnedAmount(Expense expense,HashMap<Long, Double> percentage,List<User> participants);

}
