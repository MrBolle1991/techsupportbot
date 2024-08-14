package com.example.techsupportbot.service;

import com.example.techsupportbot.model.UserEntity;
import com.example.techsupportbot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service responsible for handling user-related operations.
 */
@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    /**
     * Default constructor.
     */
    public UserService() {}

    /**
     * Saves a user entity after encoding their password.
     *
     * @param userEntity the user entity to save
     * @return the saved user entity
     */
    public UserEntity save(UserEntity userEntity) {
        System.out.println("Saving user: " + userEntity.getUsername());
        userEntity.setPassword(passwordEncoder.encode(userEntity.getPassword()));
        return userRepository.save(userEntity);
    }

    /**
     * Checks if a username already exists in the repository.
     *
     * @param username the username to check
     * @return true if the username exists, false otherwise
     */
    public boolean usernameExists(String username) {
        return userRepository.findByUsername(username).isPresent();
    }

    /**
     * Finds a user by their username.
     *
     * @param username the username of the user
     * @return an Optional containing the user entity if found, or empty if not found
     */
    public Optional<UserEntity> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }
}
