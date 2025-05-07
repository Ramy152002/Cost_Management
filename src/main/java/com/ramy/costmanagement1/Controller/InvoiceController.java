package com.ramy.costmanagement1.Controller;

import com.ramy.costmanagement1.DTOs.InvoiceRequest;
import com.ramy.costmanagement1.Entity.Invoice;
import com.ramy.costmanagement1.Services.InvoiceServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestClient;

import java.util.List;

@RestController
@RequestMapping("/api/v1/invoice")
public class InvoiceController {
    // Invoice object with unique invoice number
    @Autowired
    InvoiceServices invoiceServices;
    
    /**
     * nputs: Client ID, items (name, quantity, unit price), tax, discounts.
     *  Outputs: Invoice object with unique invoice number
     */
    
    @PostMapping
    public ResponseEntity<Invoice> createInvoice(@RequestBody InvoiceRequest invoiceRequest){
        return invoiceServices.createInvoice(invoiceRequest);
        
    }
    
    @GetMapping
    public ResponseEntity<List< Invoice>> getInvoice(){
        return invoiceServices.getInvoices();
    }
    
    @PutMapping(value = "/{id}")
    public ResponseEntity< Invoice> updateInvoice(@PathVariable Long id, @RequestBody InvoiceRequest invoiceRequest){
    return invoiceServices.updateInvoice(id , invoiceRequest);
    }
    
}
