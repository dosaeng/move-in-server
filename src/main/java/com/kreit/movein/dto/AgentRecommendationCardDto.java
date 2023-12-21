package com.kreit.movein.dto;

import java.time.LocalDate;

public record AgentRecommendationCardDto(
        Integer id,
        Integer itemId,
        String name,
        String address,
        Float dedicatedArea,
        Float supplyArea,
        Integer roomCount,
        Integer toiletCount,
        Integer floor,
        Long deposit,
        Long monthlyRent,
        LocalDate minimumMoveInDate
) {
}