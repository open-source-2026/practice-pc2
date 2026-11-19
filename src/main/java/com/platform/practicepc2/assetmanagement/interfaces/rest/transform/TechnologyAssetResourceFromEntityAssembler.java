package com.platform.practicepc2.assetmanagement.interfaces.rest.transform;

import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.interfaces.rest.resources.TechnologyAssetResource;

// Transform aggregate entity to resource for REST API response

public class TechnologyAssetResourceFromEntityAssembler {

    public static TechnologyAssetResource toResourceFromEntity(TechnologyAsset entity) {
        return new TechnologyAssetResource(
                entity.getId(),
                entity.getAssetIdentifier().toString(),
                entity.getOwnerId().toString(),
                entity.getPeriod().startDate().toString(),
                entity.getPeriod().endDate().toString(),
                entity.getTotalValue().value(),
                entity.getTotalValue().currency(),
                entity.getStatus().name(), // .name() when you are using enum, or .toString() if you want the string representation
                entity.getDescription()
        );
    }
}
