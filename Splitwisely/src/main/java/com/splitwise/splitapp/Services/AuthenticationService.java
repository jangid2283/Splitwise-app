package com.splitwise.splitapp.Services;

import java.util.Map;

public interface AuthenticationService {
    Map<String,String> verify(String phoneNumber,String password);
    Map<String,String> registerUser(String userName,String password,String phoneNumber);

}
