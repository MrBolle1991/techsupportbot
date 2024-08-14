package com.example.techsupportbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Utility class for handling password encoding and matching.
 */
@Configuration
public class PasswordEncoderUtil {

    /**
     * Default constructor.
     */
    public PasswordEncoderUtil() {}

    /**
     * Provides a custom PasswordEncoder bean.
     *
     * @return a PasswordEncoder configured for this application
     */
    @Bean
    public static PasswordEncoder customPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * Encodes the raw password using the specified password encoder.
     *
     * @param rawPassword the raw password to encode
     * @return the encoded password
     */
    public static String encodePassword(String rawPassword) {
        PasswordEncoder passwordEncoder = customPasswordEncoder();
        return passwordEncoder.encode(rawPassword);
    }

    /**
     * Checks if the raw password matches the encoded password.
     *
     * @param rawPassword the raw password
     * @param encodedPassword the encoded password
     * @return true if the passwords match, false otherwise
     */
    public static boolean matches(String rawPassword, String encodedPassword) {
        PasswordEncoder passwordEncoder = null;
        try {
            passwordEncoder = customPasswordEncoder();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}
