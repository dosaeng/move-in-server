package com.kreit.movein.repository;

import com.kreit.movein.dto.AgentFilterCardListItemDto;
import com.kreit.movein.dto.FilterCardListItemDto;
import com.kreit.movein.entity.FilterCard;
import com.kreit.movein.enumeration.FilterCardStatusEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilterCardRepository extends JpaRepository<FilterCard, Integer> {
    @Query("SELECT fc.id as id, fc.name as name, fc.familyType as familyType, fc.maximumDeposit as maximumDeposit, fc.maximumMonthlyCost as maximumMonthlyCost, fc.minimumMonthlyCost as minimumMonthlyCost, fc.costPreferenceType as costPreferenceType, fc.preferredRegion as preferredRegion, fc.preferredVillage as preferredVillage, fc.itemHouseType as itemHouseType, (SELECT COUNT(*) FROM Recommendation rc WHERE rc.filterCard.id = fc.id) as recommendationCount, fc.status as status, fc.recommendationDueDate as recommendationDueDate FROM FilterCard fc WHERE fc.appUser.id = :appUserId ")
    List<FilterCardListItemDto> findAllWithRecommendationCount(int appUserId);

    Optional<FilterCard> findByIdAndAppUser_Id(int id, int appUserId);

    @Query("SELECT fc.id as id, fc.name as name, fc.familyType as familyType, fc.maximumDeposit as maximumDeposit, fc.maximumMonthlyCost as maximumMonthlyCost, fc.minimumMonthlyCost as minimumMonthlyCost, fc.costPreferenceType as costPreferenceType, fc.preferredRegion as preferredRegion, fc.preferredVillage as preferredVillage, fc.itemHouseType as itemHouseType, (SELECT COUNT(*) FROM Recommendation rc WHERE rc.filterCard.id = fc.id) as recommendationCount, fc.status as status, fc.recommendationDueDate as recommendationDueDate,  (CASE WHEN (COUNT(rc) != 0) then true else false end) as didSuggestAlready, (SELECT CASE WHEN (COUNT(*) != 0) then true else false end FROM Consultation c WHERE c.recommendation.filterCard.id = fc.id AND c.status = 'WAITING') as isConsultationRequested FROM FilterCard fc LEFT JOIN fc.recommendations rc WHERE fc.status = :status AND rc.item.agent.id = :agentId")
    List<AgentFilterCardListItemDto> findAllByStatus(FilterCardStatusEnum status, int agentId);
}
