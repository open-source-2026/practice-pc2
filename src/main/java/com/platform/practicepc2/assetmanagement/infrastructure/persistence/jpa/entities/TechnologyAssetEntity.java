package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.entities;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetStatus;
import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.OwnerId;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.converters.AssetIdentifierPersistenceConverter;
import com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.converters.OwnerIdPersistenceConverter;
import com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables.AssetValuePersistenceEmbeddable;
import com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables.WarrantyPeriodPersistenceEmbeddable;
import com.platform.practicepc2.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "technology_assets")
@Getter
@Setter
@NoArgsConstructor
public class TechnologyAssetEntity extends AuditableAbstractPersistenceEntity {

    @Convert(converter = AssetIdentifierPersistenceConverter.class)
    @Column( nullable = false, unique = true)
    private AssetIdentifier assetIdentifier;

    @Convert(converter = OwnerIdPersistenceConverter.class)
    @Column(nullable = false)
    private OwnerId ownerId;

    @Embedded
    private WarrantyPeriodPersistenceEmbeddable period;

    @Embedded
    private AssetValuePersistenceEmbeddable totalValue;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private AssetStatus status;

    @Column(nullable = true)
    private String description;


}
