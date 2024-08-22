package com.orderManagement.OrderManagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.orderManagement.OrderManagement.entities.orderDo;
import com.orderManagement.OrderManagement.services.orderService;

@RestController
@RequestMapping("/orders")

public class orderController {
	@Autowired
	private orderService orderService;
	@GetMapping
	public List<orderDo> getAllOrders() {
	return orderService.getAllOrders();
	}
	@GetMapping("/{id}")
	public ResponseEntity<orderDo> getOrderById(@PathVariable Long id) {
	orderDo order = orderService.getOrderById(id);
	if (order != null) {
	return new ResponseEntity<>(order, HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@PostMapping
	public ResponseEntity<orderDo> createOrder(@RequestBody orderDo order) {
	orderDo createdOrder = orderService.createOrder(order);
	return new ResponseEntity<>(createdOrder, HttpStatus.CREATED);
	}
	@PutMapping("/{id}")
	public ResponseEntity<orderDo> updateOrder(@PathVariable Long id, @RequestBody orderDo order) {
	orderDo updatedOrder = orderService.updateOrder(id, order);
	if (updatedOrder != null) {
	return new ResponseEntity<>(updatedOrder, HttpStatus.OK);
	} else {
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}
	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOrder(@PathVariable Long id) {
	orderService.deleteOrder(id);
	return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
	@PostMapping("/{id}/Ship")
	public ResponseEntity<Void> placeOrderToShipmentService(@PathVariable Long id) {
	orderService.placeOrderToShipmentService(id);
	return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
