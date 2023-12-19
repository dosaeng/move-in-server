package com.kreit.movein.dto;

import com.kreit.movein.enumeration.ConsultationStatusEnum;

import java.time.LocalDate;

public record ConsultationCardDto(
        Integer id,
        ConsultationStatusEnum status,
        Integer recommendationId,
        ItemDto item,
        AgentCardDto agent,
        LocalDate appointmentDate
) {
}
