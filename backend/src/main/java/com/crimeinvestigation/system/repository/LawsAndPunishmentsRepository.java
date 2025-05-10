package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.LawsAndPunishments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LawsAndPunishmentsRepository extends JpaRepository<LawsAndPunishments, String> {
    // Basic CRUD operations are available
}