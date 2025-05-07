package com.ramy.costmanagement1.DTOs;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Getter
public class CostRequest {
    private String  category;
    private String description;
    private Double amount;
    private LocalDateTime date;
}
