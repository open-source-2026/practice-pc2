package com.platform.practicepc2.assetmanagement.application.commandservices;

import com.platform.practicepc2.assetmanagement.domain.model.aggregates.TechnologyAsset;
import com.platform.practicepc2.assetmanagement.domain.model.commands.CreateTechnologyAssetCommand;
import com.platform.practicepc2.shared.application.result.ApplicationError;
import com.platform.practicepc2.shared.application.result.Result;

/**
 * Service for handling TechnologyAsset commands.
 */
public interface TechnologyAssetCommandService {

    // It's important that the aggregate TechnologyAsset is returned in the result, as it may contain additional information needed for further processing or validation.
    Result<TechnologyAsset, ApplicationError> handle(CreateTechnologyAssetCommand command);

}
