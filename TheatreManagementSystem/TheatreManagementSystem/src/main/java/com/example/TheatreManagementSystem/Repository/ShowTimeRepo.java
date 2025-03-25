package com.example.TheatreManagementSystem.Repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TheatreManagementSystem.Model.ShowTime;
@Repository
public interface ShowTimeRepo extends JpaRepository<ShowTime, Long>{
	

}
