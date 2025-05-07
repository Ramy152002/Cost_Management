package com.ramy.costmanagement1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.websocket.server.ServerEndpoint;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
public class Cost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String  category;
    private String description;
    private Double amount;
    private LocalDateTime date;
}
