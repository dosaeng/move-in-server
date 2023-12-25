package com.kreit.movein.dto;

import jakarta.persistence.ElementCollection;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public record FilterCardDto(
        Integer id,
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
        List<String> favoritePlace1,
        List<String> favoritePlace2,
        List<String> favoritePlace3,
        List<String> itemHouseType,
        List<String> itemHouseCondition,
        List<String> itemWishList,
        String status,
        LocalDate recommendationDueDate,
        String toBusStopMinutes,
        String toTrainStationMinutes,
        String toTerminalMinutes,
        String parking,
        List<String> livingOptions,
        List<String> communityLife,
        List<String> livingInfra,
        List<String> educationLife,
        List<String> deliveryLife
) {
}
