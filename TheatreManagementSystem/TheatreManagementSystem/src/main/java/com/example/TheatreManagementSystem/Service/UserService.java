package com.example.TheatreManagementSystem.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.TheatreManagementSystem.Model.User1;
import com.example.TheatreManagementSystem.Repository.UserRepo;

@Service
public class UserService {
@Autowired
	 private UserRepo userRepo;

	  

	    public User1 validateUser(String username, String password) {
	        return userRepo.findByUsernameAndPassword(username, password);
	    }

	    public void registerUser(User1 user) {
	        userRepo.save(user);
	    }

	    public User1 getLoggedInUser() {
	        // Replace with actual session-based user retrieval logic
	        return userRepo.findById((int) 1L).orElse(null); // Example: retrieve user with ID 1
	    }
	    
	    public List<User1> getAllUsers(){
	    	return userRepo.findAll();
	    }

}
