package com.kreit.movein.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record RecommendedItemListDto(
        Integer id,
        Integer itemId,
        String name,
        String photoInBase64String,
        Long deposit,
        Long monthlyRent,
        String address,
        LocalDate minimumMoveInDate,
        LocalDate suggestionDate,
        Integer agentId,
        String agentName,
        Float agentRating
) {
}