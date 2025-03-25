package com.example.TheatreManagementSystem.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TheatreManagementSystem.Model.ShowTime;
import com.example.TheatreManagementSystem.Repository.ShowTimeRepo;
@Service
public class ShowTimeService {
	 private final ShowTimeRepo showtimeRepo;

	    @Autowired
	    public ShowTimeService(ShowTimeRepo showtimeRepo) {
	        this.showtimeRepo = showtimeRepo;
	    }

	    
	    public List<ShowTime> getAllShowtimes() {
	        return showtimeRepo.findAll();
	    }

	   
	    public void addShowtime(ShowTime showtime) {
	    	showtimeRepo.save(showtime);
	    }
}
