package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.SH_and_Rape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SHAndRapeRepository extends JpaRepository<SH_and_Rape, Integer> {

    List<SH_and_Rape> findByRapeType(String rapeType);

    List<SH_and_Rape> findByDate_Time(LocalDateTime dateTime);
    List<SH_and_Rape> findByDate_TimeBefore(LocalDateTime dateTime);
    List<SH_and_Rape> findByDate_TimeAfter(LocalDateTime dateTime);
    List<SH_and_Rape> findByDate_TimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);

    List<SH_and_Rape> findByRapeTypeAndDate_TimeAfter(String rapeType, LocalDateTime dateTime);
}

