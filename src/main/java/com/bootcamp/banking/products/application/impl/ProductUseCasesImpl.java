package com.bootcamp.banking.products.application.impl;

import com.bootcamp.banking.products.application.ProductUseCases;
import com.bootcamp.banking.products.domain.dto.ProductRequest;
import com.bootcamp.banking.products.domain.models.Product;
import com.bootcamp.banking.products.infraestructure.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class ProductUseCasesImpl implements ProductUseCases {

  private final ProductRepository productRepository;


  @Override
  public Flux<Product> getAllProducts() {
    return productRepository.findAll();
  }

  @Override
  public Mono<Product> createProduct(ProductRequest productRequest) {
    return productRepository.save(this.fromProductRequestToProduct(productRequest));
  }

  @Override
  public Flux<Product> getProductsByClient(String clientId) {
    return productRepository.findByClientId(clientId);
  }

  @Override
  public Flux<Product> getProductsByClientAndProductType(String clientId, String productType) {
    return productRepository.findByClientIdAndProductType(clientId, productType);
  }

  private Product fromProductRequestToProduct(ProductRequest productRequest) {
    Product product = new Product();
    product.setProductName(productRequest.getProductName());
    product.setProductType(productRequest.getProductType());
    product.setCardNumber(productRequest.getCardNumber());
    product.setMonthlyFee(productRequest.getMonthlyFee());
    product.setTransactionFee(productRequest.getTransactionFee());
    product.setTransactionLimit(productRequest.getTransactionLimit());
    product.setTransactionDay(productRequest.getTransactionDay());
    product.setTransactionFeeAfterLimit(productRequest.getTransactionFeeAfterLimit());
    product.setClientId(productRequest.getClientId());
    return product;
  }
}
