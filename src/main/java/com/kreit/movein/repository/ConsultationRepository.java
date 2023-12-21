package com.kreit.movein.repository;

import com.kreit.movein.entity.Consultation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ConsultationRepository extends JpaRepository<Consultation, Integer> {

    @Query("SELECT c FROM Consultation c JOIN c.recommendation.item JOIN c.recommendation.item.agent WHERE c.recommendation.filterCard.appUser.id = :appUserId")
    List<Consultation> findAllConsultationListByAppUserId(int appUserId);
}
