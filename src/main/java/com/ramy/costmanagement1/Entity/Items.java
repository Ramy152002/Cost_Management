package com.ramy.costmanagement1.Entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Items {
//, items (name, quantity, unit price),
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Integer quantity;
    private Double unitPrice;
//    @ManyToOne
//    @JoinColumn(name = "invoice_id")
    @ManyToOne
    @JoinColumn(name = "invoice_id")
    @JsonBackReference  // <-- This side will be ignored
    private Invoice invoice;
    
    
}
