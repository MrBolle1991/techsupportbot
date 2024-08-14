package com.example.techsupportbot.controller;

import com.example.techsupportbot.model.UserEntity;
import com.example.techsupportbot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller responsible for handling user-related requests, including registration.
 */
@Controller
@RequestMapping("/register")
public class UserController {
	
	/**
     * Default constructor.
     */
	public UserController( ) {}

    @Autowired
    private UserService userService;

    /**
     * Displays the registration page.
     *
     * @param model the model to pass attributes to the view
     * @return the name of the registration page view
     */
    @GetMapping
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new UserEntity());
        return "register";
    }

    /**
     * Processes user registration.
     *
     * @param confirmPassword      the confirmation of the user's password
     * @param confirmEmail         the confirmation of the user's email
     * @param preferredLanguage    the user's preferred language
     * @param user                 the user object containing registration details
     * @param model                the model to pass attributes to the view
     * @return a redirect to the login page if successful, otherwise returns the registration page view
     */
    @PostMapping
    public String registerNewUser(@RequestParam("confirmPassword") String confirmPassword,
                                  @RequestParam("confirmEmail") String confirmEmail,
                                  @RequestParam("preferredLanguage") String preferredLanguage,
                                  @ModelAttribute("user") UserEntity user, Model model) {
        if (!user.getPassword().equals(confirmPassword)) {
            model.addAttribute("error", "Passwords do not match");
            return "register";
        }
        if (!user.getEmail().equals(confirmEmail)) {
            model.addAttribute("error", "Emails do not match");
            return "register";
        }
        if (userService.usernameExists(user.getUsername())) {
            model.addAttribute("error", "Username already exists");
            return "register";
        } else {
            user.setPreferredLanguage(preferredLanguage);
            userService.save(user);
            model.addAttribute("success", true);
            return "redirect:/login?success=true";
        }
    }
}
