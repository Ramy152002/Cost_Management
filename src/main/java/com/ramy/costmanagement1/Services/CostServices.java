package com.ramy.costmanagement1.Services;

import com.ramy.costmanagement1.Entity.Cost;
import com.ramy.costmanagement1.DTOs.CostRequest;

import com.ramy.costmanagement1.Repository.CostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CostServices {
    
    @Autowired
    CostRepository costRepository;
    
    
    public ResponseEntity<Cost> createCostEntry(CostRequest costRequest)
    {
        Cost cost = new Cost();
        cost.setCategory(costRequest.getCategory());
        cost.setDescription(costRequest.getDescription());
        cost.setAmount(costRequest.getAmount());
        cost.setDate(costRequest.getDate());
        costRepository.save(cost);
        return new ResponseEntity<>(cost,HttpStatus.CREATED);
    }
    
    public ResponseEntity<List<Cost>> getCostEntries() {
    List<Cost> costList = costRepository.findAll();
    return new ResponseEntity<>(costList,HttpStatus.OK);
    
    }
}
