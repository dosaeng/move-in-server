package com.kreit.movein.dto;

import com.kreit.movein.enumeration.FilterCardStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public interface FilterCardListItemDto {
    Integer getId();

    String getName();

    String getFamilyType();

    Long getMaximumDeposit();

    Long getMaximumMonthlyCost();

    Long getMinimumMonthlyCost();

    String getCostPreferenceType();

    String getPreferredRegion();

    String getPreferredVillage();

    List<String> getItemHouseType();

    Long getRecommendationCount();
    FilterCardStatusEnum getStatus();
    LocalDate getRecommendationDueDate();
}
