package com.order.api.controller;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.order.api.model.Address;
import com.order.api.model.Cart;
import com.order.api.model.Orders;
import com.order.api.model.User;
import com.order.api.repository.AddressRepository;
import com.order.api.repository.CartRepository;
import com.order.api.repository.OrderRepository;

@CrossOrigin(origins = {"http://localhost:4200/"})
@RestController
//@RequestMapping("/order")
public class OrderController {
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private AddressRepository addressRepository;
	
	@Autowired
	private CartRepository cartRepository;
	
	@PostMapping("/addorder/{aid}")  // Api to add a new Order 
	public Orders placeOrder(@RequestBody Orders orders, @PathVariable("aid")Long aid)  {
		
		orders.setOrderDate(LocalDate.now());   // To set a local date
		RestTemplate restTemplate =	new RestTemplate();
		
		Address address = addressRepository.getReferenceById(aid);
		ResponseEntity<com.order.api.model.Cart> temp = restTemplate
				.getForEntity("http://localhost:1003/cart/getcart/"+address.getCartId(), Cart.class);
		
		Cart cartDb = temp.getBody();
//		Cart cart = cartRepository.getReferenceById(address.getCartId());
		
		orders.setUserId(cartDb.getUserId());
		orders.setAddress(address);
		orders.setAmmountPaid(cartDb.getTotalPrice());
		
		
		return orderRepository.save(orders);
	}
	
	
	
	@GetMapping("/allorders")		//APi to fetch all the orders
	public List<Orders> getAllOrders(){		
		return orderRepository.findAll();
	}
	
	
	
	@DeleteMapping("/order/cancelorder/{oid}") 		//Api to delete a order
	public void removeOrder(@PathVariable Long oid) {
		orderRepository.deleteById(oid);
	}
	
	
	
	@PutMapping("/order/changestatus/{oid}") 		//Api to Change the order status
	public Orders changeOrderStatus(@PathVariable Long oid,@RequestBody Orders order) {
		
		Orders orderdb = orderRepository.getReferenceById(oid);
		orderdb.setOrderStatus(order.getOrderStatus());
		return orderRepository.save(orderdb);
		
	}
	
	
	
	@GetMapping("/order/{uid}") 	//Api to get Orders according to UserId
	public List<Orders> getOrderByUserId(@PathVariable("uid") Long uid) throws Exception{
		
		RestTemplate restTemplate =	new RestTemplate();
		
		// calling profile service to check if user is present
		ResponseEntity<User> temp=restTemplate
				.getForEntity("http://localhost:1001/user/users"+ uid, User.class);
		User userDB=temp.getBody();
		
		
		List<Orders> orderlist = orderRepository.getReferenceByUserId(userDB.getUserId());
		return orderlist;
		
	}
	
	@GetMapping("/order/cart/{cid}") 	//Api to get Orders according to UserId
	public double getOrderByCartId(@PathVariable("cid") Long cid) throws Exception{
		
		RestTemplate restTemplate =	new RestTemplate();
		
		// calling profile service to check if user is present
		ResponseEntity<Cart> temp=restTemplate
				.getForEntity("http://localhost:1003/cart/getcart/"+ cid, Cart.class);
		Cart cart=temp.getBody();
		
		System.out.print(cart);
		
		return cart.getTotalPrice();
		
	}
	
	
}











