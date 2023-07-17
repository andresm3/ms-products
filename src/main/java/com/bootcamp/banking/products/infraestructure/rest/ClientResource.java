package com.bootcamp.banking.products.infraestructure.rest;

import com.bootcamp.banking.products.application.ProductUseCases;
import com.bootcamp.banking.products.domain.models.Product;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
@RequestMapping("/clients")
public class ClientResource {

  private final ProductUseCases productUseCases;

  @GetMapping("/{clientId}/products")
  public Flux<Product> getProductsByClient(@PathVariable String clientId) {
    return productUseCases.getProductsByClient(clientId);
  }

  @GetMapping("/{clientId}/products/")
  public Flux<Product> getProductsByClientAndProductType(@PathVariable String clientId,
      @RequestParam String productType) {
    return productUseCases.getProductsByClientAndProductType(clientId, productType);
  }

}
