package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.assemblers;

import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.entities.TechnologyAssetEntity;
import com.platform.practicepc2.shared.domain.model.valueobjects.AssetValue;
import com.platform.practicepc2.shared.domain.model.valueobjects.WarrantyPeriod;

// CHANGE 1: Import persistence embeddables.
import com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables.AssetValuePersistenceEmbeddable;
import com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables.WarrantyPeriodPersistenceEmbeddable;

public class TechnologyAssetPersistenceAssembler {

    private TechnologyAssetPersistenceAssembler() {
    }

    public static TechnologyAsset toDomainFromPersistence(
            TechnologyAssetEntity entity
    ) {
        if (entity == null) {
            return null;
        }

        var period = new WarrantyPeriod(
                entity.getPeriod().getStartDate(),
                entity.getPeriod().getEndDate()
        );

        var totalValue = new AssetValue(
                entity.getTotalValue().getValue(),
                entity.getTotalValue().getCurrency()
        );

        // CHANGE 2: Reconstitute the aggregate with its persisted ID.
        return TechnologyAsset.reconstitute(
                entity.getId(),
                entity.getAssetIdentifier(),
                entity.getOwnerId(),
                period,
                totalValue,
                entity.getStatus(),
                entity.getDescription()
        );
    }

    public static TechnologyAssetEntity toPersistenceFromDomain(
            TechnologyAsset domain
    ) {
        if (domain == null) {
            return null;
        }

        var entity = new TechnologyAssetEntity();

        // CHANGE 3: Assign the ID directly, including null for a new asset.
        entity.setId(domain.getId());

        entity.setAssetIdentifier(domain.getAssetIdentifier());
        entity.setOwnerId(domain.getOwnerId());

        // CHANGE 4: Use the existing constructors of the embeddables.
        var periodEmbeddable = new WarrantyPeriodPersistenceEmbeddable(
                domain.getPeriod().startDate(),
                domain.getPeriod().endDate()
        );
        entity.setPeriod(periodEmbeddable);

        var totalValueEmbeddable = new AssetValuePersistenceEmbeddable(
                domain.getTotalValue().value(),
                domain.getTotalValue().currency()
        );
        entity.setTotalValue(totalValueEmbeddable);

        entity.setStatus(domain.getStatus());
        entity.setDescription(domain.getDescription());

        return entity;
    }
}