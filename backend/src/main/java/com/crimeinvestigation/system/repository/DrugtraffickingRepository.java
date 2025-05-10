package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Drugtrafficking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DrugtraffickingRepository extends JpaRepository<Drugtrafficking, Long> {

    // Find all by drug type (e.g., "Cocaine")
    List<Drugtrafficking> findByDrugType(String drugType);

    // Find all by quantity (e.g., "5kg")
    List<Drugtrafficking> findByQuantity(String quantity);

    // Find all by storage method (e.g., "hidden compartment")
    List<Drugtrafficking> findByStorageMethod(String storageMethod);

    // Combined filters
    List<Drugtrafficking> findByDrugTypeAndStorageMethod(String drugType, String storageMethod);

    // Find all where drugType contains a keyword (e.g., "meth")
    List<Drugtrafficking> findByDrugTypeContaining(String keyword);
}

