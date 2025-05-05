package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.LawsAndPunishments;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LawsAndPunishmentsRepository extends JpaRepository<LawsAndPunishments, String> {
    // Basic CRUD operations are available
}