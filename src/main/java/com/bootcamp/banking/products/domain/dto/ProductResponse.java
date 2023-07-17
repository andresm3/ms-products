package com.bootcamp.banking.products.domain.dto;

import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class ProductResponse {

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
