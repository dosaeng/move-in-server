package com.kreit.movein.repository;

import com.kreit.movein.dto.FilterCardRecommendationCountDto;
import com.kreit.movein.dto.FilterCardSuggestionConsultationDto;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.enumeration.FilterCardStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface FilterCardRepository extends JpaRepository<FilterCard, Integer> {
    List<FilterCard> findAllByAppUser_Id(int appUserId);
    List<FilterCard> findAllByStatus(FilterCardStatusEnum status);

    Optional<FilterCard> findByIdAndAppUser_Id(int id, int appUserId);

    @Query("SELECT new com.kreit.movein.dto.FilterCardRecommendationCountDto(fc.id, COUNT(rc)) FROM FilterCard fc LEFT JOIN fc.recommendations rc WHERE fc.id IN (:filterCardIds) GROUP BY fc.id")
    List<FilterCardRecommendationCountDto> aggregateWithRecommendationCount(Collection<Integer> filterCardIds);

    @Query("SELECT new com.kreit.movein.dto.FilterCardSuggestionConsultationDto(fc.id, CASE WHEN COUNT(i) > 0 THEN TRUE ELSE FALSE END, CASE WHEN COUNT(c) > 0 THEN TRUE ELSE FALSE END)   FROM FilterCard fc LEFT JOIN fc.recommendations rc LEFT JOIN rc.item i LEFT JOIN rc.consultation c WHERE fc.id IN (:filterCardIds) AND i.agent.id = :agentId GROUP BY fc.id")
    List<FilterCardSuggestionConsultationDto> aggregateWithSuggestionAndConsultation(Collection<Integer> filterCardIds, int agentId);
}
