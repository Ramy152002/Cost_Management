package com.ramy.costmanagement1.DTOs;

import com.ramy.costmanagement1.Entity.Items;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Setter
@Getter
public class InvoiceRequest {
    
    private Long clientId;
    private List<Items> items;
    private Double tax;
    private Double discounts;
    
}
