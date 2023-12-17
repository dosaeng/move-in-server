package com.kreit.movein.dto;

import jakarta.validation.constraints.NotNull;

public record AgentDto(
        String id,
        @NotNull
        String loginId,
        @NotNull
        String password,
        @NotNull
        String name,
        @NotNull
        String title,
        String profileImageInBase64,
        String mainTradeRegion,
        String introduction
) {
}
