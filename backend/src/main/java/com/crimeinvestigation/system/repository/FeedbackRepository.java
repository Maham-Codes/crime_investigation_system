package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    // Aggregation query example
    @Query("SELECT AVG(f.rating) FROM Feedback f WHERE f.crimeCase.caseID = :caseId")
    Double findAverageRatingForCase(@Param("caseId") Long caseId);


}

