package com.orderManagement.OrderManagement.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Orders")

public class orderDo {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@Column(name = "ProductName")
	private String productName;
	@Column(name = "price")
	private double price;
	public orderDo() {
	}
	public orderDo(String productName, double price) {
	this.productName = productName;
	this.price = price;
	}
	public Long getId() {
	return id;
	}
	public void setId(Long id) {
	this.id = id;
	}
	public String getProductName() {
	return productName;
	}
	public void setProductName(String productName) {
	this.productName = productName;
	}
	public double getPrice() {
	return price;
	}
	public void setPrice(double price) {
	this.price = price;
	}

}
