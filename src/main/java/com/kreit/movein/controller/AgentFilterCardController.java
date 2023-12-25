package com.kreit.movein.controller;

import com.kreit.movein.dto.*;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.entity.Recommendation;
import com.kreit.movein.enumeration.FilterCardStatusEnum;
import com.kreit.movein.mapper.FilterCardMapper;
import com.kreit.movein.mapper.RecommendationMapper;
import com.kreit.movein.repository.FilterCardRepository;
import com.kreit.movein.repository.RecommendationRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agent-api/filter-card")
@Validated
public class AgentFilterCardController {
    private final FilterCardRepository filterCardRepository;
    private final RecommendationRepository recommendationRepository;

    @GetMapping
    public List<AgentFilterCardListItemDto> getFilterCardList(HttpServletRequest request) {
        int agentUserId = (int) request.getAttribute("agentUserId");
        List<FilterCard> fcList = filterCardRepository.findAllByStatus(FilterCardStatusEnum.OPEN);
        List<Integer> fcIds = fcList.stream().map(FilterCard::getId).toList();
        Map<Integer, Long> aggregate = filterCardRepository.aggregateWithRecommendationCount(fcIds).stream().collect(Collectors.toMap(FilterCardRecommendationCountDto::filterCardId, FilterCardRecommendationCountDto::recommendationCount));
        Map<Integer, FilterCardSuggestionConsultationDto> aggregate2 = filterCardRepository.aggregateWithSuggestionAndConsultation(fcIds, agentUserId).stream().collect(Collectors.toMap(FilterCardSuggestionConsultationDto::filterCardId, Function.identity()));
        return fcList.stream().map(fc -> FilterCardMapper.toAgentListItemDto(fc, aggregate.get(fc.getId()), aggregate2.get(fc.getId()).didSuggestAlready(), aggregate2.get(fc.getId()).isConsultationRequested())).toList();
    }

    @GetMapping("/{filterCardId}")
    public FilterCardDto getFilterCard(@PathVariable int filterCardId) {
        return filterCardRepository.findById(filterCardId).map(FilterCardMapper::toDto).orElseThrow();
    }

    @PostMapping("/{filterCardId}/recommendation")
    public void doRecommendation(HttpServletRequest request, @RequestBody @Valid RecommendationDto dto) {
        Recommendation recommendation = RecommendationMapper.toEntityMapper.apply(dto);
        recommendationRepository.save(recommendation);
    }

    @GetMapping("/{filterCardId}/recommendation")
    public List<AgentRecommendationCardDto> getRecommendationList(@PathVariable int filterCardId) {
        return recommendationRepository.findAllByFilterCard_Id(filterCardId).stream().map(recommendation -> RecommendationMapper.toAgentRecommendationCardDto(recommendation, recommendation.getItem())).toList();
    }
}
