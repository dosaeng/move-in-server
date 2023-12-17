package com.kreit.movein.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;

public record FilterCardDto(
        int id,
        @NotBlank
        String name,
        @NotBlank
        String familyType,
        @NotNull
        Boolean petPresence,
        @NotBlank
        String minimumSize,
        @NotNull
        @Positive
        Integer minimumRoomCount,
        @NotNull
        LocalDate minimumMoveInDate,
        @NotNull
        LocalDate maximumMoveInDate,
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
        String favoritePlace1,
        String favoritePlace2,
        String favoritePlace3,
        String itemHouseType,
        String itemHouseCondition,
        String itemWishList
) {
}
