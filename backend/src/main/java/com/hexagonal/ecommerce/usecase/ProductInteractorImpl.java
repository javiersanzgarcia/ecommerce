package com.hexagonal.ecommerce.usecase;

import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.domain.repository.ProductRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ProductInteractorImpl implements IProductInteractor {

    private final ProductRepositoryPort productRepository;

    @Override
    public Product findProductById(String productId) {
        return productRepository.findProductByProductId(productId);
    }
}
