package com.splitwise.splitapp.Services;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.User;
import com.splitwise.splitapp.Models.Dto.ExpenseDto;
import com.splitwise.splitapp.Repository.ExpenseRepository;
import com.splitwise.splitapp.Repository.UserRepository;

@Service
public class CreateExpenseWithOtherUserServiceImpl implements CreateExpenseWithOtherUserService{

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SplitStrategyService splitStrategyService;

    @Autowired
    private PaymentStrategyService paymentStrategyService;

    @Autowired
    private ExpenseRepository expenseRepository;
    

    @Override
    public String createExpenseWithOtherUsers(ExpenseDto expenseDto) {
        // TODO Auto-generated method stub
            String name=expenseDto.getName(); 
			String description=expenseDto.getDescription();
			List<Long> participants=expenseDto.getParticipants();
			Long createdById=expenseDto.getCreatedBy();
			Double amount=expenseDto.getTotalAmount();
			HashMap<Long, Double> percentage=expenseDto.getPercentage();

            Optional<User> user = userRepository.findById(createdById);
            User createdBy=null;
            if(user!=null){
                createdBy=user.get();
            }

            List<User> participantUsers=new ArrayList<User>();
            for(Long userId:participants){
                Optional<User> temp=userRepository.findById(userId);
                if(temp!=null)
                participantUsers.add(temp.get());
            }

            Expense expense = new Expense();
            expense.setName(name);
            System.out.println("name");
            System.out.println(expense.getExpenseId());
            expense.setDescription(description);
            expense.setCreatedBy(createdBy);
            expense.setTotalAmount(amount);
            expense.setParticipants(participants);
            HashMap<User, Double> amountOwned=new HashMap<User,Double>();
            HashMap<User, Double> amountPaid=new HashMap<User,Double>();
            expense.setAmountOwned(amountOwned);
            expense.setAmountPaid(amountPaid);
            expense.setDate(new Date());
            splitStrategyService.calculateOwnedAmount(expense,percentage,participantUsers);
            paymentStrategyService.calculatePaidAmount(expense,participantUsers);
            System.out.println("sachin tiwari");
            expenseRepository.save(expense);
            System.out.println("Expense added:");
            String response= tostring(expense);
            System.out.println(response);
            return response;
    }
    
    public String tostring(Expense expense) {
		StringBuilder sb = new StringBuilder();
		sb.append("Name: "+expense.getName()+"\n");
		sb.append("Description: "+expense.getDescription()+"\n");
		sb.append("CreatedBy: "+expense.getCreatedBy().getUserName()+"\n");
		sb.append("Paid amount:\n");
		for(User user : expense.getAmountPaid().keySet()) {
			sb.append(user.getUserName()+"::"+expense.getAmountPaid().get(user)+"\n");
		}
		sb.append("Owned amount:\n");
		for(User user : expense.getAmountOwned().keySet()) {
			sb.append(user.getUserName()+"::"+expense.getAmountOwned().get(user)+"\n");
		}
		return sb.toString();
	}
}
