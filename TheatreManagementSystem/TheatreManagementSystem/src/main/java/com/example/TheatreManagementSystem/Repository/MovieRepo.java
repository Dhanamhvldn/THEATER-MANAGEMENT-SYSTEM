package com.example.TheatreManagementSystem.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TheatreManagementSystem.Model.Movie;
@Repository
public interface MovieRepo extends JpaRepository<Movie, Long>{

	Optional<Movie> findById(Long id);

}
