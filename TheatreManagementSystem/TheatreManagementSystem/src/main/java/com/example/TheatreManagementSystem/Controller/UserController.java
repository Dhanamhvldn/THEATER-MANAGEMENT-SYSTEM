package com.example.TheatreManagementSystem.Controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestParam;

import com.example.TheatreManagementSystem.Model.User1;
import com.example.TheatreManagementSystem.Service.UserService;

@Controller

public class UserController {
	  @Autowired 
	private  UserService userService;

	  
	    public UserController(UserService userService) {
	        this.userService = userService;
	    }

	    @GetMapping("/")
	    public String home() {
	        return "index"; // Ensure 'index.html' exists in 'templates/' folder
	    }

	    @GetMapping("/login")
	    public String loginPage() {
	        return "login"; // Ensure 'login.html' exists in 'templates/' folder
	    }

	    @PostMapping("/login-save")
	    public String login(@RequestParam("username") String username, 
	                        @RequestParam("password") String password, 
	                        Model model) {
	        User1 user = userService.validateUser(username, password);
	        if (user != null) {
	            model.addAttribute("user", user); // Pass user info to the dashboard
	            return "redirect:/dashboard"; // Redirect to the dashboard on successful login
	        } else {
	            model.addAttribute("error", "Invalid username or password");
	            return "login"; // Show the login page again with an error message
	        }
	    }

	    @GetMapping("/dashboard")
	    public String dashboard(Model model) {
	        List<String> options = Arrays.asList("Ticket Booking", "Showtimes", "My Profile", "Logout");
	        
	        // Prepare options with URL-friendly names
	        Map<String, String> dashboardOptions = options.stream()
	                .collect(Collectors.toMap(
	                    option -> option, // Key: original name
	                    option -> ((String) option).toLowerCase().replace(" ", "-") // Value: processed name
	                ));
	        
	        model.addAttribute("dashboardOptions", dashboardOptions);
	        return "dashboard";
	    }




	    @GetMapping("/register")
	    public String registerPage(Model model) {
	        model.addAttribute("user", new User1()); // New user object for registration
	        return "register"; // Ensure 'register.html' exists in 'templates/' folder
	    }

	    @PostMapping("/register")
	    public String registerUser(@ModelAttribute User1 user) {
	        userService.registerUser(user); // Save the user data
	        return "redirect:/login"; // Redirect to the login page after successful registration
	    }



	    @GetMapping("/logout")
	    public String logout() {
	        return "redirect:/login"; // Redirect to login on logout
	    }
	}
