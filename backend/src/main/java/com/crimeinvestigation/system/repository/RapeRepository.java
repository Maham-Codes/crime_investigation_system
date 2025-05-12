package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Rape;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RapeRepository extends JpaRepository<Rape, Integer> {

    List<Rape> findByRapeType(String rapeType);

//    List<SH_and_Rape> findByDate_Time(LocalDateTime dateTime);
//    List<SH_and_Rape> findByDate_TimeBefore(LocalDateTime dateTime);
//    List<SH_and_Rape> findByDate_TimeAfter(LocalDateTime dateTime);
//    List<SH_and_Rape> findByDate_TimeBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
//
//    List<SH_and_Rape> findByRapeTypeAndDate_TimeAfter(String rapeType, LocalDateTime dateTime);
}

