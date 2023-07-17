package com.bootcamp.banking.products.domain.dto;

import lombok.Data;

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
