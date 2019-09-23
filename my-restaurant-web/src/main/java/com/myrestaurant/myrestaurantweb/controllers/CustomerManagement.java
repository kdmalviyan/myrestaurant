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
import com.myrestaurant.myrestaurantweb.feign.CustomerFeignClient;
import com.myrestaurant.myrestaurantweb.feign.CustomerResponse;

import feign.Feign;
import feign.Logger;
import feign.gson.GsonDecoder;
import feign.gson.GsonEncoder;
import feign.okhttp.OkHttpClient;
import feign.slf4j.Slf4jLogger;

@RestController
@RequestMapping(value = "/customer")
public class CustomerManagement {

	@PostMapping("")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		CustomerFeignClient customerClient = Feign.builder()
				  .client(new OkHttpClient())
				  .encoder(new GsonEncoder())
				  .decoder(new GsonDecoder())
				  .logger(new Slf4jLogger(CustomerFeignClient.class))
				  .logLevel(Logger.Level.FULL)
				  .target(CustomerFeignClient.class, "http://localhost:8081/user/create");
		CustomerResponse customerResponse = customerClient.create(customerAccountDTO);
		return new ResponseEntity<Object>(customerResponse, HttpStatus.OK);
	}

	@GetMapping("")
	public ResponseEntity<Object> getCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
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
