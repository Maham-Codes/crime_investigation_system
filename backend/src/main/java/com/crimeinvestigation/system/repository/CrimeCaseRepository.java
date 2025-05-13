package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.enums.CaseStatus;
import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.CrimeType;
import com.crimeinvestigation.system.model.Investigator;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeCaseRepository extends JpaRepository<CrimeCase, Long> {

    // Find all crime cases by crime type
    List<CrimeCase> findByCrimeType(CrimeType crimeType);

    // Find all cases by location
    List<CrimeCase> findByLocation(String location);

    // Find all cases with a specific case status (e.g., Open, Closed)
    List<CrimeCase> findByCaseStatus(CaseStatus caseStatus);

    List<CrimeCase> findByInvestigatorID(Investigator investigator);

}
