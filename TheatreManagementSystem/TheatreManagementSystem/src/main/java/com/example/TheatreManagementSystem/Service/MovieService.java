package com.example.TheatreManagementSystem.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TheatreManagementSystem.Model.Movie;
import com.example.TheatreManagementSystem.Repository.MovieRepo;


@Service
public class MovieService {
    @Autowired
	private MovieRepo movieRepo;
    
public Movie addMovie(Movie movie) {
	return movieRepo.save(movie);
}

public Movie UpdateMovie(Long id, Movie updatedMovie) {
	Optional<Movie> existingMovie=movieRepo.findById(id);
	if(existingMovie.isPresent()) {
		Movie movie=existingMovie.get();
		movie.setTitle(updatedMovie.getTitle());
		movie.setDirector(updatedMovie.getDirector());
		movie.setReleaseDate(updatedMovie.getReleaseDate());
		movie.setGenre(updatedMovie.getGenre());
	}
	return null;
}

public void deleteMovie(Long id) {
	movieRepo.deleteById(id);
}

public Movie getMovie(Long movieId) {
    return movieRepo.findById(movieId).orElse(null);
}


public List<Movie> getAllMovies() {
    return movieRepo.findAll();
}

}
