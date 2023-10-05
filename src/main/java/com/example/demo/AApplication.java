package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.example.demo.model.*;

@SpringBootApplication
public class AApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AApplication.class, args);
	}

	@Autowired
	private CartRepository cartRepository;
	@Autowired
	private BuyRepository buyRepository;
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void run(String... args) throws Exception {
//		Cart pdt1 = new Cart( 0, 0, "test", 0, 0);
//		cartRepository.save(pdt1);
		
//		Buy by1 = new Buy(1, 0, 0, "test", 0, 0);
//		buyRepository.save(by1);

		User u1 = new User((long) 101, "Mary", "Mary", "mary@test.com", bCryptPasswordEncoder.encode("M1234"));
		userRepository.save(u1);
		User u2 = new User((long) 102, "George", "George", "grorge@test.com", bCryptPasswordEncoder.encode("G1234"));
		userRepository.save(u2);
	}

}
