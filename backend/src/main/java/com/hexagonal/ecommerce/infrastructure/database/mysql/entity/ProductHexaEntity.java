package com.hexagonal.ecommerce.infrastructure.database.mysql.entity;

import java.math.BigDecimal;
import java.util.UUID;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "products")
public class ProductHexaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID id;
    private String productId;
    private String name;
    private String description;
    private BigDecimal price;
    private String currency;

    public ProductHexaEntity(String productId, String name, String description, BigDecimal price, String currency) {
        this.productId = productId;
        this.name = name;
        this.description = description;
        this.price = price;
        this.currency = currency;
    }
}
