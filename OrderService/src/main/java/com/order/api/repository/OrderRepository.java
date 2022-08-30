package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long>{
	
}
