package com.hexagonal.ecommerce.usecase;

import com.hexagonal.ecommerce.domain.model.Product;

public interface IProductInteractor {
    Product findProductById(String productId);
}
