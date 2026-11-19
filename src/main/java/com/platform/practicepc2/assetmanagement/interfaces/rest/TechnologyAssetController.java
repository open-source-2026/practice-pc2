package com.platform.practicepc2.assetmanagement.interfaces.rest;

import com.platform.practicepc2.assetmanagement.application.commandservices.TechnologyAssetCommandService;
import com.platform.practicepc2.assetmanagement.interfaces.rest.resources.CreateTechnologyAssetResource;
import com.platform.practicepc2.assetmanagement.interfaces.rest.transform.CreateTechnologyAssetCommandFromResourceAssembler;
import com.platform.practicepc2.assetmanagement.interfaces.rest.transform.TechnologyAssetResourceFromEntityAssembler;
import com.platform.practicepc2.shared.interfaces.rest.transform.ResponseEntityAssembler;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/technology-assets")
@Tag(name = "Technology Asset Management",  description = "API for managing technology assets")
public class TechnologyAssetController {

    //1. Implement ( Application Layer ) TechnologyAssetCommandService
    private final TechnologyAssetCommandService technologyAssetCommandService;

    //2. Constructor injection for TechnologyAssetCommandService
    public TechnologyAssetController(TechnologyAssetCommandService technologyAssetCommandService) {
        this.technologyAssetCommandService = technologyAssetCommandService;
    }

    //3. Add POST endpoint to create a new technology asset
    @PostMapping
    @Operation(summary = "Create a new technology asset", description = "Creates a new technology asset in the system.")
    @ApiResponse(responseCode = "201", description = "Technology asset created successfully")
    @ApiResponse(responseCode = "400", description = "Invalid request payload")
    @ApiResponse(responseCode = "409", description = "Technology asset with the same identifier already exists")
    public ResponseEntity<?> createTechnologyAsset(@Valid @RequestBody CreateTechnologyAssetResource resource) {

        //1. Convert the incoming resource to a command using the assembler
        var command = CreateTechnologyAssetCommandFromResourceAssembler.toCommandFromResource(resource);

        //2. Handle the command using the TechnologyAssetCommandService
        var result = technologyAssetCommandService.handle(command);

        //3. Convert the result to a ResponseEntity using the ResponseEntityAssembler
        return ResponseEntityAssembler.toResponseEntityFromResult(
                result,
                TechnologyAssetResourceFromEntityAssembler::toResourceFromEntity,
                HttpStatus.CREATED
        );
    }
}