package com.myrestaurant.myrestaurantusermanagement.service;

import org.springframework.security.core.userdetails.UserDetails;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;


public interface CustomerDetails {	
	
	Customer loadUserByUsername(Customer customer);	
	
	boolean  updateCustomerByUsername(Customer customer);
	
	boolean delete(Customer customer);
	
}
