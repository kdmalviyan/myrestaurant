package com.myrestaurant.myrestaurantusermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	Customer findByUsername(String userName);
	

}
