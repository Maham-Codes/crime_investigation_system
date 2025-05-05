package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Find user by email or username (you can adjust based on your user model's fields)
    Optional<User> findByEmail(String email);
    Optional<User> findByUsername(String username);
}
