package com.myrestaurant.myrestaurantusermanagement.util;

import com.myrestaurant.myrestaurantusermanagement.dto.CustomerAccountDTO;
import com.myrestaurant.myrestaurantusermanagement.entity.Customer;

public class BeanUtility {
	
	public static Customer copyProperties(CustomerAccountDTO custDto, Customer customer) {
		
		customer.setFirstName(custDto.getFirstName());
		customer.setLastName(custDto.getLastName());
		customer.setPhone(custDto.getPhone());
		customer.setEmail(custDto.getEmail());
		customer.setUsername(custDto.getUsername());	
		customer.setPassword("Londe#3");	
		return customer;
	}
	
}
