package com.hexagonal.ecommerce.common;

import java.math.BigDecimal;

public class PriceFormatter {

    public static String formatPrice(BigDecimal price, String currency) {
        return String.format("%s %s", price, currency);
    }

    public static String[] unformatPrice(String price) {
        if (price == null || price.trim().isEmpty()) {
            throw new IllegalArgumentException("Price cannot be null or empty");
        }

        String[] parts = price.trim().split("\\s+");
        if (parts.length != 2) {
            throw new IllegalArgumentException("Price must be in format 'amount currency' (e.g., '30.0 €')");
        }

        return parts;
    }
}
