package com.kreit.movein.controller;

import com.kreit.movein.dto.AgentCardDto;
import com.kreit.movein.dto.AgentDto;
import com.kreit.movein.mapper.AgentMapper;
import com.kreit.movein.repository.AgentRepository;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@Validated
@RequestMapping("/app-user-api/agent")
public class AppUserAgentController {
    private final AgentRepository agentRepository;

    @GetMapping("/{agentId}")
    public AgentCardDto getAgentCard(@PathVariable @Positive Integer agentId) {
        return agentRepository.findById(agentId).map(AgentMapper.toCardDtoMapper).orElseThrow();
    }
}
