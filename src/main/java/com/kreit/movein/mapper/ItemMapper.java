package com.kreit.movein.mapper;

import com.kreit.movein.dto.AgentDto;
import com.kreit.movein.dto.ItemDto;
import com.kreit.movein.entity.Agent;
import com.kreit.movein.entity.Item;

import java.util.Base64;
import java.util.function.Function;

public class ItemMapper {
    public static Function<Item, ItemDto> toDtoFunction = entity -> {
        String base64Photo = null;
        try {
            base64Photo = Base64.getEncoder().encodeToString(entity.getPhoto().getBytes(1, (int) entity.getPhoto().length()));
        } catch (Exception e) {
            System.err.println(String.format("Failed to read blob. e : %s, msg : %s", e.getClass(), e.getMessage()));
        }
        return new ItemDto(
                entity.getId(),
                entity.getHouseType(),
                entity.getName(),
                entity.getRegion(),
                entity.getAddress(),
                base64Photo,
                entity.getDedicatedArea(),
                entity.getSupplyArea(),
                entity.getRoomCount(),
                entity.getToiletCount(),
                entity.getFloor(),
                entity.getBuildingFloor(),
                entity.getMainSpaceDirection(),
                entity.getApprovalDate(),
                entity.getRegistrationDate(),
                entity.getDeposit(),
                entity.getMonthlyRent(),
                entity.getMaintenanceCost(),
                entity.getMonthlyCost(),
                entity.getCostAdjustability(),
                entity.getMinimumMoveInDate(),
                entity.getMaximumMoveInDate(),
                entity.getCreatedAt().toLocalDate()
        );
    };
}
