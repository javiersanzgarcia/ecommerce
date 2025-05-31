package com.hexagonal.ecommerce.infrastructure.rest.mapper;

import com.hexagonal.ecommerce.common.ProductDto;
import com.hexagonal.ecommerce.domain.model.Product;

public class ProductDtoMapper {

    public static ProductDto fromProductToDto(Product product) {
        return new ProductDto(product.getProductId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getCurrency()
        );
    }

    public static ProductDto[] fromProductsToDto(Product[] products) {
        ProductDto[] productDtos = new ProductDto[products.length];
        for (int i = 0; i < products.length; i++) {
            productDtos[i] = fromProductToDto(products[i]);
        }
        return productDtos;
    }

}
