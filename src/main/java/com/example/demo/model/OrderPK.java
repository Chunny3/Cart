package com.example.demo.model;

import java.io.Serializable;
import jakarta.persistence.Embeddable;

@Embeddable
public class OrderPK implements Serializable {
	Integer orderId;
	Integer pid;

	public OrderPK() {
	}

	public OrderPK(int orderId, int pid) {
		this.orderId = orderId;
		this.pid = pid;
	}

	public int getOrderId() {
		return orderId;
	}

	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}

	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	@Override
	public String toString() {
		return "OrderPK [orderId=" + orderId + ", pid=" + pid + "]";
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof OrderPK)) {
			return false;
		}
		OrderPK castOther = (OrderPK) other;
		return this.orderId == castOther.orderId && this.pid == castOther.pid;
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = prime * hash + orderId;
		hash = prime * hash + pid;

		return hash;
	}

}
