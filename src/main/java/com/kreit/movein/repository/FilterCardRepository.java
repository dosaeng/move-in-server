package com.kreit.movein.repository;

import com.kreit.movein.dto.FilterCardListItemDto;
import com.kreit.movein.entity.FilterCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FilterCardRepository extends JpaRepository<FilterCard, Integer> {
    @Query("SELECT new com.kreit.movein.dto.FilterCardListItemDto(fc.id, fc.name, fc.familyType, fc.maximumDeposit, fc.maximumMonthlyCost, fc.minimumMonthlyCost, fc.costPreferenceType, fc.preferredRegion, fc.preferredVillage, fc.itemHouseType, (SELECT COUNT(*) FROM Recommendation rc WHERE rc.filterCard.id = fc.id)) FROM FilterCard fc WHERE fc.appUser.id = :appUserId ")
    List<FilterCardListItemDto> findAllWithRecommendationCount(int appUserId);

    Optional<FilterCard> findByIdAndAppUser_Id(int id, int appUserId);

    List<FilterCard> findAllByIsDoneIsFalse();
}
