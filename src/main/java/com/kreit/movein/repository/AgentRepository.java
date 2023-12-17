package com.kreit.movein.repository;

import com.kreit.movein.entity.Agent;
import com.kreit.movein.entity.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AgentRepository extends JpaRepository<Agent, Integer> {
    Optional<Agent> findByLoginIdIsAndPasswordIs(String loginId, String password);
}
