package com.example.TheatreManagementSystem.Controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TheatreManagementSystem.Model.TicketBooking;

import com.example.TheatreManagementSystem.Service.MovieService;
import com.example.TheatreManagementSystem.Service.ShowTimeService;
import com.example.TheatreManagementSystem.Service.TicketBookingService;


@Controller
public class TicketBookingController {

	@Autowired
	private MovieService movieService;
	@Autowired
	private TicketBookingService ticketBookingService;
	@Autowired
	private ShowTimeService showTimeService;

	
	


	@GetMapping("/bookings")
	public String showTicketBookingPage(Model model) {
	    model.addAttribute("ticketBooking", new TicketBooking());
	    model.addAttribute("movies", movieService.getAllMovies());
	    model.addAttribute("showtimes", showTimeService.getAllShowtimes());
	    return "ticketbooking";
	}


//	@GetMapping("/ticket-booking")
//    public String getBookingsPage(Model model) {
//        model.addAttribute("bookings", ticketBookingService.getAllBookings());
//        model.addAttribute("showtimes", showTimeService.getAllShowtimes());
//        return "ticket-booking"; 
//    }

	@PostMapping("/bookings")
	public String bookTicket(@ModelAttribute TicketBooking ticketBooking, Model model) {
	    try {
	        System.out.println("TicketBooking: " + ticketBooking);
	        TicketBooking bookedTicket = ticketBookingService.makeBooking(ticketBooking.getShowtime().getId(), ticketBooking.getNumberOfTickets());
	        System.out.println("BookedTicket: " + bookedTicket);
	        model.addAttribute("ticketBooking", bookedTicket);
	        model.addAttribute("bookingConfirmation", true);
	    } catch (Exception e) {
	        model.addAttribute("bookingConfirmation", false);
	        System.err.println("Error during booking: " + e.getMessage());
	    }
	    return "ticketbooking";
	}
//	 @GetMapping("/booking-history")
//	    public String getBookingHistory(Model model) {
//	        // Get the currently logged-in user
//	        User1 loggedInUser = userService.getLoggedInUser();
//
//	        // Fetch booking history for the user
//	        List<TicketBooking> bookingHistory = ticketBookingService.getBookingsByUser(loggedInUser);
//
//	        // Pass data to the view
//	        model.addAttribute("bookingHistory", bookingHistory);
//
//	        return "booking-history";
//	    }
	
	

}
