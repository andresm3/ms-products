package com.bootcamp.banking.products.infraestructure.rest.dto;

import lombok.Data;

import java.util.Date;

@Data
public class ProductRequest {
    private String productName;
    private String productType;
    private String cardNumber;
    private Double monthlyFee;
    private Double transactionFee;
    private Integer transactionLimit;
    private Double transactionFeeAfterLimit;
    private String transactionDay;
    private String clientId;
}
