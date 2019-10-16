package com.myrestaurant.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment/api")
public class PaymentController {

	@GetMapping("home")
	public ResponseEntity<Object> home() {
		return ResponseEntity.ok("Hello Payment service");
	}
}
