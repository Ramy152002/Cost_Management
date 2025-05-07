package com.ramy.costmanagement1.Services;

import com.ramy.costmanagement1.DTOs.ClientRequest;
import com.ramy.costmanagement1.Entity.Client;
import com.ramy.costmanagement1.Repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientServices {
    @Autowired
    ClientRepository clientRepository;
    
    
    public ResponseEntity<Client> createClient(ClientRequest clientRequest) {
        Client client = new Client();
        client.setEmail(clientRequest.getEmail());
        clientRepository.save(client);
        
        return new ResponseEntity<>(client, HttpStatus.CREATED);
    }
    
    public ResponseEntity<List< Client>> getCients() {
        List<Client> clientList = clientRepository.findAll();
        return new ResponseEntity<>(clientList,HttpStatus.OK);
    
    }
}
