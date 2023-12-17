package com.kreit.movein.mapper;

import com.kreit.movein.dto.FilterCardDto;
import com.kreit.movein.entity.AppUser;
import com.kreit.movein.entity.FilterCard;

public class FilterCardMapper {
    public static FilterCard toEntity(FilterCardDto dto, int appUserId) {
        return FilterCard.builder()
                .name(dto.name())
                .familyType(dto.familyType())
                .petPresence(dto.petPresence())
                .minimumSize(dto.minimumSize())
                .minimumRoomCount(dto.minimumRoomCount())
                .minimumMoveInDate(dto.minimumMoveInDate())
                .maximumMoveInDate(dto.maximumMoveInDate())
                .maximumDeposit(dto.maximumDeposit())
                .maximumMonthlyCost(dto.maximumMonthlyCost())
                .minimumMonthlyCost(dto.minimumMonthlyCost())
                .costPreferenceType(dto.costPreferenceType())
                .preferredRegion(dto.preferredRegion())
                .preferredVillage(dto.preferredVillage())
                .favoritePlace1(dto.favoritePlace1())
                .favoritePlace2(dto.favoritePlace2())
                .favoritePlace3(dto.favoritePlace3())
                .itemHouseType(dto.itemHouseType())
                .itemHouseCondition(dto.itemHouseCondition())
                .itemWishList(dto.itemWishList())
                .appUser(AppUser.builder().id(appUserId).build())
                .build();
    }

    public static FilterCardDto toDto(FilterCard entity) {
        return new FilterCardDto(
                entity.getId(),
                entity.getName(),
                entity.getFamilyType(),
                entity.getPetPresence(),
                entity.getMinimumSize(),
                entity.getMinimumRoomCount(),
                entity.getMinimumMoveInDate(),
                entity.getMaximumMoveInDate(),
                entity.getMaximumDeposit(),
                entity.getMaximumMonthlyCost(),
                entity.getMinimumMonthlyCost(),
                entity.getCostPreferenceType(),
                entity.getPreferredRegion(),
                entity.getPreferredVillage(),
                entity.getFavoritePlace1(),
                entity.getFavoritePlace2(),
                entity.getFavoritePlace3(),
                entity.getItemHouseType(),
                entity.getItemHouseCondition(),
                entity.getItemWishList()
        );
    }
}
