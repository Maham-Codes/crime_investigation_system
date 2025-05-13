package com.crimeinvestigation.system.repository;

import com.crimeinvestigation.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByEmail(String email);

    Optional<User> findByUsername(String username);
    Optional<User> findByFirstName(String firstName);
}
