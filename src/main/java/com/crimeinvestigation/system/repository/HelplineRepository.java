package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Helpline;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HelplineRepository extends JpaRepository<Helpline, Integer> {
    // No need to write any methods for basic CRUD
}

