package com.splitwise.splitapp.Models.Dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PercentageDto {
    Long id;
    Double perc;
    List<Long>temp;
}
