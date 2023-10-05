package com.example.demo.controller;

import java.util.Iterator;

import java.util.List;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class CartController {
	@Autowired
	private CartRepository CartRepository;

	@GetMapping("/carts/{uid}")
	public List<Cart> getAllCarts(@PathVariable int uid) {
		return CartRepository.findByUserId(uid);
	}

	@PostMapping("/add_cart/{id}")
	public Cart addCart(@PathVariable("id") int id, @RequestBody Cart cart) {
		CartRepository.save(cart);
		return cart;
	}

	@PutMapping("/update_cart/{id}")
	public void updateCart(@PathVariable("id") int id, @RequestBody Cart cart) {
		Cart upCart = CartRepository.findById(id).orElse(null);
		upCart.setQuantity(cart.getQuantity());
		CartRepository.save(upCart);
	}

//	@GetMapping("/find_cart/{id}")
//	public ResponseEntity findCart(@PathVariable("id") int id) {
//		List<Cart> alllist = getAllCarts();
//		for (Iterator iterator = alllist.iterator(); iterator.hasNext();) {
//			Cart cart = (Cart) iterator.next();
//			if (cart.getId() == id) {
//				return ResponseEntity.ok(cart);
//			}
//		}
//		return ResponseEntity.notFound().build();
//	}

	@DeleteMapping("/delete_cart/{id}")
	public ResponseEntity deleteCart(@PathVariable("id") int id) {
		CartRepository.deleteById(id);
		return ResponseEntity.ok(id);
	}

	@DeleteMapping("/delete_allcart")
	public ResponseEntity deleteAllCart(@RequestBody List<Integer> c) {
//		CartRepository.deleteAll(c);
		CartRepository.deleteAllById(c);
		return ResponseEntity.ok().build();
	}

}
