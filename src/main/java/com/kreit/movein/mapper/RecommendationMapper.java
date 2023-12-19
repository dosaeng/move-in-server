package com.kreit.movein.mapper;

import com.kreit.movein.dto.*;
import com.kreit.movein.entity.Agent;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.entity.Item;
import com.kreit.movein.entity.Recommendation;

import java.sql.SQLException;
import java.util.Base64;
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

    public static RecommendationDetailDto toDetailDto(Recommendation entity, ItemDto item, AgentCardDto agent) {
        return new RecommendationDetailDto(
                entity.getId(),
                entity.getFilterCard().getId(),
                entity.getRecommendationReason(),
                entity.getItemDiagnosisSummary(),
                entity.getItemNotes(),
                entity.getFilter1Score(),
                entity.getFilter1Comment(),
                entity.getFilter1QualifiedIssue(),
                entity.getFilter2Score(),
                entity.getFilter2Comment(),
                entity.getFilter2QualifiedIssue(),
                entity.getFilter3Score(),
                entity.getFilter3Comment(),
                entity.getFilter3QualifiedIssue(),
                entity.getFilter4Score(),
                entity.getFilter4Comment(),
                entity.getFilter4QualifiedIssue(),
                entity.getFilter5Score(),
                entity.getFilter5Comment(),
                entity.getFilter5QualifiedIssue(),
                item,
                agent
        );
    }

    public static Function<Recommendation, RecommendedItemListDto> toRecommendedItemMapper = entity -> {
        String photoInBase64 = null;
        Item item = entity.getItem();
        Agent agent = item.getAgent();
        try {
            photoInBase64 = Base64.getEncoder().encodeToString(item.getPhoto().getBytes(1, (int) entity.getItem().getPhoto().length()));
        } catch (SQLException e) {
            System.err.println("Failed to read blob.");
        }
        return new RecommendedItemListDto(
                entity.getId(),
                item.getId(),
                item.getName(),
                photoInBase64,
                item.getDeposit(),
                item.getMonthlyRent(),
                item.getAddress(),
                item.getMinimumMoveInDate(),
                item.getCreatedAt().toLocalDate(),
                agent.getId(),
                agent.getName(),
                4.5f // temp
        );
    };
}
