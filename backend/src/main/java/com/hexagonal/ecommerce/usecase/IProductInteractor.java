package com.hexagonal.ecommerce.usecase;

import com.hexagonal.ecommerce.common.ProductDto;
import com.hexagonal.ecommerce.domain.model.Product;

public interface IProductInteractor {
    Product findProductById(String productId);

    Product[] findAllProducts();

    void deleteProductById(String productId);

    Product updateProduct(ProductDto productDto);

    Product createProduct(ProductDto productDto);
}
