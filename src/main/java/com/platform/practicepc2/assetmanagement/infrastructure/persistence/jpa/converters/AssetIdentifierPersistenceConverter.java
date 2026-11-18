package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.converters;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.AssetIdentifier;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts AssetIdentifier between the domain model and persistence column values.
 */
@Converter(autoApply = false)
public class AssetIdentifierPersistenceConverter implements AttributeConverter<AssetIdentifier, String> {

    @Override
    public String convertToDatabaseColumn(AssetIdentifier attribute) {
        return attribute == null ? null : attribute.id().toString();
    }

    @Override
    public AssetIdentifier convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new AssetIdentifier(java.util.UUID.fromString(dbData));
    }


}
