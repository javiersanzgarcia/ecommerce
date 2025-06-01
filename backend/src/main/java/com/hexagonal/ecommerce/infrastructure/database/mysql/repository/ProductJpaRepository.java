package com.hexagonal.ecommerce.infrastructure.database.mysql.repository;

import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface ProductJpaRepository extends JpaRepository<ProductHexaEntity, UUID> {
    Optional<ProductHexaEntity> findByProductId(String productId);
    void deleteByProductId(String productId);
}
