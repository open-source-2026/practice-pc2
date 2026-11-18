package com.platform.practicepc2.assetmanagement.domain.repositories;

import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;

public interface TechnologyAssetRepository {

    /**
     * Saves the given TechnologyAsset to the repository.
     *
     * @param asset the TechnologyAsset to be saved
     * @return the saved TechnologyAsset
     */
    TechnologyAsset save(TechnologyAsset asset);

    /**
     * Checks if a TechnologyAsset with the specified AssetIdentifier exists in the repository.
     *
     * @param assetIdentifier the AssetIdentifier to check for existence
     * @return true if a TechnologyAsset with the given AssetIdentifier exists, false otherwise
     */
    boolean existsByAssetIdentifier(AssetIdentifier assetIdentifier);
}
