package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.CrimeCase;
import com.crimeinvestigation.system.model.TrackingStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrackingStatusRepository extends JpaRepository<TrackingStatus, Integer> {

    // 🔍 Find tracking statuses by caseID
    List<TrackingStatus> findByCaseID(CrimeCase caseID);

    // 🔍 Find all tracking statuses by update status
    List<TrackingStatus> findByUpdateStatus(String updateStatus);
}

