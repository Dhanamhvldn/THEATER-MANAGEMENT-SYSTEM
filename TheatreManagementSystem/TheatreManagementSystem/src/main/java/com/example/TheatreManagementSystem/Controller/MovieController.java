package com.example.TheatreManagementSystem.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.TheatreManagementSystem.Model.Movie;
import com.example.TheatreManagementSystem.Service.MovieService;

import jakarta.validation.Valid;

@Controller
	public class MovieController {
@Autowired
	    private MovieService movieService;

	    public MovieController(MovieService movieService) {
	        this.movieService = movieService;
	    }
	    @GetMapping("/movies/new")
	    public String showAddMovieForm(Model model) {
	        model.addAttribute("title", "Add New Movie");
	        model.addAttribute("movie", new Movie());
	        return "/add-movie";
	    }
	    
	    @GetMapping("/movies")
	    public String getMoviesPage(Model model) {
	        model.addAttribute("movies", movieService.getAllMovies());
	        return "/movies-list"; // Use a separate Thymeleaf template for listing movies
	    }

	    @PostMapping("/movies")
	    public String addMovie(@Valid Movie movie, BindingResult result, Model model) {
	        if (result.hasErrors()) {
	            model.addAttribute("title", "Add New Movie");
	            return "/add-movie";
	        }
	        movieService.addMovie(movie);
	        return "redirect:/movies";  // Redirect to movies list after adding a movie
	    }

	}


