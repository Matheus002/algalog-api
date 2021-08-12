package com.matheus.algalog.api.domain.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Client {

    private Long Id;
    private String name;
    private String email;
    private String phone_number;
}

