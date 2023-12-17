package com.kreit.movein.controller;

import com.kreit.movein.dto.FilterCardDto;
import com.kreit.movein.dto.FilterCardListItemDto;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.mapper.FilterCardMapper;
import com.kreit.movein.repository.AgentRepository;
import com.kreit.movein.repository.FilterCardRepository;
import com.kreit.movein.repository.ItemRepository;
import com.kreit.movein.repository.RecommendationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/app-user-api/filter-card")
public class AppUserFilterCardController {
    private final FilterCardRepository filterCardRepository;

    @PostMapping()
    public void registerFilterCard(HttpServletRequest request, @RequestBody FilterCardDto body) {
        int appUserId = (int) request.getAttribute("appUserId");
        FilterCard filterCard = FilterCardMapper.toEntity(body, appUserId);
        filterCardRepository.save(filterCard);
    }

    @GetMapping()
    public List<FilterCardListItemDto> getFilterCardList(HttpServletRequest request) {
        int appUserId = (int) request.getAttribute("appUserId");
        return filterCardRepository.findAllWithRecommendationCount(appUserId);
    }

    @GetMapping("/{filterCardId}")
    public FilterCardDto getFilterCard(HttpServletRequest request, @PathVariable int filterCardId) {
        int appUserId = (int) request.getAttribute("appUserId");
        return filterCardRepository.findByIdAndAppUser_Id(filterCardId, appUserId).map(FilterCardMapper::toDto).orElseThrow();
    }
}
