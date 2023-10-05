package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Cart {
	@Id
//	@Column(name = "cart_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int cartId;
	int userId;
	int id;
	String name;
	int price;
	int quantity;

	public Cart() {
	}

	public Cart(/*int cartId,*/ int userId, int id, String name, int price, int quantity) {
//		this.cartId = cartId;
		this.userId = userId;
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

}
