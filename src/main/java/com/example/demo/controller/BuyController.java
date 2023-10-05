package com.example.demo.controller;

import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class BuyController {
	@Autowired
	private BuyRepository BuyRepository;

	@Transactional
	@GetMapping("/buys/{uid}")
	public List<Buy> getAllBuys(@PathVariable int uid) {
		return BuyRepository.findByUserId(uid);
	}

	@PostMapping("/add_buy")
	public List<Buy> addBuy(@RequestBody List<Buy> buy) {
		BuyRepository.saveAll(buy);
		return buy;
	}

	@DeleteMapping("/delete_buy/{id}")
	public ResponseEntity deleteCart(@PathVariable("id") int id) {
		BuyRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@DeleteMapping("/deleteAllbuy")
	public ResponseEntity deleteAllBuy() {
		BuyRepository.deleteAll();
		return ResponseEntity.ok().build();
	}

}
