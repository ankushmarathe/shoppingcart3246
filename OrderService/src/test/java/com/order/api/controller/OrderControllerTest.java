package com.order.api.controller;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.mockito.Mockito.times;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.order.api.model.Order;
import com.order.api.repository.OrderRepository;

@SpringBootTest(classes= {OrderControllerTest.class})
public class OrderControllerTest {
	
	@Mock
	OrderRepository orderRepository; 
	
	@InjectMocks
	OrderController orderController;
	
	@Test	//test case for get all wallets
	public void getAllOrdersTest1() {
		List<Order> orderList1 = new ArrayList<>();
		
		orderList1.add(new Order((long)1, LocalDate.now(),1,500.25,"COD","DONE",5)) ;
		orderList1.add(new Order((long)2, LocalDate.now(),2,501.25,"COD","DONE",5)) ;
		orderList1.add(new Order((long)3, LocalDate.now(),3,5002.25,"COD","DONE",5)) ;
		
		when(orderRepository.findAll()).thenReturn(orderList1);
		
		assertEquals(orderList1, orderController.getAllOrders());
	}
	
	@Test	//test case for null orders
	public void getAllOrderTest2() {
		List<Order> orderList = new ArrayList<>();
		
		when(orderRepository.findAll()).thenReturn(orderList);
		assertEquals(orderList, orderController.getAllOrders());
	}
	
	
	@Test	//test case for delete wallet
	public void deleteOrderTest1() {

		long order = (long)1;
		orderController.deleteOrder(order);
		verify(orderRepository , times(1)).deleteById(order);
	
	}
	
	@Test
	public void postOrderTest() {
		
		Order order = new Order((long)1, LocalDate.now(),1,500.25,"COD","DONE",5);
		when(orderRepository.save(order)).thenReturn(order);
		assertEquals(order, orderController.postOrder(order));
	}
	
	@Test
	public void putOrderTest() {
		
		Order order = new Order((long)1, LocalDate.now(),1,500.25,"COD","DONE",5);
		when(orderRepository.getById((long)1)).thenReturn(order);
		
		String newStatus="Intransit";
		
		Order order1 = new Order((long)1, null,0,0.0,null,newStatus,0);
		when(orderController.updateStatus((long)1, order1)).thenReturn(order);
		
		assertEquals(newStatus, order.getOrderStatus());
		
	}
	
}
