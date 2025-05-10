package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.CyberCrime;
import com.crimeinvestigation.system.enums.CyberType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CyberCrimeRepository extends JpaRepository<CyberCrime, Long> {

    // Find all by cyber crime type
    List<CyberCrime> findByCyberType(CyberType cyberType);

    // Find by affected platform (e.g., Facebook, Gmail)
    List<CyberCrime> findByAffectedPlatform(String platform);

    // Find by target system (e.g., Windows Server, Android)
    List<CyberCrime> findByTargetSystem(String system);

    // Find all where a keyword is present in files accessed
    List<CyberCrime> findByFilesAccessedContaining(String keyword);

    // Find all with number of incidents greater than a threshold
    List<CyberCrime> findByNumberOfIncidentsGreaterThan(int threshold);

    // Find all where amount lost is greater than a given amount
    List<CyberCrime> findByAmountLostGreaterThan(double amount);

    // Combined filters (e.g., phishing attacks on a platform)
    List<CyberCrime> findByCyberTypeAndAffectedPlatform(CyberType type, String platform);

    // Combined filter: system targeted and money lost
    List<CyberCrime> findByTargetSystemAndAmountLostGreaterThan(String system, double amount);
}

