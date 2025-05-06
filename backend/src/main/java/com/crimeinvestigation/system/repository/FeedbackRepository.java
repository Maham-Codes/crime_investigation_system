package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Integer> {
    // You can add custom query methods if needed
}
