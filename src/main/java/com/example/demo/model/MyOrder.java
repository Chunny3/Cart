package com.example.demo.model;


import jakarta.persistence.*;

@Entity
@Table(name="MyOrder")
public class MyOrder {

	@EmbeddedId
	OrderPK orderId;
	int userId;	
	int id;
	String name;
	int price;
	int quantity;
	String orderTime;

	public MyOrder() {
	}

	public MyOrder(OrderPK orderid, int userId, int id,String name, int price, int quantity,String orderTime) {
		orderId = orderid;
		this.userId = userId;
		this.id=id;
		this.name = name;
		this.price = price;
		this.quantity = quantity;
		this.orderTime=orderTime;
	}
	

	public OrderPK getOrderid() {
		return orderId;
	}

	public void setOrderid(OrderPK orderid) {
		orderId = orderid;
	}
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
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
	

	public String getOrderTime() {
		return orderTime;
	}

	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}

	@Override
	public String toString() {
		return "MyOrder [Orderid=" + orderId + ", userId=" + userId +  ", name=" + name + ", price="
				+ price + ", quantity=" + quantity + ", orderTime=" + orderTime + "]";
	}

	

}
