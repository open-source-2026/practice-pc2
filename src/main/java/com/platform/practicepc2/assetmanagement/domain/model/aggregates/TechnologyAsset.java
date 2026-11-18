package com.platform.practicepc2.assetmanagement.domain.model.aggregates;

import com.platform.practicepc2.assetmanagement.domain.model.commands.CreateTechnologyAssetCommand;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetStatus;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.OwnerId;
import com.platform.practicepc2.shared.domain.model.aggregates.AbstractDomainAggregateRoot;
import com.platform.practicepc2.shared.domain.model.valueobjects.AssetValue;
import com.platform.practicepc2.shared.domain.model.valueobjects.WarrantyPeriod;
import lombok.Getter;

@Getter
public class TechnologyAsset extends AbstractDomainAggregateRoot<TechnologyAsset> {

    /**
     * Attributes
     */
    private Long id;
    private AssetIdentifier assetIdentifier;
    private OwnerId ownerId;
    private WarrantyPeriod period;
    private AssetValue totalValue;
    private AssetStatus status;
    private String description;


    /**
     * Constructor for TechnologyAsset.
     *
     * @param assetIdentifier the unique identifier for the asset
     * @param ownerId         the identifier of the owner of the asset
     * @param period          the warranty period of the asset
     * @param totalValue      the total value of the asset
     * @param status          the status of the asset (DRAFT, ACTIVE, TERMINATED)
     * @param description     a brief description of the asset
     */
    public TechnologyAsset(AssetIdentifier assetIdentifier, OwnerId ownerId, WarrantyPeriod period, AssetValue totalValue, AssetStatus status, String description) {
        this.assetIdentifier = assetIdentifier;
        this.ownerId = ownerId;
        this.period = period;
        this.totalValue = totalValue;
        this.status = status == null ? AssetStatus.DRAFT : status; // Define default status as DRAFT if not provided
        this.description = description;
    }



    /**
     * Reconstitutes a TechnologyAsset from its persisted state.
     *
     * @param id              the unique identifier of the asset
     * @param assetIdentifier the unique identifier for the asset
     * @param ownerId         the identifier of the owner of the asset
     * @param period          the warranty period of the asset
     * @param totalValue      the total value of the asset
     * @param status          the status of the asset (DRAFT, ACTIVE, TERMINATED)
     * @param description     a brief description of the asset
     * @return a reconstituted TechnologyAsset instance
     */
    public static TechnologyAsset reconstitute(Long id, AssetIdentifier assetIdentifier, OwnerId ownerId, WarrantyPeriod period, AssetValue totalValue, AssetStatus status, String description) {
        TechnologyAsset asset = new TechnologyAsset(assetIdentifier, ownerId, period, totalValue, status, description);
        asset.id = id;
        return asset;
    }


    /**
     * Constructor for TechnologyAsset using a command object.
     *
     * @param command the command object containing the necessary data to create a TechnologyAsset
     */
    public TechnologyAsset (CreateTechnologyAssetCommand command) {
        this.assetIdentifier = command.assetIdentifier();
        this.ownerId = command.ownerId();
        this.period = command.period();
        this.totalValue = command.totalValue();
        this.status = command.status() == null ? AssetStatus.DRAFT : command.status(); // Define default status as DRAFT if not provided
        this.description = command.description();
    }


}
