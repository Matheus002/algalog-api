package com.api.algalog.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.algalog.domain.model.Client;

import java.util.Arrays;
import java.util.List;

@RestController
public class ClientController {

    @GetMapping("/clients")
    public List<Client> listar() {
        var client1 = new Client();
        client1.setId(1L);
        client1.setName("Matheus");
        client1.setPhone_number("77 98484-8745");
        client1.setEmail("teteu@gmail.com");

        var client2 = new Client();
        client2.setId(2L);
        client2.setName("Lucas");
        client2.setPhone_number("77 98484-8245");
        client2.setEmail("lucas_01@gmail.com");
        
        return Arrays.asList(client1, client2);
    }
}