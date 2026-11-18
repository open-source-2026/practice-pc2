package com.platform.practicepc2.shared.infrastructure.persistence.jpa.embeddables;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

/**
 * Represents a warranty period with start and end dates.
 */
@Getter
@Setter
@Embeddable
public class WarrantyPeriodPersistenceEmbeddable {

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    // constructor without parameters

    public WarrantyPeriodPersistenceEmbeddable() {
    }

    // constructor with parameters

    public WarrantyPeriodPersistenceEmbeddable(LocalDate startDate, LocalDate endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
    }



}
