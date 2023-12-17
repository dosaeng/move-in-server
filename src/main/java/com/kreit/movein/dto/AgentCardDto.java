package com.kreit.movein.dto;

public record AgentCardDto(
        int id,
        String name,
        String title,
        String profileImageInBase64,
        String mainTradeRegion,
        String introduction
) {
}
