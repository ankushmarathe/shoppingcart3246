package com.order.api.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.order.api.model.Order;
import com.order.api.repository.OrderRepository;

@RestController
@RequestMapping("/order")
public class OrderController {
	
	OrderRepository orderRepository;
	
	@GetMapping("/allorders") // Api To fetch all orders
	public List<Order> getAllOrders(){
		return orderRepository.findAll();
	}
	
	@PostMapping("/addorder")
	public Order postOrder(@RequestBody Order order) {
		return orderRepository.save(order);
	}
	
	
	@DeleteMapping("/order/{oid}")		
	public void deleteOrder(@PathVariable("oid") Long oid) {
		orderRepository.deleteById(oid);
	}
	
	@PutMapping("/order/status/{oid}")
	public Order updateStatus(@PathVariable("oid") Long oid, @RequestBody Order order) {
		
		Order orderdb = orderRepository.getById(oid);
		orderdb.setOrderStatus(order.getOrderStatus());
		return orderRepository.save(orderdb);
		
	}
	
}
