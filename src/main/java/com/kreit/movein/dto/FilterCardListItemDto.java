package com.kreit.movein.dto;

import com.kreit.movein.enumeration.FilterCardStatusEnum;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.time.LocalDate;
import java.util.List;

public record FilterCardListItemDto(
        Integer id,
        String name,
        String familyType,
        Long maximumDeposit,
        Long maximumMonthlyCost,
        Long minimumMonthlyCost,
        String costPreferenceType,
        String preferredRegion,
        String preferredVillage,
        List<String> itemHouseType,
        Long recommendationCount,
        FilterCardStatusEnum status,
        LocalDate recommendationDueDate
) {
}
