package com.myrestaurant.myrestaurantusermanagement.service;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;


public interface CustomerDetails {	
	
	Customer loadUserByUsername(Customer customer);	
	
	boolean  updateCustomerByUsername(Customer customer);
	
	boolean delete(Customer customer);
	
}
