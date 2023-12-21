package com.kreit.movein.controller;

import com.kreit.movein.dto.ItemDto;
import com.kreit.movein.mapper.ItemMapper;
import com.kreit.movein.repository.ItemRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/agent-api/item")
public class AgentItemController {
    private final ItemRepository itemRepository;

    @GetMapping
    public List<ItemDto> getItemList(HttpServletRequest request){
        int agentUserId = (int) request.getAttribute("agentUserId");
        return itemRepository.findAllByAgent_Id(agentUserId).stream().map(ItemMapper.toDtoFunction).toList();
    }
}
