package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Crime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CrimeRepository extends JpaRepository<Crime, Long> {
    // Custom queries can be added as needed
   // List<Crime> findByCrimeType(String crimeType); // Find all crimes of a particular type
   // List<Crime> findBySeverity(String severity); // Find crimes by severity
   // List<Crime> findByLocation(String location); // Find crimes by location
}
