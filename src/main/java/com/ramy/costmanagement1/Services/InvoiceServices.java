package com.ramy.costmanagement1.Services;

import com.ramy.costmanagement1.DTOs.InvoiceRequest;
import com.ramy.costmanagement1.DTOs.Itemdto;
import com.ramy.costmanagement1.Entity.Invoice;
import com.ramy.costmanagement1.Entity.Items;
import com.ramy.costmanagement1.Repository.InvoiceRepository;
import com.ramy.costmanagement1.Repository.ItemRepository;
import org.hibernate.cache.spi.support.AbstractReadWriteAccess;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class InvoiceServices {
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    ItemRepository itemRepository;
    
    public ResponseEntity<Invoice> createInvoice(InvoiceRequest invoiceRequest) {
    Invoice invoice = new Invoice();
    invoice.setTax(invoiceRequest.getTax());
    invoice.setDiscounts(invoiceRequest.getDiscounts());
    invoice.setClientId(invoiceRequest.getClientId());
    invoice.setItems(invoiceRequest.getItems());
    invoiceRepository.save(invoice);
    
    return new ResponseEntity<>(invoice, HttpStatus.CREATED);
    
    }
    
    public ResponseEntity<List<Invoice>> getInvoices() {
        
        List<Invoice> invoiceList = invoiceRepository.findAll();
        return new ResponseEntity<>(invoiceList,HttpStatus.OK);
        
    }
    
    
    public ResponseEntity<Invoice> updateInvoice(Long id, InvoiceRequest invoiceRequest) {
        // 1. Validate input
        if (invoiceRequest == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        
        // 2. Find existing invoice
        Optional<Invoice> existingInvoice = invoiceRepository.findById(id);
        if (existingInvoice.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        // 3. Update invoice fields
        Invoice invoiceToUpdate = existingInvoice.get();
        
        // Map fields from InvoiceRequest to Invoice entity
        
        invoiceToUpdate.setTax(invoiceRequest.getTax());
        invoiceToUpdate.setDiscounts(invoiceRequest.getDiscounts());
        invoiceToUpdate.setClientId(invoiceRequest.getClientId());
        invoiceToUpdate.setId(id);
//
//        List<Items> items = invoiceRequest.getItems(); // Assuming getItems() returns List<Items>
//
//        // Set the invoice reference for each item
//        items.forEach(item -> item.setInvoice(invoiceToUpdate));
//
//        // Now safely set the items list
//        invoiceToUpdate.setItems(items);
        
        List<Items> originalItems = invoiceRequest.getItems();
        List<Items> newItemsList = new ArrayList<>(originalItems); // Create a new list with the same elements
        invoiceToUpdate.setItems(newItemsList);
        
        // 4. Save updated invoice
        try {
            itemRepository.saveAll(newItemsList);
            Invoice updatedInvoice = invoiceRepository.save(invoiceToUpdate);
            return new ResponseEntity<>(updatedInvoice, HttpStatus.OK);
        } catch (Exception e) {
            // Handle database errors
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}
