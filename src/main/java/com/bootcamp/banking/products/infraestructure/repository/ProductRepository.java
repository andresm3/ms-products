package com.bootcamp.banking.products.infraestructure.repository;

import com.bootcamp.banking.products.infraestructure.repository.dao.ProductDao;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import reactor.core.publisher.Flux;

import java.util.Optional;

public interface ProductRepository extends ReactiveMongoRepository<ProductDao,String> {
    Flux<ProductDao> findByClientId(String clientId);

    Flux<ProductDao> findByClientIdAndProductType(String clientId, String productType);
    // public findAllBy
}
