package com.example.techsupportbot.controller;

import com.example.techsupportbot.model.UserEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Controller responsible for handling requests to the home page.
 */
@Controller
public class HomeController {
    /**
     * Displays the home page.
     *
     * @param model the model to pass attributes to the view
     * @return the name of the home page view
     */
    @GetMapping("/home")
    public String home(Model model, @AuthenticationPrincipal UserEntity currentUser) {
        if (currentUser == null) {
            return "redirect:/login";  // Redirects to login if user is not authenticated
        }
        model.addAttribute("username", currentUser.getUsername());
        return "homeView";  // Make sure "home.html" or "home.jsp" exists in the templates directory
    }
}
