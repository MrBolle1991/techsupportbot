package com.example.techsupportbot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * The main entry point for the Tech Support Bot application.
 * This class initializes and launches the Spring Boot application.
 */
@SpringBootApplication
public class TechSupportBotApplication {

    /**
     * Default constructor.
     */
    public TechSupportBotApplication() {}

    /**
     * The main method that serves as the entry point for the Spring Boot application.
     *
     * @param args command-line arguments passed during the application startup
     */
    public static void main(String[] args) {
        SpringApplication.run(TechSupportBotApplication.class, args);
    }
    
}
