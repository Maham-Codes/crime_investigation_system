package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Investigator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface InvestigatorRepository extends JpaRepository<Investigator, Integer> {
    Optional<Investigator> findByEmail(String email);
}
