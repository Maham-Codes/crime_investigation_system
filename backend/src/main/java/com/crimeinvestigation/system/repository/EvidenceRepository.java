package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Evidence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EvidenceRepository extends JpaRepository<Evidence, Integer> {
    // You can add custom query methods if needed
}
