package com.example.techsupportbot.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;

/**
 * Configuration class for defining security-related beans.
 */
@Configuration
public class SecurityBeansConfig {

    /**
     * Default constructor.
     */
    public SecurityBeansConfig() {}

    /**
     * Provides a custom AuthenticationFailureHandler bean.
     *
     * @return the AuthenticationFailureHandler bean
     */
    @Bean
    public AuthenticationFailureHandler authenticationFailureHandler() {
        return new SimpleUrlAuthenticationFailureHandler();
    }
}
