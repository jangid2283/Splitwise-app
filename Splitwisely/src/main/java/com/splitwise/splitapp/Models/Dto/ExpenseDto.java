package com.splitwise.splitapp.Models.Dto;


import lombok.Getter;
import lombok.Setter;

import java.util.HashMap;
import java.util.List;

@Getter
@Setter
public class ExpenseDto {
    String name;
    String description;
    Long createdBy;
	List<Long>participants;
	Double totalAmount;
	HashMap<Long,Double>percentage;
}
