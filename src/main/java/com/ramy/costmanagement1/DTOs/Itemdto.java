package com.ramy.costmanagement1.DTOs;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Itemdto {
    private Long id;
    private String name;
    private Integer quantity;
    private Double unitPrice;
}
