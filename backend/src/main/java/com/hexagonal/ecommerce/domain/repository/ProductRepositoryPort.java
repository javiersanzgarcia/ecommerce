package com.hexagonal.ecommerce.domain.repository;

import com.hexagonal.ecommerce.domain.model.Product;

public interface ProductRepositoryPort {
    Product findProductByProductId(String productId);
}
