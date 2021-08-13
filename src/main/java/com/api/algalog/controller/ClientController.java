package com.api.algalog.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.api.algalog.domain.model.Client;
import com.api.algalog.domain.repository.ClientRepository;
import com.api.algalog.domain.service.CatalogClientService;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
@RequestMapping("/clients")
public class ClientController {
	
	private ClientRepository clientRepository;
	private CatalogClientService catalogClientService;

    @GetMapping
    public List<Client> listar() {
       return clientRepository.findAll();
    }
    
    @GetMapping("/{clientId}")
    public ResponseEntity<Client> search(@PathVariable Long clientId) {
    	return clientRepository.findById(clientId)
    			.map(ResponseEntity::ok)
    			.orElse(ResponseEntity.notFound().build());

    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Client addClient(@Valid @RequestBody Client client) {
    	return catalogClientService.saveClient(client);
    }
    
    @PutMapping("/{clientId}")
    public ResponseEntity<Client> update(@PathVariable Long clientId, @RequestBody Client client){
    	if (!clientRepository.existsById(clientId)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	client.setId(clientId);
    	client = catalogClientService.saveClient(client);
    	
    	return ResponseEntity.ok(client);
    }
    
    @DeleteMapping("/{clientId}")
    public ResponseEntity<Void> remove(@PathVariable Long clientId) {
    	if (!clientRepository.existsById(clientId)) {
    		return ResponseEntity.notFound().build();
    	}
    	
    	//clientRepository.deleteById(clientId);
    	catalogClientService.deleteClient(clientId);
    	
    	return ResponseEntity.noContent().build();
    }
}