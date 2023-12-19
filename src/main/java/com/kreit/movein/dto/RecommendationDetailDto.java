package com.kreit.movein.dto;

import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RecommendationDetailDto(
        Integer id,
        Integer filterCardId,
        String recommendationReason,
        String itemDiagnosisSummary,
        String itemNotes,
        String filter1Score,
        String filter1Comment,
        List<String> filter1QualifiedIssue,
        String filter2Score,
        String filter2Comment,
        List<String> filter2QualifiedIssue,
        String filter3Score,
        String filter3Comment,
        List<String> filter3QualifiedIssue,
        String filter4Score,
        String filter4Comment,
        List<String> filter4QualifiedIssue,
        String filter5Score,
        String filter5Comment,
        List<String> filter5QualifiedIssue,
        ItemDto item,
        AgentCardDto agent
) {
}
