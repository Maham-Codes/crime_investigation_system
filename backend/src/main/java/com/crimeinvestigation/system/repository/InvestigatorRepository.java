package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Investigator;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InvestigatorRepository extends JpaRepository<Investigator, Integer> {
    Optional<Investigator> findByEmail(String email);
}
