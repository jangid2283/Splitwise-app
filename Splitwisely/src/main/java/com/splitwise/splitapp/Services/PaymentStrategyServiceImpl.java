package com.splitwise.splitapp.Services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.User;

@Service
public class PaymentStrategyServiceImpl implements PaymentStrategyService {

	@Override
	public void calculatePaidAmount(Expense expense,List<User>participants) {
		User payer = expense.getCreatedBy();
		// List<User> participants = expense.getParticipants();
		Double amountPaid = expense.getTotalAmount();
		for(User participant : participants) {
			if(participant.equals(payer)) {
				System.out.println("Payer is :"+payer.getUserName()+" "+amountPaid);
				
				expense.getAmountPaid().put(participant, amountPaid);
				System.out.println("Amount === "+expense.getAmountPaid().get(payer));
			}else {
				expense.getAmountPaid().put(participant, 0.0);
			}
		}
	}

}
