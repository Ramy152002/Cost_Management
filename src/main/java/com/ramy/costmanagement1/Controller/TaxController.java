package com.ramy.costmanagement1.Controller;

import com.ramy.costmanagement1.Entity.Tax;
import com.ramy.costmanagement1.Services.TaxServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/tax")
public class TaxController {
    
    @Autowired
    TaxServices taxServices;
    @GetMapping
    public ResponseEntity <String > getTax(@RequestBody Tax tax) {
        
        return taxServices.getTax(tax);
    }
    
}
