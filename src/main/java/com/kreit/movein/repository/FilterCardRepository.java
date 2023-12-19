package com.kreit.movein.repository;

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
    @Query("SELECT fc.id as id, fc.name as name, fc.familyType as familyType, fc.maximumDeposit as maximumDeposit, fc.maximumMonthlyCost as maximumMonthlyCost, fc.minimumMonthlyCost as minimumMonthlyCost, fc.costPreferenceType as costPreferenceType, fc.preferredRegion as preferredRegion, fc.preferredVillage as preferredVillage, fc.itemHouseType as itemHouseType, (SELECT COUNT(*) FROM Recommendation rc WHERE rc.filterCard.id = fc.id) as recommendationCount FROM FilterCard fc WHERE fc.appUser.id = :appUserId ")
    List<FilterCardListItemDto> findAllWithRecommendationCount(int appUserId);

    Optional<FilterCard> findByIdAndAppUser_Id(int id, int appUserId);

    List<FilterCard> findAllByStatus(FilterCardStatusEnum status);
}
