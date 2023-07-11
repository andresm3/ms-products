package com.bootcamp.banking.products.infraestructure.rest;

import com.bootcamp.banking.products.infraestructure.repository.ProductRepository;
import com.bootcamp.banking.products.infraestructure.repository.dao.ProductDao;
import com.bootcamp.banking.products.infraestructure.rest.dto.Product;
import com.bootcamp.banking.products.infraestructure.rest.dto.ProductRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequiredArgsConstructor
@RequestMapping("/products")
public class ProductResource {
    private final ProductRepository productRepository;

    @GetMapping
    public Flux<Product> getAll() {
        return productRepository.findAll()
                .map(this::fromProductDaoToProductDto);
    }

    @PostMapping
    public Mono<Product> createProduct(@RequestBody ProductRequest productRequest) {
        return productRepository.save(this.fromProductRequestToProductDao(productRequest))
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

    private ProductDao fromProductRequestToProductDao(ProductRequest productRequest) {
        ProductDao productDao = new ProductDao();
        productDao.setProductName(productRequest.getProductName());
        productDao.setProductType(productRequest.getProductType());
        productDao.setCardNumber(productRequest.getCardNumber());
        productDao.setMonthlyFee(productRequest.getMonthlyFee());
        productDao.setTransactionFee(productRequest.getTransactionFee());
        productDao.setTransactionLimit(productRequest.getTransactionLimit());
        productDao.setTransactionDay(productRequest.getTransactionDay());
        productDao.setTransactionFeeAfterLimit(productRequest.getTransactionFeeAfterLimit());
        productDao.setClientId(productRequest.getClientId());
        return productDao;
    }
}
