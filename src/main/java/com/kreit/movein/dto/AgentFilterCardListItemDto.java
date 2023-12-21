package com.kreit.movein.dto;

import com.kreit.movein.enumeration.FilterCardStatusEnum;

import java.time.LocalDate;
import java.util.List;

public interface AgentFilterCardListItemDto {
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
    Boolean getDidSuggestAlready();
    Boolean getIsConsultationRequested();
}
