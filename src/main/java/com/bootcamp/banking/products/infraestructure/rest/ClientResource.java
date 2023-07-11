package com.bootcamp.banking.products.infraestructure.rest;

import com.bootcamp.banking.products.infraestructure.repository.ProductRepository;
import com.bootcamp.banking.products.infraestructure.repository.dao.ProductDao;
import com.bootcamp.banking.products.infraestructure.rest.dto.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientResource {
    private final ProductRepository productRepository;
    // private final WebClient webClient;

    @GetMapping("/{clientId}/products")
    public Flux<Product> getProductsByClient(@PathVariable String clientId) {
        return productRepository.findByClientId(clientId)
                .map(this::fromProductDaoToProductDto);
    }

    @GetMapping("/{clientId}/products/")
    public Flux<Product> getProductsByClientAndProductType(@PathVariable String clientId, @RequestParam String productType) {
        return productRepository.findByClientIdAndProductType(clientId, productType)
                .map(this::fromProductDaoToProductDto);
    }

    private Product fromProductDaoToProductDto(ProductDao dao) {
        Product product = new Product();
        product.setId(dao.getId());
        product.setProductName(dao.getProductName());
        product.setProductType(dao.getProductType());
        product.setCardNumber(dao.getCardNumber());
        product.setMonthlyFee(dao.getMonthlyFee());
        product.setTransactionFee(dao.getTransactionFee());
        product.setTransactionDay(dao.getTransactionDay());
        product.setTransactionLimit(dao.getTransactionLimit());
        product.setTransactionFeeAfterLimit(dao.getTransactionFeeAfterLimit());
        product.setClientId(dao.getClientId());
        return product;
    }
}
