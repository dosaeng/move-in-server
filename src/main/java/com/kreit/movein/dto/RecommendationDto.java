package com.kreit.movein.dto;
import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

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
        String filter1QualifiedIssue,
        @NotNull
        String filter2Score,
        @NotNull
        String filter2Comment,
        @NotNull
        String filter2QualifiedIssue,
        @NotNull
        String filter3Score,
        @NotNull
        String filter3Comment,
        @NotNull
        String filter3QualifiedIssue,
        @NotNull
        String filter4Score,
        @NotNull
        String filter4Comment,
        @NotNull
        String filter4QualifiedIssue,
        @NotNull
        String filter5Score,
        @NotNull
        String filter5Comment,
        @NotNull
        String filter5QualifiedIssue
) {
}
