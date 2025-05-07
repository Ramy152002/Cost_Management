package com.ramy.costmanagement1.Services;

import com.ramy.costmanagement1.Entity.Tax;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class TaxServices {
    /*String formattedString = String.format("The string is: %s, and the double is: %.2f", "example", 123.456);
System.out.println(formattedString); // Output: The string is: example, and the double is: 123.46*/

    
    public ResponseEntity< String >getTax(Tax tax) {
        Double total =tax.getSubTotal()-( tax.getSubTotal()*tax.getTaxRate());
        return new ResponseEntity<>(String.format("total after Tax deduction for %s = %.2f",tax.getRegion(), total), HttpStatus.OK);
        
    
    }
}
