package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.CrimeType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CrimeTypeRepository extends JpaRepository<CrimeType, Long> {
    // Find crime types by crimeName or description
   // CrimeType findByName(String name); // Find a crime type by its crimeName
}
