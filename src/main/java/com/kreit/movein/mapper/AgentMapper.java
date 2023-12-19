package com.kreit.movein.mapper;

import com.kreit.movein.dto.AgentCardDto;
import com.kreit.movein.dto.AgentDto;
import com.kreit.movein.entity.Agent;

import java.sql.SQLException;
import java.util.Base64;
import java.util.function.Function;

public class AgentMapper {
    public static Function<Agent, AgentCardDto> toCardDtoMapper = entity -> {
        String profileImageBase64 = null;
        if (entity.getProfileImage() != null) {
            try {
                profileImageBase64 = Base64.getEncoder().encodeToString(entity.getProfileImage().getBytes(1, (int) entity.getProfileImage().length()));
            } catch (SQLException e) {
                System.err.println("Failed to read blob.");
            }
        }
        return new AgentCardDto(
                entity.getId(),
                entity.getName(),
                entity.getTitle(),
                profileImageBase64,
                entity.getMainTradeRegion(),
                entity.getIntroduction(),
                4.5f,
                382
        );
    };
}
