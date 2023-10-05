package com.example.demo.model;
import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Integer>{
	List<Cart>findByUserId(int uid);

}
