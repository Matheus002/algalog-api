package com.api.algalog.controller;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.algalog.domain.model.Client;

@RestController
public class ClientController {
	
	@PersistenceContext
	private EntityManager manager;

    @GetMapping("/clients")
    public List<Client> listar() {
       return manager.createQuery("from client", Client.class).getResultList();
    }
}