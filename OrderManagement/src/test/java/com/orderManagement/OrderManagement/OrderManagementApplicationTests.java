package com.orderManagement.OrderManagement;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import io.restassured.RestAssured;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import com.orderManagement.OrderManagement.entities.*;



@SpringBootTest
class OrderManagementApplicationTests {

	@BeforeAll
	public static void setup() {
	RestAssured.baseURI = "http://localhost";
	RestAssured.port = 8081;
	}
	@Test
	public void testGetAllOrders() {
	given()
	.when()
	.get("/orders")
	.then()
	.statusCode(200)
	.body("size()", greaterThan(0));
	}
	@Test
	public void testCreateOrder() {
	orderDo order = new orderDo();
	order.setProductName("Book");
	order.setPrice(500.0);
	given()
	.contentType("application/json")
	.body(order)
	.when()
	.post("/orders")
	.then()
	.statusCode(201)
	.body("productName", equalTo("Book"));
	}
	@Test
	public void testUpdateOrder() {
	// Updating product with ID 303 in the database
	given()
	.contentType("application/json")
	.body("{\"productName\": \"Bottle\", \"price\": 200.0}")
	.when()
	.put("/orders/54")
	.then()
	.statusCode(200)
	.body("productName", equalTo("Bottle"));
	}

	@Test
	public void testDeleteOrder() {
	// Deleting product with ID 303 in the database
	given()
	.when()
	.delete("/orders/56")
	.then()
	.statusCode(204);
	}
	@Test
	public void testDeleteOrder_invalidId() {
	given()
	.when()
	.delete("/orders/8")
	.then()
	.statusCode(204);
	}

	@Test
	public void testPlaceOrderToShipmentService() {
	given()
	.pathParam("id", 54)
	.when()
	.post("/orders/{id}/Ship")
	.then()
	.statusCode(200);
	}

}
