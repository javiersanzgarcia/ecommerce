package com.hexagonal.ecommerce.infrastructure.database.mysql.mapper;

import com.hexagonal.ecommerce.domain.model.Product;
import com.hexagonal.ecommerce.infrastructure.database.mysql.entity.ProductHexaEntity;

public class ProductEntityMapper {

    public static Product fromEntityToProduct(ProductHexaEntity productHexaEntity) {
        return new Product(productHexaEntity.getProductId(),
                           productHexaEntity.getName(),
                           productHexaEntity.getDescription(),
                           productHexaEntity.getPrice(),
                           productHexaEntity.getCurrency()
        );
    }

}
