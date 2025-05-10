package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Harassment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HarassmentRepository extends JpaRepository<Harassment, Long> {

    // Find all by type of harassment (e.g., verbal, physical)
    List<Harassment> findByHarassmentType(String harassmentType);

    // Find by place type (e.g., workplace, school)
    List<Harassment> findByPlaceType(String placeType);

    // Find by language used in the harassment
    List<Harassment> findByLanguageUsed(String language);

    // Find all cases where threats were involved
    List<Harassment> findByThreatsInvolvedTrue();

    // Find all cases where no threats were involved
    List<Harassment> findByThreatsInvolvedFalse();

    // Find by relation to harasser (e.g., colleague, stranger, relative)
    List<Harassment> findByRelationToHarasser(String relation);

    // Combined filter: harassment type and place
    List<Harassment> findByHarassmentTypeAndPlaceType(String type, String place);

    // Combined: threats involved + place
    List<Harassment> findByThreatsInvolvedTrueAndPlaceType(String place);
}
