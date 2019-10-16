package com.myrestaurant.myrestaurantweb.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrestaurant.myrestaurantweb.customer.CustomerAccountDTO;

@RestController
@RequestMapping(value = "/customer")
public class CustomerManagement {

	@PostMapping("")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		return new ResponseEntity<Object>("Customer Created", HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<Object> getCustomer() {
		return new ResponseEntity<Object>("Customer", HttpStatus.OK);
	}

	@PutMapping("")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		return new ResponseEntity<Object>("Update Customer", HttpStatus.OK);
	}

	@DeleteMapping("")
	public ResponseEntity<Object> deleteCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		return new ResponseEntity<Object>("Delete", HttpStatus.OK);
	}
}
