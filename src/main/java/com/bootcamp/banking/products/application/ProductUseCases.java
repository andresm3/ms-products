package com.bootcamp.banking.products.application;

import com.bootcamp.banking.products.domain.dto.ProductRequest;
import com.bootcamp.banking.products.domain.models.Product;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface ProductUseCases {

  Flux<Product> getAllProducts();

  Mono<Product> createProduct(ProductRequest productRequest);

  Flux<Product> getProductsByClient(String clientId);

  Flux<Product> getProductsByClientAndProductType(String clientId, String productType);

}
