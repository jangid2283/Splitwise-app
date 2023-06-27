package com.splitwise.splitapp.Services;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.splitwise.splitapp.Exceptions.UserAlreadyExistsException;
import com.splitwise.splitapp.Exceptions.UserNotFoundException;
import com.splitwise.splitapp.Models.Expense;
import com.splitwise.splitapp.Models.Group;
import com.splitwise.splitapp.Models.User;
import com.splitwise.splitapp.Repository.UserRepository;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    @Autowired
    private UserRepository userRepository;
    
    @Override
    public Map<String, String> verify(String phoneNumber, String password) {
         Map<String,String> response=new HashMap<String,String>();
         User user = userRepository.getUser(phoneNumber);
         if(user == null){
            throw new UserNotFoundException("User with phonenumber "+
			phoneNumber +
			"does not exists in the records.");
         } else if(password.equals(user.getPassword())){
            response.put("result", "VERIFIED");
            response.put("id", String.valueOf(user.getUserId()));
         } else{
            response.put("result", "Wrong Password");
         }
         return response;
    }

    @Override
    public Map<String, String> registerUser(String userName, String password, String phoneNumber) {
        User user = userRepository.getUser(phoneNumber);
        if(user!=null){
            throw new UserAlreadyExistsException("User with phoneNumber "+
            phoneNumber +
					" already exists in the records");
        }
        user=new User();
        user.setPassword(password);
        user.setUserName(userName);
        user.setPhoneNumber(phoneNumber);
        List<Expense> expenses=new  ArrayList<Expense>();
        Set<Group> groups=new  HashSet<Group>();
        user.setExpenses(expenses);
        user.setGroups(groups);
        userRepository.save(user);
        Map<String,String>response=new HashMap<>();
        response.put("Registration Successful","");
        response.put("Registered User Id is",String.valueOf(user.getUserId()));
        return response;
    }

}
