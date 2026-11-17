package com.platform.practicepc2.shared.domain.model.valueobjects;

import java.time.LocalDate;

public record WarrantyPeriod(LocalDate startDate, LocalDate endDate) {


    /**
     * Constructs a WarrantyPeriod with the specified start and end dates.
     *
     * @param startDate the start date of the warranty period
     * @param endDate   the end date of the warranty period
     * @throws IllegalArgumentException if the start date is after the end date
     */
    public WarrantyPeriod {

        if(startDate == null || endDate == null) {
            throw new IllegalArgumentException("Start date and end date cannot be null");
        }

        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException("End date must be after start date");
        }
    }

    /**
     * Checks if the warranty period is expired based on the provided date.
     *
     * @param checkDate the date to check against the warranty period
     * @return true if the warranty period is expired, false otherwise
     */
    public boolean isExpired(LocalDate checkDate) {

        if (checkDate == null) {
            throw new IllegalArgumentException("Check date cannot be null");
        }

        return checkDate.isAfter(endDate);
    }
}
