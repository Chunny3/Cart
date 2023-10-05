package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class Buy {
	@Id
//	@Column(name = "buy_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int buyId;
	int userId;
	int id;
	String name;
	int price;
	int quantity;

	public Buy() {
	}

	public Buy(/*int buyId,*/ int userId, int id, String name, int price, int quantity) {
//		this.buyId = buyId;
		this.userId = userId;
		this.id = id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}

	public int getBuyId() {
		return buyId;
	}

	public void setBuyId(int buyId) {
		this.buyId = buyId;
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
