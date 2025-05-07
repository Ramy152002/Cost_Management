package com.ramy.costmanagement1.Entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Setter
@Getter
public class Invoice {
    //s: Client ID, items (name, quantity, unit price), tax, discounts.
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
  
    private Long clientId;
    @OneToMany(mappedBy = "invoice")
    
    @JsonManagedReference  // <-- This side will be serialized
    private List<Items> items =new ArrayList<>();
    private Double tax;
    private Double discounts;
    
}
