package com.kreit.movein.mapper;

import com.kreit.movein.dto.RecommendationDto;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.entity.Item;
import com.kreit.movein.entity.Recommendation;

import java.util.function.Function;

public class RecommendationMapper {
    public static Function<RecommendationDto, Recommendation> toEntityMapper = dto -> Recommendation.builder()
            .item(Item.builder().id(dto.itemId()).build())
            .filterCard(FilterCard.builder().id(dto.filterCardId()).build())
            .recommendationReason(dto.recommendationReason())
            .itemDiagnosisSummary(dto.itemDiagnosisSummary())
            .itemNotes(dto.itemNotes())
            .filter1Score(dto.filter1Score())
            .filter1Comment(dto.filter1Comment())
            .filter1QualifiedIssue(dto.filter1QualifiedIssue())
            .filter2Score(dto.filter2Score())
            .filter2Comment(dto.filter2Comment())
            .filter2QualifiedIssue(dto.filter2QualifiedIssue())
            .filter3Score(dto.filter3Score())
            .filter3Comment(dto.filter3Comment())
            .filter3QualifiedIssue(dto.filter3QualifiedIssue())
            .filter4Score(dto.filter4Score())
            .filter4Comment(dto.filter4Comment())
            .filter4QualifiedIssue(dto.filter4QualifiedIssue())
            .filter5Score(dto.filter5Score())
            .filter5Comment(dto.filter5Comment())
            .filter5QualifiedIssue(dto.filter5QualifiedIssue())
            .build();
}
