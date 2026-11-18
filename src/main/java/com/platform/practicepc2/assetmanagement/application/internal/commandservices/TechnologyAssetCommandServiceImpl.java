package com.platform.practicepc2.assetmanagement.application.internal.commandservices;

import com.platform.practicepc2.assetmanagement.application.commandservices.TechnologyAssetCommandService;
import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.domain.model.commands.CreateTechnologyAssetCommand;
import com.platform.practicepc2.assetmanagement.domain.repositories.TechnologyAssetRepository;
import com.platform.practicepc2.shared.application.result.ApplicationError;
import com.platform.practicepc2.shared.application.result.Result;
import org.springframework.stereotype.Service;

@Service
public class TechnologyAssetCommandServiceImpl implements TechnologyAssetCommandService {

    private final TechnologyAssetRepository technologyAssetRepository;

    public TechnologyAssetCommandServiceImpl(TechnologyAssetRepository technologyAssetRepository) {
        this.technologyAssetRepository = technologyAssetRepository;
    }

    @Override
    public Result<TechnologyAsset, ApplicationError> handle(CreateTechnologyAssetCommand command) {
        // Check if the asset already exists
        if (technologyAssetRepository.existsByAssetIdentifier(command.assetIdentifier())) {
            return Result.failure(ApplicationError.conflict("TechnologyAsset", "Asset with identifier '%s' already exists".formatted(command.assetIdentifier())));
        }

        // Create a new TechnologyAsset aggregate
        var technologyAsset = new TechnologyAsset(command);

        // Save the new asset to the repository
        try {
            technologyAsset = technologyAssetRepository.save(technologyAsset);
        } catch (Exception e) {
            return Result.failure(ApplicationError.unexpected("create-technology-asset", e.getMessage()));
        }

        // Return the created TechnologyAsset in the result
        return Result.success(technologyAsset);
    }

}
