package com.myrestaurant.myrestaurantusermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myrestaurant.myrestaurantusermanagement.dto.CustomerAccountDTO;
import com.myrestaurant.myrestaurantusermanagement.entity.Customer;
import com.myrestaurant.myrestaurantusermanagement.service.CustomerDetailsServiceImpl;
import com.myrestaurant.myrestaurantusermanagement.util.BeanUtility;

@RestController
@RequestMapping(value = "/user/customer")
public class CustomerManagementController {
	
	
	@Autowired
	CustomerDetailsServiceImpl CustomerDetails;
	
	@PostMapping("")
	public ResponseEntity<Object> createCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		Customer customer = new Customer();
		BeanUtility.copyProperties(customerAccountDTO, customer);
		return ResponseEntity.ok(CustomerDetails.save(customer));
	}
	
	@GetMapping("")
	public Customer getCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		Customer customer = new Customer();
		BeanUtility.copyProperties(customerAccountDTO, customer);
		return CustomerDetails.loadUserByUsername(customer);
	}

	@PutMapping("")
	public ResponseEntity<Object> updateCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		Customer customer = new Customer();
		BeanUtility.copyProperties(customerAccountDTO, customer);
		if(CustomerDetails.updateCustomerByUsername(customer)) {
			return new ResponseEntity<Object>("Updated", HttpStatus.OK);
		}else
			return new ResponseEntity<Object>("Updated", HttpStatus.INTERNAL_SERVER_ERROR);
	}

	@DeleteMapping("")
	public ResponseEntity<Object> deleteCustomer(@RequestBody CustomerAccountDTO customerAccountDTO) {
		Customer customer = new Customer();
		BeanUtility.copyProperties(customerAccountDTO, customer);
		if(CustomerDetails.delete(customer)) {
			return new ResponseEntity<Object>("Deleted", HttpStatus.OK);
		}else
			return new ResponseEntity<Object>("Deleted", HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@RequestMapping({ "/hello" })
	public String firstPage() {
	return "Hello World";
	}
	
}