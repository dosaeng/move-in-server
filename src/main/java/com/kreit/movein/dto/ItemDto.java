package com.kreit.movein.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record ItemDto(
        Integer id,
        @NotBlank
        String houseType,
        @NotBlank
        String name,
        @NotBlank
        String region,
        @NotBlank
        String address,
        @NotBlank
        String photoInBase64,
        @NotNull
        @Positive
        Float dedicatedArea,
        @NotNull
        @Positive
        Float supplyArea,
        @NotNull
        @Positive
        Integer roomCount,
        @NotNull
        @Positive
        Integer toiletCount,
        @NotNull
        Integer floor,
        @NotNull
        Integer buildingFloor,
        @NotBlank
        String mainSpaceDirection,
        @NotNull
        LocalDate approvalDate,
        @NotNull
        LocalDate registrationDate,
        @NotNull
        @Positive
        Long deposit,
        Long monthlyRent,
        Long maintenanceCost,
        Long monthlyCost,
        @NotNull
        Boolean costAdjustability,
        LocalDate minimumMoveInDate,
        LocalDate maximumMoveInDate,
        LocalDate createdAt
) {
}
