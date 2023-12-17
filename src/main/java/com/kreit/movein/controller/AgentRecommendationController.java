package com.kreit.movein.controller;

import com.kreit.movein.dto.RecommendationDto;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.entity.Recommendation;
import com.kreit.movein.mapper.FilterCardMapper;
import com.kreit.movein.mapper.RecommendationMapper;
import com.kreit.movein.repository.RecommendationRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agent-api/recommendation")
@Validated
public class AgentRecommendationController {
    private final RecommendationRepository recommendationRepository;

    @PostMapping
    public void doRecommendation(HttpServletRequest request, @RequestBody @Valid RecommendationDto dto){
        Recommendation recommendation = RecommendationMapper.toEntityMapper.apply(dto);
        recommendationRepository.save(recommendation);
    }
}
