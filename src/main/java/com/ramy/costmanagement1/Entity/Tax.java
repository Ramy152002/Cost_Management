package com.ramy.costmanagement1.Entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Tax {
    
    /**
     *  Tax Calculation Library
     *  Functionality: Automatically calculate taxes for invoices based on regional tax rules.
     *  Inputs: Subtotal, tax rate, region.
     *  Outputs: Tax amount and updated total.
     * */
    
    private Double subTotal;
    private Double taxRate;
    private String region;
}
