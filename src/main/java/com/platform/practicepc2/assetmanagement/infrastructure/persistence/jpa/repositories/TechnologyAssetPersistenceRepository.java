package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.repositories;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.entities.TechnologyAssetEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TechnologyAssetPersistenceRepository extends JpaRepository<TechnologyAssetEntity, Long> {

    /**
     * Checks if a TechnologyAssetEntity exists with the given AssetIdentifier.
     *
     * @param assetIdentifier The AssetIdentifier to check for existence.
     * @return true if an entity with the given AssetIdentifier exists, false otherwise.
     */
    boolean existsByAssetIdentifier(AssetIdentifier assetIdentifier);
}