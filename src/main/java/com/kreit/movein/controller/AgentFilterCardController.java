package com.kreit.movein.controller;

import com.kreit.movein.dto.FilterCardDto;
import com.kreit.movein.mapper.FilterCardMapper;
import com.kreit.movein.repository.AgentRepository;
import com.kreit.movein.repository.FilterCardRepository;
import com.kreit.movein.repository.ItemRepository;
import com.kreit.movein.repository.RecommendationRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agent-api/filter-card")
public class AgentFilterCardController {
    private final FilterCardRepository filterCardRepository;

    @GetMapping()
    public List<FilterCardDto> getFilterCardList() {
        return filterCardRepository.findAllByIsDoneIsFalse().stream().map(FilterCardMapper::toDto).collect(Collectors.toList());
    }

    @GetMapping("/{filterCardId}")
    public FilterCardDto getFilterCard(@PathVariable int filterCardId) {
        return filterCardRepository.findById(filterCardId).map(FilterCardMapper::toDto).orElseThrow();
    }
}
