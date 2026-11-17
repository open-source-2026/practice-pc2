package com.platform.practicepc2.shared.domain.model.valueobjects;


import java.math.BigDecimal;

public record AssetValue(BigDecimal value, String currency) {

    /**
     * Constructs an AssetValue with the specified value.
     *
     * @param value the monetary value of the asset
     * @throws IllegalArgumentException if the value is negative
     */
    public AssetValue {
        if (value==null || value.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Asset value cannot be negative or null");
        }
        if (currency == null || currency.isBlank()) {
            throw new IllegalArgumentException("Asset currency cannot be null or empty");
        }
    }

    /**
     * Multiplies the asset value by a specified multiplier.
     *
     * @param multiplier the multiplier to apply to the asset value
     * @return a new AssetValue instance with the multiplied value
     * @throws IllegalArgumentException if the multiplier is negative or null
     */
    public AssetValue multiply(BigDecimal multiplier) {
        if (multiplier == null || multiplier.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Multiplier cannot be negative or null");
        }
        return new AssetValue(value.multiply(multiplier), currency);
    }
}
