package com.hexagonal.ecommerce.infrastructure.database.mysql.adapter;

import java.util.NoSuchElementException;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.domain.repository.ProductRepositoryPort;
import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;
import com.hexagonal.ecommerce.infrastructure.database.mysql.mapper.ProductEntityMapper;
import com.hexagonal.ecommerce.infrastructure.database.mysql.repository.ProductJpaRepository;

import lombok.RequiredArgsConstructor;

@Component
@Transactional
@RequiredArgsConstructor
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
        if (productJpaRepository.findByProductId(productId).isEmpty()) {
            throw new IllegalArgumentException("Product not exists");
        }
        productJpaRepository.deleteByProductId(productId);
    }

    @Override
    public Product createProduct(ProductHexaEntity productHexaEntity) {
        if (!productJpaRepository.findByProductId(productHexaEntity.getProductId()).isEmpty()) {
            throw new IllegalArgumentException("Product already exists");
        }
        ProductHexaEntity saved = productJpaRepository.save(productHexaEntity);
        return ProductEntityMapper.fromEntityToProduct(saved);
    }

    @Override
    public Product updateProduct(ProductHexaEntity productHexaEntity) {
        if (productJpaRepository.findByProductId(productHexaEntity.getProductId()).isEmpty()) {
            throw new IllegalArgumentException("Product not exists");
        }
        productJpaRepository.deleteByProductId(productHexaEntity.getProductId());
        ProductHexaEntity updated = productJpaRepository.save(productHexaEntity);
        return ProductEntityMapper.fromEntityToProduct(updated);
    }

}
