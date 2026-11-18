package com.platform.practicepc2.assetmanagement.interfaces.rest.resources;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetStatus;

import java.math.BigDecimal;
import java.time.LocalDate;

public record CreateTechnologyAssetResource(
        String assetIdentifier,
        String ownerId,
        LocalDate periodStartDate,
        LocalDate periodEndDate,
        BigDecimal contractValueAmount,
        String contractValueCurrency,
        AssetStatus status,
        String description
) {
}