package com.bootcamp.banking.products.domain.models;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("products")
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
