package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Theft;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheftRepository extends JpaRepository<Theft, Integer> {

//    // Search by stolen item description (exact match)
//    List<Theft> findByStolenItemDescription(String stolenItemDescription);
//
//    // Search by stolen item description (partial match)
//    List<Theft> findByStolenItemDescriptionContaining(String stolenItemDescription);
//
//    // Search by loss amount (greater than, less than, or equal to)
//    List<Theft> findByLossAmountGreaterThan(double amount);
//    List<Theft> findByLossAmountLessThan(double amount);
//    List<Theft> findByLossAmountBetween(double minAmount, double maxAmount);
//
//    // Search by CCTV presence (true or false)
//    List<Theft> findByCCTVPresenceTrue();  // Theft cases where CCTV was present
//    List<Theft> findByCCTVPresenceFalse(); // Theft cases where CCTV was not present
//
//    // Search by crowd density (greater than, less than, or equal to)
//    List<Theft> findByCrowdDensityGreaterThan(int density);
//    List<Theft> findByCrowdDensityLessThan(int density);
//    List<Theft> findByCrowdDensityBetween(int minDensity, int maxDensity);
//
//    // Combined queries
//    List<Theft> findByLossAmountGreaterThanAndCCTVPresenceTrue(double amount, boolean CCTVPresence);
//    List<Theft> findByStolenItemDescriptionContainingAndLossAmountBetween(String description, double minAmount, double maxAmount);
}

