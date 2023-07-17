package com.bootcamp.banking.products.infraestructure.rest;

import com.bootcamp.banking.products.application.ProductUseCases;
import com.bootcamp.banking.products.domain.models.Product;
import com.bootcamp.banking.products.domain.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductResource {

  private final ProductUseCases productUseCases;

  @GetMapping
  public Flux<Product> getAll() {
    return productUseCases.getAllProducts();
  }

  @PostMapping
  public Mono<Product> createProduct(@RequestBody ProductRequest productRequest) {
    return productUseCases.createProduct(productRequest);
  }

}
