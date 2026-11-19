package com.platform.practicepc2.assetmanagement.interfaces.rest.resources;

import java.math.BigDecimal;

public record TechnologyAssetResource(
        Long id,
        String assetIdentifier,
        String ownerId,
        String periodStartDate,
        String periodEndDate,
        BigDecimal contractValueAmount,
        String contractValueCurrency,
        String status,
        String description
) {
}