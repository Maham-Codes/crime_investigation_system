package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Kidnapping;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KidnappingRepository extends JpaRepository<Kidnapping, Integer> {
}
