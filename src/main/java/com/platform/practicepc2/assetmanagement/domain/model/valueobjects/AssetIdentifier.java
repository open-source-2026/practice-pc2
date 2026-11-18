package com.platform.practicepc2.assetmanagement.domain.model.valueobjects;

import java.util.UUID;


public record AssetIdentifier(UUID id) {

    /**
     * Constructs an AssetIdentifier with the specified UUID.
     *
     * @param id the UUID of the asset
     * @throws IllegalArgumentException if the id is null
     */
    public AssetIdentifier {
        if (id == null) {
            throw new IllegalArgumentException("Asset identifier cannot be null");
        }
    }


}
