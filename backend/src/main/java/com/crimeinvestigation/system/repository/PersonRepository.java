package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

    List<Person> findByName(String name);
    List<Person> findByNameContaining(String name);
    List<Person> findByCnic(String cnic);
    List<Person> findByGender(String gender);
    List<Person> findByOccupation(String occupation);
    List<Person> findByContactNumber(String contact_number);

    List<Person> findByDobBefore(LocalDate dob);
    List<Person> findByDobAfter(LocalDate dob);
    List<Person> findByDobBetween(LocalDate startDate, LocalDate endDate);

    List<Person> findByNameAndFatherName(String name, String fatherName);
    List<Person> findByGenderAndOccupation(String gender, String occupation);
}
