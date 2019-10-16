package com.myrestaurant.myrestaurantusermanagement.service;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;

public interface CustomerDetails {

	Customer loadUserByUsername(Customer customer);

	boolean updateCustomerByUsername(Customer customer);

	boolean delete(Customer customer);

	Customer save(Customer customer);

	Customer findById(Long customerId);

	Iterable<Customer> findAll();

}
