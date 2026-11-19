package com.platform.practicepc2.assetmanagement.interfaces.rest.transform;

import com.platform.practicepc2.assetmanagement.domain.model.commands.CreateTechnologyAssetCommand;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.OwnerId;
import com.platform.practicepc2.assetmanagement.interfaces.rest.resources.CreateTechnologyAssetResource;
import com.platform.practicepc2.shared.domain.model.valueobjects.AssetValue;
import com.platform.practicepc2.shared.domain.model.valueobjects.WarrantyPeriod;

import java.util.UUID;

public class CreateTechnologyAssetCommandFromResourceAssembler {

    public static CreateTechnologyAssetCommand toCommandFromResource(CreateTechnologyAssetResource resource) {
        return new CreateTechnologyAssetCommand(
                new AssetIdentifier(UUID.fromString(resource.assetIdentifier())),
                new OwnerId(UUID.fromString(resource.ownerId())),
                new WarrantyPeriod(
                        resource.periodStartDate(),
                        resource.periodEndDate()
                ),
                new AssetValue(
                        resource.contractValueAmount(),
                        resource.contractValueCurrency()
                ),
                resource.status(),
                resource.description()
        );
    }
}