package com.example.TheatreManagementSystem.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashBoardController {
	
	 

	 @GetMapping("/dashboards")
	    public String getDashboardPage(Model model) {
	        model.addAttribute("options", new String[]{"Ticket Booking", "Showtimes", "User Profile", "Contact Us"});
	        return "dashboard"; // Ensure 'dashboard.html' exists in 'templates' folder
	    }

	    // Redirect to ticket booking page
	    @GetMapping("/dashboard/book-tickets")
	    public String redirectToTicketBooking() {
	        return "redirect:/ticket-booking"; // Redirect to the route handled by TicketBookingController
	    }

	    // Redirect to showtimes page
	    @GetMapping("/dashboard/showtimes")
	    public String redirectToShowtimes() {
	        return "redirect:/showtimes"; // Redirect to the route handled by ShowTimeController
	    }

	    // Redirect to user profile page
	    @GetMapping("/dashboard/booking-history")
	    public String redirectToUserProfile() {
	        return "redirect:/booking-history"; // Redirect to the route handled by UserController
	    }

	    // Redirect to contact us page
	    @GetMapping("/dashboard/contact-us")
	    public String redirectToContactUs() {
	        return "redirect:/contact-us"; // Redirect to the appropriate route
	    }
}
