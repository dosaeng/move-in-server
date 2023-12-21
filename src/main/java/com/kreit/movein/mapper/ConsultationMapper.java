package com.kreit.movein.mapper;

import com.kreit.movein.dto.AgentCardDto;
import com.kreit.movein.dto.ConsultationCardDto;
import com.kreit.movein.dto.ItemDto;
import com.kreit.movein.entity.Consultation;
import com.kreit.movein.entity.Recommendation;

public class ConsultationMapper {
    public static ConsultationCardDto toCardDto(Consultation consultation, ItemDto item, AgentCardDto agent){
        return new ConsultationCardDto(
                consultation.getId(),
                consultation.getStatus(),
                consultation.getRecommendation().getId(),
                item,
                agent,
                consultation.getAppointmentDate(),
                consultation.getRecommendation().getFilterCard().getId()
        );
    }
}
