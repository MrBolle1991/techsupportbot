package com.example.techsupportbot.config;

import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.boot.web.servlet.server.ConfigurableServletWebServerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Configuration class for server-related settings.
 */
@Configuration
public class ServerConfig implements WebServerFactoryCustomizer<ConfigurableServletWebServerFactory> {

    /**
     * Default constructor.
     */
    public ServerConfig() {}

    /**
     * Customizes the server configuration.
     *
     * @param factory the ConfigurableServletWebServerFactory to customize
     */
    @Override
    public void customize(ConfigurableServletWebServerFactory factory) {
        factory.setPort(25750);
    }
}
