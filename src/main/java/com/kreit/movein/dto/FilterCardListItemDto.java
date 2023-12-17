package com.kreit.movein.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;

public record FilterCardListItemDto(
        int id,
        @NotBlank
        String name,
        @NotBlank
        String familyType,
        @NotNull
        @Positive
        Long maximumDeposit,
        @NotNull
        @Positive
        Long maximumMonthlyCost,
        @NotNull
        @Positive
        Long minimumMonthlyCost,
        @NotBlank
        String costPreferenceType,
        @NotBlank
        String preferredRegion,
        @NotBlank
        String preferredVillage,
        String itemHouseType,
        Long recommendationCount
) {
}
