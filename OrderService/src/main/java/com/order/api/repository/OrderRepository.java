package com.order.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.order.api.model.Orders;

public interface OrderRepository extends JpaRepository<Orders, Long>{

}
