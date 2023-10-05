package com.example.demo.model;

import java.util.Calendar;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface OrderRepository extends JpaRepository<MyOrder, Integer> {

	List<MyOrder> findByUserId(int uid);

	@Query(value = "select * from my_order o where o.order_id=:oid ", nativeQuery = true)
	List<MyOrder> findByOrderId(Integer oid);
}
