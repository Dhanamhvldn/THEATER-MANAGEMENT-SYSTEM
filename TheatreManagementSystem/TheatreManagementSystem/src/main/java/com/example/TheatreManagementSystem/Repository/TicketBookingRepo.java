package com.example.TheatreManagementSystem.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TheatreManagementSystem.Model.TicketBooking;
import com.example.TheatreManagementSystem.Model.User1;
@Repository
public interface TicketBookingRepo extends JpaRepository<TicketBooking, Long>{
	 List<TicketBooking> findByUser(User1 user);
}
