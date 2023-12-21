package com.kreit.movein.controller;

import com.kreit.movein.dto.AgentCardDto;
import com.kreit.movein.dto.ConsultationCardDto;
import com.kreit.movein.dto.ItemDto;
import com.kreit.movein.mapper.AgentMapper;
import com.kreit.movein.mapper.ConsultationMapper;
import com.kreit.movein.mapper.ItemMapper;
import com.kreit.movein.repository.ConsultationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app-user-api/consultation")
@Validated
public class AppUserConsultationController {
    private final ConsultationRepository consultationRepository;

    @Transactional
    @GetMapping
    public List<ConsultationCardDto> getConsultationList(HttpServletRequest request) {
        int appUserId = (int) request.getAttribute("appUserId");
        return consultationRepository.findAllConsultationListByAppUserId(appUserId).stream().map(entity -> {
            ItemDto itemDto = ItemMapper.toDtoFunction.apply(entity.getRecommendation().getItem());
            AgentCardDto agentCardDto = AgentMapper.toCardDtoMapper.apply(entity.getRecommendation().getItem().getAgent());
            return ConsultationMapper.toCardDto(entity, itemDto,agentCardDto);
        }).toList();
    }
}
