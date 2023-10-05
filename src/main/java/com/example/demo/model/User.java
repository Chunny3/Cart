package com.example.demo.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class User {
	@Id
	private Long id;
	private String name;
	private String username;
	private String email;
	private String password;

	public User() {
	}

	public User(Long id, String name, String username, String email, String password) {
		this.id = id;
		this.name = name;
		this.username = username;
		this.email = email;
		this.password = password;
	}

}
