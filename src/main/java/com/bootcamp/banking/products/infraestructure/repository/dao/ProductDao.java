package com.bootcamp.banking.products.infraestructure.repository.dao;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document("products")
public class ProductDao {
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
