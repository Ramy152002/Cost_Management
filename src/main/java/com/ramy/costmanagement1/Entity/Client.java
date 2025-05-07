package com.ramy.costmanagement1.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    
    
}
