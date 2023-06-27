package com.splitwise.splitapp.Services;

import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Service;

import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.User;

@Service
public class SplitByPercentageStrategyServiceImpl implements SplitStrategyService {
	 
	
	@Override
	public void calculateOwnedAmount(Expense expense,HashMap<Long, Double> percentage,List<User> participants) {
		Double totalAmount = expense.getTotalAmount();
		

		for(User participant : participants) {
			Double percentageShare =  percentage.get(participant.getUserId());
			Double amountOwned = (percentageShare*totalAmount)/100;
			expense.getAmountOwned().put(participant, amountOwned);
		}
	}

}
