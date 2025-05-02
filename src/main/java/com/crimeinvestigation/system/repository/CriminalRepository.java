package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Integer> {

    // Get all criminals (already provided by JpaRepository: findAll())

    // Custom: Get all criminals with crimeType = rape
    List<Criminal> findByCrimeTypeIgnoreCase(String CrimeType);

    // Custom: Get all criminals by reputation
    List<Criminal> findByReputation(String reputation);

    // Custom: Get criminals by caseStatus (e.g. "under trial", "convicted")
    List<Criminal> findByCurrentStatus(String currentStatus);

    // Custom: Get criminals with multiple conditions
    List<Criminal> findByCrimeTypeAndNationality(String crimeType, String nationality);

}