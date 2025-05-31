package com.hexagonal.ecommerce.domain.model;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@AllArgsConstructor
public class Product {
    private String productId;
    private String name;
    private String description;
    @NotNull
    @Min(value = 0, message = "Price must be positive")
    private BigDecimal price;
    @NotNull
    @Pattern(regexp = "[$€]", message = "Currency must be either '$' or '€'")
    private String currency;
}
