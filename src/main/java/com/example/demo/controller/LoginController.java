package com.example.demo.controller;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class LoginController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/login")
	public User login(@RequestBody User user) {
		User existingUser = userRepository.findByUsername(user.getUsername());
		if (existingUser == null) {
			return null;
		}
		if (bCryptPasswordEncoder.matches(user.getPassword(), existingUser.getPassword())) {
			return existingUser;
		} else {
			return null;
		}
	}
	@PostMapping("/verify-username-email")
	public ResponseEntity<String> verifyUsernameAndEmail(@RequestBody Map<String, String> request) {
	    String username = request.get("username");
	    String email = request.get("email");

	    User userByUsername = userRepository.findByUsername(username);
	    User userByEmail = userRepository.findByEmail(email);

	    if (userByUsername == null || userByEmail == null || !userByUsername.equals(userByEmail)) {
	        return ResponseEntity.badRequest().body("username和email不匹配");
	    }

	    return ResponseEntity.ok("驗證成功");
	}

	@PostMapping("/reset-password")
	public ResponseEntity<String> resetPassword(@RequestBody Map<String, String> request) {
	    String newPassword = request.get("newPassword");
	    String username = request.get("username");
	    String email = request.get("email");
	    
	    User userByUsername = userRepository.findByUsername(username);
	    User userByEmail = userRepository.findByEmail(email);

	    if (userByUsername == null || userByEmail == null || !userByUsername.equals(userByEmail)) {
	        return ResponseEntity.badRequest().body("無法重置密碼");
	    }
	    System.out.println("Resetting password for user: " + username);
	    userByUsername.setPassword(bCryptPasswordEncoder.encode(newPassword));
	    userRepository.save(userByUsername);

	    return ResponseEntity.ok("密碼已更改");
	}


}
