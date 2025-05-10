package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Murder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalTime;
import java.util.List;

@Repository
public interface MurderRepository extends JpaRepository<Murder, Long> {

    List<Murder> findByTimeOfDeath(LocalTime timeOfDeath);
    List<Murder> findByTimeOfDeathBefore(LocalTime time);
    List<Murder> findByTimeOfDeathAfter(LocalTime time);
    List<Murder> findByTimeOfDeathBetween(LocalTime start, LocalTime end);

    List<Murder> findByVictimName(String victimName);
    List<Murder> findByVictimNameContaining(String keyword); // partial match (e.g., "John")

    List<Murder> findByBodyRecoveredTrue();   // only where body was recovered
    List<Murder> findByBodyRecoveredFalse();  // only where body was not recovered

    List<Murder> findByAutopsy(String autopsy);
    List<Murder> findByAutopsyContaining(String keyword);

    List<Murder> findByVictimNameAndBodyRecovered(String victimName, boolean bodyRecovered);
    List<Murder> findByBodyRecoveredAndTimeOfDeathAfter(boolean bodyRecovered, LocalTime time);
    List<Murder> findByVictimNameContainingAndAutopsyContaining(String nameKeyword, String autopsyKeyword);
}

