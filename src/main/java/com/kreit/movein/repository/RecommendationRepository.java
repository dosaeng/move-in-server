package com.kreit.movein.repository;

import com.kreit.movein.entity.Recommendation;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RecommendationRepository extends JpaRepository<Recommendation, Integer> {
    @EntityGraph(attributePaths = {"item", "item.agent", "consultation"}, type = EntityGraph.EntityGraphType.LOAD)
    List<Recommendation> findAllByFilterCard_Id(int filterCardId);
    @EntityGraph(attributePaths = {"item", "item.agent", "consultation"}, type = EntityGraph.EntityGraphType.LOAD)
    Optional<Recommendation> findByIdAndFilterCard_Id(int id, int filterCardId);
}
