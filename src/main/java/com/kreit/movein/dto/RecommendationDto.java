package com.kreit.movein.dto;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

import java.util.List;

public record RecommendationDto(
        Integer id,
        @NotNull
        Integer filterCardId,
        @NotNull
        Integer itemId,
        @NotNull
        String recommendationReason,
        @NotNull
        String itemDiagnosisSummary,
        @NotNull
        String itemNotes,
        @NotNull
        String filter1Score,
        @NotNull
        String filter1Comment,
        @NotNull
        List<String> filter1QualifiedIssue,
        @NotNull
        String filter2Score,
        @NotNull
        String filter2Comment,
        @NotNull
        List<String> filter2QualifiedIssue,
        @NotNull
        String filter3Score,
        @NotNull
        String filter3Comment,
        @NotNull
        List<String> filter3QualifiedIssue,
        @NotNull
        String filter4Score,
        @NotNull
        String filter4Comment,
        @NotNull
        List<String> filter4QualifiedIssue,
        @NotNull
        String filter5Score,
        @NotNull
        String filter5Comment,
        @NotNull
        List<String> filter5QualifiedIssue
) {
}
