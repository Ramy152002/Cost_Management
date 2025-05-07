package com.ramy.costmanagement1.Controller;

import com.ramy.costmanagement1.DTOs.ClientRequest;
import com.ramy.costmanagement1.Entity.Client;
import com.ramy.costmanagement1.Repository.ClientRepository;
import com.ramy.costmanagement1.Services.ClientServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
public class ClientController {
    
    @Autowired
    ClientServices clientServices;
    
    @PostMapping
    public ResponseEntity<Client> clientEntry(@RequestBody ClientRequest clientRequest){
        return clientServices.createClient(clientRequest);
    }
    
    @GetMapping
    public ResponseEntity<List< Client>> getClientEntry(){
        return clientServices.getCients();
    }
    
    
}
