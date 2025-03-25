package com.example.TheatreManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TheatreManagementSystem.Model.Movie;
import com.example.TheatreManagementSystem.Model.ShowTime;
import com.example.TheatreManagementSystem.Service.MovieService;
import com.example.TheatreManagementSystem.Service.ShowTimeService;

import jakarta.validation.Valid;

@Controller
public class ShowTimeController {
	private final ShowTimeService showtimeService;
    private final MovieService movieService;

    @Autowired
    public ShowTimeController(ShowTimeService showtimeService, MovieService movieService) {
        this.showtimeService = showtimeService;
        this.movieService = movieService;
    }

//    @GetMapping("/showtimes")
//    public String getShowtimesPage(Model model) {
//    	 model.addAttribute("showtimes", showtimeService.getAllShowtimes());
//         model.addAttribute("movies", movieService.getAllMovies());
//         model.addAttribute("showtime", new ShowTime()); 
//        model.addAttribute("showtimes", new String[]{"Movie 1 - 10:00 AM", "Movie 2 - 1:00 PM", "Movie 3 - 6:00 PM"});
//        return "showtimes"; // Ensure 'showtimes.html' exists in 'templates' folder
//    }
   
    @GetMapping("/showtimes")
    public String getShowtimesPage(Model model) {
        model.addAttribute("showtimes", showtimeService.getAllShowtimes());
        model.addAttribute("movies", movieService.getAllMovies());
        model.addAttribute("showtime", new ShowTime()); 
        return "showtimes"; 
    }

   
    @PostMapping("/showtimes")
    public String addShowtime(@ModelAttribute("showTime") @Valid ShowTime showTime, BindingResult result, Model model) {
        if (result.hasErrors()) {
            model.addAttribute("movies", movieService.getAllMovies());
            model.addAttribute("showtimes", showtimeService.getAllShowtimes());
            return "redirect:/showtimes"; // Return to the showtimes page on validation errors
        }

        // Fetch the Movie object by ID to avoid type mismatch
        Movie movie = movieService.getMovie(showTime.getMovie().getId());
        showTime.setMovie(movie);

        showtimeService.addShowtime(showTime);
        return "redirect:/showtimes";
    }

}
