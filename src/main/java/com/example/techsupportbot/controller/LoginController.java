package com.example.techsupportbot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for handling login-related requests.
 */
@Controller
public class LoginController {

    /**
     * Default constructor.
     */
    public LoginController() {}

    /**
     * Displays the login page.
     *
     * @return the name of the login page view
     */
    @GetMapping("/login")
    public String loginPage() {
        return "login";
    }
}
