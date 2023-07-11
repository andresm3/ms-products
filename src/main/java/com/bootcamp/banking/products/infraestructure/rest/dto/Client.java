package com.bootcamp.banking.products.infraestructure.rest.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Client {
    @JsonProperty("id")
    private String id;
    private String documentType;
    private String documentNumber;
    private String name;

    private String idClientCategory;
}
