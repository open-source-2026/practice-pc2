package com.platform.practicepc2.assetmanagement.domain.model.commands;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetStatus;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.OwnerId;
import com.platform.practicepc2.shared.domain.model.valueobjects.AssetValue;
import com.platform.practicepc2.shared.domain.model.valueobjects.WarrantyPeriod;

public record CreateTechnologyAssetCommand(
        AssetIdentifier assetIdentifier,
        OwnerId ownerId,
        WarrantyPeriod period,
        AssetValue totalValue,
        AssetStatus status,
        String description
) {

}
