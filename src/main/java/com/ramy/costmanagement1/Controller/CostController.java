package com.ramy.costmanagement1.Controller;


import com.ramy.costmanagement1.Entity.Cost;
import com.ramy.costmanagement1.DTOs.CostRequest;

import com.ramy.costmanagement1.Services.CostServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/cost")
public class CostController {
    
    @Autowired
    CostServices costServices;
    
    @PostMapping
    public ResponseEntity<Cost> costEntry(@RequestBody CostRequest costRequest)
    {
        return costServices.createCostEntry(costRequest);
    }
    
    @GetMapping
    public ResponseEntity<List< Cost>> getCostEntries()
    {
        return costServices.getCostEntries();
    }
}
