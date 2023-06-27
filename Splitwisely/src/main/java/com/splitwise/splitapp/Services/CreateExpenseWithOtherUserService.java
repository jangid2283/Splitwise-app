package com.splitwise.splitapp.Services;

import com.splitwise.splitapp.Models.Dto.ExpenseDto;

public interface CreateExpenseWithOtherUserService {
    String createExpenseWithOtherUsers(ExpenseDto expenseDto);
}
