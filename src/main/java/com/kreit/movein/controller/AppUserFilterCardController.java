package com.kreit.movein.controller;

import com.kreit.movein.dto.*;
import com.kreit.movein.entity.Consultation;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.entity.Recommendation;
import com.kreit.movein.enumeration.ConsultationStatusEnum;
import com.kreit.movein.mapper.*;
import com.kreit.movein.repository.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app-user-api/filter-card")
@Validated
public class AppUserFilterCardController {
    private final FilterCardRepository filterCardRepository;
    private final RecommendationRepository recommendationRepository;
    private final ConsultationRepository consultationRepository;

    @PostMapping
    public FilterCardDto registerFilterCard(HttpServletRequest request, @RequestBody @Valid FilterCardDto body) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = FilterCardMapper.toEntity(body, appUserId);
        System.out.println(filterCard);
        filterCardRepository.save(filterCard);
        return FilterCardMapper.toDto(filterCard);
    }

    @GetMapping
    public List<FilterCardListItemDto> getFilterCardList(HttpServletRequest request) {
        int appUserId = (int) request.getAttribute("appUserId");
        List<FilterCard> fcList = filterCardRepository.findAllByAppUser_Id(appUserId);
        List<Integer> fcIds = fcList.stream().map(FilterCard::getId).toList();
        Map<Integer, Long> aggregate = filterCardRepository.aggregateWithRecommendationCount(fcIds).stream().collect(Collectors.toMap(FilterCardRecommendationCountDto::filterCardId, FilterCardRecommendationCountDto::recommendationCount));
        return fcList.stream().map(fc -> FilterCardMapper.toListItemDto(fc, aggregate.get(fc.getId()))).toList();
    }

    @GetMapping("/{filterCardId}")
    public FilterCardDto getFilterCard(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        return filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).map(FilterCardMapper::toDto).orElseThrow();
    }

    @DeleteMapping("/{filterCardId}")
    public void deleteFilterCard(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).orElseThrow();
        filterCardRepository.delete(filterCard);
    }

    @PutMapping("/{filterCardId}")
    public FilterCardDto updateFilterCard(HttpServletRequest request, @PathVariable int filterCardId, @RequestBody @Valid FilterCardDto body) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).orElseThrow();
        filterCard.update(body);
        filterCardRepository.save(filterCard);
        return FilterCardMapper.toDto(filterCard);
    }

    @PatchMapping("/{filterCardId}/open")
    public FilterCardDto openFilterCard(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).orElseThrow();
        filterCard.open();
        filterCardRepository.save(filterCard);
        return FilterCardMapper.toDto(filterCard);
    }

    @PatchMapping("/{filterCardId}/close")
    public FilterCardDto closeFilterCard(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).orElseThrow();
        filterCard.close();
        filterCardRepository.save(filterCard);
        return FilterCardMapper.toDto(filterCard);
    }

    @GetMapping("/{filterCardId}/recommendation")
    public List<RecommendedItemListDto> getRecommendationList(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).orElseThrow();
        return recommendationRepository.findAllByFilterCard_Id(filterCardId).stream().map(RecommendationMapper.toRecommendedItemMapper).toList();
    }

    @GetMapping("/{filterCardId}/recommendation/{recommendationId}")
    public RecommendationDetailDto getRecommendationList(HttpServletRequest request, @PathVariable int filterCardId, @PathVariable int recommendationId) {
        int appUserId = (int) request.getAttribute("appUserId");
        Recommendation recommendation = recommendationRepository.findByIdAndFilterCard_Id(recommendationId, filterCardId).orElseThrow();
        ItemDto itemDto = ItemMapper.toDtoFunction.apply(recommendation.getItem());
        AgentCardDto agentCardDto = AgentMapper.toCardDtoMapper.apply(recommendation.getItem().getAgent());

        return RecommendationMapper.toDetailDto(recommendation, itemDto, agentCardDto);
    }

    @PostMapping("/{filterCardId}/recommendation/{recommendationId}/consultation")
    public ConsultationCardDto createConsultation(HttpServletRequest request, @PathVariable int filterCardId, @PathVariable int recommendationId) {
        int appUserId = (int) request.getAttribute("appUserId");
        Recommendation recommendation = recommendationRepository.findByIdAndFilterCard_Id(recommendationId, filterCardId).orElseThrow();
        ItemDto itemDto = ItemMapper.toDtoFunction.apply(recommendation.getItem());
        AgentCardDto agentCardDto = AgentMapper.toCardDtoMapper.apply(recommendation.getItem().getAgent());
        Consultation consultation = Consultation.builder()
                .recommendation(recommendation)
                .status(ConsultationStatusEnum.WAITING)
                .build();
        consultationRepository.save(consultation);

        return ConsultationMapper.toCardDto(consultation, itemDto, agentCardDto);
    }
}
