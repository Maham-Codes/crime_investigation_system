package com.crimeinvestigation.system.dao;

import com.crimeinvestigation.system.model.Criminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CriminalRepository extends JpaRepository<Criminal, Integer> {

}
