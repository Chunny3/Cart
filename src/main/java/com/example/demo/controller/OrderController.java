package com.example.demo.controller;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.demo.model.*;

import jakarta.servlet.http.HttpSession;

@RestController
@RequestMapping("/api")
@CrossOrigin("http://localhost:3000/")
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;

	@GetMapping("/order/{uid}")
	public List<MyOrder> getOrders(@PathVariable int uid) {
		List<MyOrder> allOrderByUid = orderRepository.findByUserId(uid);
		int value = allOrderByUid.stream().mapToInt(i -> (int) i.getOrderid().getOrderId()).max().getAsInt();
		return orderRepository.findByOrderId(value);
	}

	@GetMapping("/orders/{uid}")
	public List<MyOrder> getOrdersByUid(@PathVariable int uid) {
		return orderRepository.findByUserId(uid);
	}

	// TODO FIXME
	@PostMapping("/add_order")
	public ResponseEntity pay(@RequestBody List<Buy> buys) {
		List<MyOrder> allOrder = orderRepository.findAll();
		int value;
		if (allOrder.isEmpty()) {
			value = 0;
		} else {
			value = allOrder.stream().mapToInt(i -> (int) i.getOrderid().getOrderId()).max().getAsInt();
		}

		List<MyOrder> or = new ArrayList<>();
		LocalDateTime currentDateTime = LocalDateTime.now();
		// 定義日期時間格式
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		// 轉換成字串
		String formattedDateTime = currentDateTime.format(formatter);

		for (Buy buy : buys) {
			MyOrder each = new MyOrder();
			OrderPK pk = new OrderPK();
			pk.setOrderId(value + 1);
			pk.setPid(buy.getId());
			each.setOrderid(pk);
			each.setName(buy.getName());
			each.setId(buy.getId());
			each.setPrice(buy.getPrice());
			each.setQuantity(buy.getQuantity());
			each.setUserId(buy.getUserId());
			each.setOrderTime(formattedDateTime);
			or.add(each);
		}
		orderRepository.saveAll(or);
		return ResponseEntity.ok().build();
	}
}
