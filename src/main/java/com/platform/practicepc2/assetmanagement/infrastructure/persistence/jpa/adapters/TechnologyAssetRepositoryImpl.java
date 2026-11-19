package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.adapters;

import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.domain.repositories.TechnologyAssetRepository;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.assemblers.TechnologyAssetPersistenceAssembler;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.repositories.TechnologyAssetPersistenceRepository;
import com.platform.practicepc2.shared.infrastructure.events.DomainEventPublisher;
import org.springframework.stereotype.Repository;

/**
 * Implementation of the TechnologyAssetRepository interface using JPA.
 */

@Repository
public class TechnologyAssetRepositoryImpl implements TechnologyAssetRepository {


    private final TechnologyAssetPersistenceRepository technologyAssetPersistenceRepository;
    private final DomainEventPublisher domainEventPublisher; // Inject the DomainEventPublisher from the shared module

    public TechnologyAssetRepositoryImpl(TechnologyAssetPersistenceRepository technologyAssetPersistenceRepository, DomainEventPublisher domainEventPublisher) {
        this.technologyAssetPersistenceRepository = technologyAssetPersistenceRepository;
        this.domainEventPublisher = domainEventPublisher;
    }

    /**
     * Saves the given TechnologyAsset to the repository.
     *
     * @param asset the TechnologyAsset to be saved
     * @return the saved TechnologyAsset
     */
    @Override
    public TechnologyAsset save(TechnologyAsset asset) {
        var entity = TechnologyAssetPersistenceAssembler.toPersistenceFromDomain(asset);

        var savedEntity = technologyAssetPersistenceRepository.save(entity);

        var savedAsset = TechnologyAssetPersistenceAssembler.toDomainFromPersistence(savedEntity);

        domainEventPublisher.publishAndClearEvents(asset);

        return savedAsset;
    }

    /**
     * Checks if a TechnologyAsset with the specified AssetIdentifier exists in the repository.
     *
     * @param assetIdentifier the AssetIdentifier to check for existence
     * @return true if a TechnologyAsset with the given AssetIdentifier exists, false otherwise
     */
    @Override
    public boolean existsByAssetIdentifier(AssetIdentifier assetIdentifier) {
        return technologyAssetPersistenceRepository.existsByAssetIdentifier(assetIdentifier);
    }
}
