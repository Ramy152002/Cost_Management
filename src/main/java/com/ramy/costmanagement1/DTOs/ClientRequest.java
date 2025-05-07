package com.ramy.costmanagement1.DTOs;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ClientRequest {
    @Email(message = "Email should be valid")
    @NotBlank(message = "Email cannot be empty")
    private String email;
    
}
