package com.hexagonal.ecommerce.domain.repository;

import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;

public interface ProductRepositoryPort {
    Product findProductByProductId(String productId);

    Product[] findAllProducts();

    Product createProduct(ProductHexaEntity productHexaEntity);

    Product updateProduct(ProductHexaEntity productHexaEntity);

    void deleteProductByProductId(String productId);
}
