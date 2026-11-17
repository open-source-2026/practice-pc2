package com.platform.practicepc2.assetmanagement.domain.model.valueobjects;

import java.util.UUID;

public record OwnerId(UUID id) {

    /**
     * Constructs an OwnerId with the specified UUID.
     *
     * @param id the UUID of the owner
     * @throws IllegalArgumentException if the id is null
     */
    public OwnerId {
        if (id == null) {
            throw new IllegalArgumentException("Owner identifier cannot be null");
        }
    }
}
