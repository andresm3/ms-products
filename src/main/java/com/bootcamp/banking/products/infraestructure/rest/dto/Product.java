package com.bootcamp.banking.products.infraestructure.rest.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

import java.util.Date;

@Data
public class Product {
    @Id
    private String id;
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
