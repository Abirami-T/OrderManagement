package com.orderManagement.OrderManagement.services;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.orderManagement.OrderManagement.Repository.orderRepo;
import com.orderManagement.OrderManagement.entities.orderDo;



@Service
public class orderService {
	@Autowired
	private RestTemplate restTemplate;
	@Autowired
	private orderRepo orderRepository;
	public List<orderDo> getAllOrders() {
	return orderRepository.findAll();
	}
	public orderDo getOrderById(Long id) {
	return orderRepository.findById(id).orElse(null);
	}
	public orderDo createOrder(orderDo order) {
	return orderRepository.save(order);
	}
	public orderDo updateOrder(Long id, orderDo order) {
	orderDo existingOrder = orderRepository.findById(id).orElse(null);
	if (existingOrder != null) {
	order.setId(id);
	return orderRepository.save(order);
	}
	return null;
	}
	public void deleteOrder(Long id) {
	orderRepository.deleteById(id);
	}
	public void placeOrderToShipmentService(Long id) {
	String trackingNumber = generateTrackingNumber();
	String shipmentServiceUrl = "http://localhost:8082/Ship";
	restTemplate.postForLocation(shipmentServiceUrl, trackingNumber, id+"Address");
	}
	private String generateTrackingNumber() {
	return UUID.randomUUID().toString();
	}

}
