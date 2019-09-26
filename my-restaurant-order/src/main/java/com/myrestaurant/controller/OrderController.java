package com.myrestaurant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "order")
public class OrderController {

	@GetMapping("")
	public ResponseEntity<Object> findOrderById() {
		return ResponseEntity.ok("Order found for id ");
	}

}
