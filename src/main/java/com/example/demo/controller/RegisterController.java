package com.example.demo.controller;

import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:3000/")
public class RegisterController {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@PostMapping("/register")
	public String registerUser(@RequestBody User user) {
		if (userRepository.existsByUsername(user.getUsername())) {
			throw new IllegalArgumentException("使用者名稱已存在");
		}
		
		List<User> allEmp = userRepository.findAll();
		long value = allEmp.stream().mapToInt(i -> Integer.parseInt(""+i.getId())).max().getAsInt();
		user.setId(value + 1);
		
		String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
		user.setPassword(encodedPassword);
		userRepository.save(user);

		return "註冊成功！";
	}
	
}
