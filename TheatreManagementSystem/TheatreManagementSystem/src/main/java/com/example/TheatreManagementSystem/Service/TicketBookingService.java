package com.example.TheatreManagementSystem.Service;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TheatreManagementSystem.Model.ShowTime;
import com.example.TheatreManagementSystem.Model.TicketBooking;
import com.example.TheatreManagementSystem.Model.User1;
import com.example.TheatreManagementSystem.Repository.ShowTimeRepo;
import com.example.TheatreManagementSystem.Repository.TicketBookingRepo;

@Service
public class TicketBookingService {
@Autowired
private TicketBookingRepo ticketBookingRepo;
@Autowired
private UserService userService;
@Autowired
private ShowTimeRepo showTimeRepo;

public TicketBooking makeBooking(Long showtimeId, int numberOfTickets) {
    Optional<ShowTime> showtime = showTimeRepo.findById(showtimeId);
    if (showtime.isPresent()) {
        ShowTime s = showtime.get();
        if (s.getAvailableSeats() >= numberOfTickets) {
            s.setAvailableSeats(s.getAvailableSeats() - numberOfTickets);
            showTimeRepo.save(s);
            
            TicketBooking booking = new TicketBooking();
            booking.setShowtime(s);
            booking.setNumberOfTickets(numberOfTickets);
            
            // Assuming you have the current user in the session
            User1 currentUser = userService.getLoggedInUser();
            booking.setUser(currentUser);

            return ticketBookingRepo.save(booking);
        }
    }
    return null;  
}


public List<TicketBooking> getAllBookings() {
	return ticketBookingRepo.findAll();
   
}

public List<TicketBooking> getBookingsByUser(User1 user) {
    return ticketBookingRepo.findByUser(user);
}

}
