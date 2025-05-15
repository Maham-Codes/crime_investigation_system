package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> { // Assuming User ID is Integer
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username); // You already had this
    // Optional<User> findByFirstName(String firstName); // You had this, keep if needed
}