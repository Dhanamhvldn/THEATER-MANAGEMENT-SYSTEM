package com.example.TheatreManagementSystem.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.TheatreManagementSystem.Model.User1;

@Repository
public interface UserRepo extends JpaRepository<User1, Integer>{
	 User1 findByUsernameAndPassword(String username, String password);
}
