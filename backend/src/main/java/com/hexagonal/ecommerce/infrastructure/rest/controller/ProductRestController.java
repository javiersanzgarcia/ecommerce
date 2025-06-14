package com.hexagonal.ecommerce.infrastructure.rest.controller;

import com.hexagonal.ecommerce.common.ProductDto;
import com.hexagonal.ecommerce.infrastructure.rest.mapper.ProductDtoMapper;
import com.hexagonal.ecommerce.usecase.IProductInteractor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RequestMapping("/hexagonal/products")
@RestController
@CrossOrigin
public class ProductRestController {

    private final IProductInteractor productInteractor;

    @GetMapping("/")
    public ProductDto[] findAllProducts() {
        return ProductDtoMapper.fromProductsToDto(productInteractor.findAllProducts());
    }

    @GetMapping("/{productId}")
    public ProductDto findProductById(@PathVariable String productId) {
        return ProductDtoMapper.fromProductToDto(productInteractor.findProductById(productId));
    }

    @DeleteMapping("/{productId}")
    public void deleteProductById(@PathVariable String productId) {
        productInteractor.deleteProductById(productId);
    }

    @PutMapping("/")
    public ProductDto updateProduct(@RequestBody ProductDto productDto) {
        return ProductDtoMapper.fromProductToDto(productInteractor.updateProduct(productDto));
    }

    @PostMapping("/")
    public ProductDto createProduct(@RequestBody ProductDto productDto) {
        return ProductDtoMapper.fromProductToDto(productInteractor.createProduct(productDto));
    }
}
