package com.example.techsupportbot.repository;

import com.example.techsupportbot.model.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * Repository interface for accessing user data in the database.
 */
public interface UserRepository extends JpaRepository<UserEntity, Long> {

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return an Optional containing the user entity if found, or empty if not found
     */
    Optional<UserEntity> findByUsername(String username);
}
