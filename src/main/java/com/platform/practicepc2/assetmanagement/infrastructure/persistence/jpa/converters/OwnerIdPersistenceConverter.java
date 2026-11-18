package com.platform.practicepc2.assetmanagement.infrastructure.persistence.jpa.converters;

import com.platform.practicepc2.assetmanagement.domain.model.valueobjects.OwnerId;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

/**
 * Converts OwnerId between the domain model and persistence column values.
 */
@Converter(autoApply = false)
public class OwnerIdPersistenceConverter implements AttributeConverter<OwnerId, String> {

    @Override
    public String convertToDatabaseColumn(OwnerId attribute) {
        return attribute == null ? null : attribute.id().toString();
    }

    @Override
    public OwnerId convertToEntityAttribute(String dbData) {
        return dbData == null ? null : new OwnerId(java.util.UUID.fromString(dbData));
    }
}
