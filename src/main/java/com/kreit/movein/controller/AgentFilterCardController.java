package com.kreit.movein.controller;

import com.kreit.movein.dto.AgentRecommendationCardDto;
import com.kreit.movein.dto.FilterCardDto;
import com.kreit.movein.dto.RecommendationDto;
import com.kreit.movein.entity.Recommendation;
import com.kreit.movein.enumeration.FilterCardStatusEnum;
import com.kreit.movein.mapper.FilterCardMapper;
import com.kreit.movein.mapper.RecommendationMapper;
import com.kreit.movein.repository.AgentRepository;
import com.kreit.movein.repository.FilterCardRepository;
import com.kreit.movein.repository.ItemRepository;
import com.kreit.movein.repository.RecommendationRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agent-api/filter-card")
@Validated
public class AgentFilterCardController {
    private final FilterCardRepository filterCardRepository;
    private final RecommendationRepository recommendationRepository;

    @GetMapping()
    public List<FilterCardDto> getFilterCardList() {
        return filterCardRepository.findAllByStatus(FilterCardStatusEnum.OPEN).stream().map(FilterCardMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{filterCardId}")
    public FilterCardDto getFilterCard(@PathVariable int filterCardId) {
        return filterCardRepository.findById(filterCardId).map(FilterCardMapper::toDto).orElseThrow();
    }

    @PostMapping("/{filterCardId}/recommendation")
    public void doRecommendation(HttpServletRequest request, @RequestBody @Valid RecommendationDto dto){
        Recommendation recommendation = RecommendationMapper.toEntityMapper.apply(dto);
        recommendationRepository.save(recommendation);
    }

    @GetMapping("/{filterCardId}/recommendation")
    public List<AgentRecommendationCardDto> getRecommendationList(@PathVariable int filterCardId){
        return recommendationRepository.findAllByFilterCard_Id(filterCardId).stream().map(recommendation -> RecommendationMapper.toAgentRecommendationCardDto(recommendation, recommendation.getItem())).toList();
    }
}
