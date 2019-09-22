package com.myrestaurant.myrestaurantusermanagement.repository;

import org.springframework.data.repository.CrudRepository;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;

public interface JwtUserRepository extends CrudRepository<Customer, Long> {
	
	Customer findByUsername(String username);
}
