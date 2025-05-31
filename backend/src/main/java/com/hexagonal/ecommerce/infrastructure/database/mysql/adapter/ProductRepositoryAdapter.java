package com.hexagonal.ecommerce.infrastructure.database.mysql.adapter;


import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.domain.repository.ProductRepositoryPort;
import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;
import com.hexagonal.ecommerce.infrastructure.database.mysql.mapper.ProductEntityMapper;
import com.hexagonal.ecommerce.infrastructure.database.mysql.repository.ProductJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.NoSuchElementException;

@RequiredArgsConstructor
@Component
public class ProductRepositoryAdapter implements ProductRepositoryPort {

    private final ProductJpaRepository productJpaRepository;

    @Override
    public Product findProductByProductId(String productId) {
        return productJpaRepository.findByProductId(productId)
                .map(ProductEntityMapper::fromEntityToProduct)
                .orElseThrow(() -> new NoSuchElementException("Product not found"));
    }

    @Override
    public Product[] findAllProducts() {
        return productJpaRepository.findAll()
                .stream()
                .map(ProductEntityMapper::fromEntityToProduct)
                .toArray(Product[]::new);
    }

    @Override
    public void deleteProductByProductId(String productId) {
        productJpaRepository.deleteByProductId(productId);
    }

    @Override
    public Product createProduct(ProductHexaEntity productHexaEntity) {
        ProductHexaEntity saved = productJpaRepository.save(productHexaEntity);
        return ProductEntityMapper.fromEntityToProduct(saved);
    }

    @Override
    public Product updateProduct(ProductHexaEntity productHexaEntity) {
        ProductHexaEntity updated = productJpaRepository.save(productHexaEntity);
        return ProductEntityMapper.fromEntityToProduct(updated);
    }

}
