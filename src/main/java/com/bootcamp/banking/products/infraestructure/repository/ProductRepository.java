package com.bootcamp.banking.products.infraestructure.repository;

import com.bootcamp.banking.products.domain.models.Product;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

public interface ProductRepository extends ReactiveMongoRepository<Product, String> {

  Flux<Product> findByClientId(String clientId);

  Flux<Product> findByClientIdAndProductType(String clientId, String productType);

}
