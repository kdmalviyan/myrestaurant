package com.myrestaurant.myrestaurantusermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;
import com.myrestaurant.myrestaurantusermanagement.repository.CustomerRepository;

@Service("CustomerDetails")
@Transactional
public class CustomerDetailsServiceImpl implements CustomerDetails {

	@Autowired
	CustomerRepository customerRepository;

	@Autowired
	private PasswordEncoder bcryptEncoder;

	@Override
	public Customer save(Customer user) {
		user.setPassword(bcryptEncoder.encode(user.getPassword()));
		return customerRepository.save(user);
	}

	@Override
	public Customer loadUserByUsername(Customer customer) {
		Customer customerDetails = customerRepository.findByUsername(customer.getUsername());
		if (customerDetails == null) {
			throw new UsernameNotFoundException("User not found with username: " + customer);
		}
		return customerDetails;
	}

	@Override
	public boolean updateCustomerByUsername(Customer customer) {
		/*
		 * Customer customerDetails=
		 * customerRepository.findByUsername(customer.getUsername()); if
		 * (customerDetails == null) { throw new
		 * UsernameNotFoundException("User not found with username: " + customer); }
		 * return customerRepository.findByUsername(customer);
		 */
		return true;
	}

	@Override
	public boolean delete(Customer customer) {

		long id = customerRepository.findByUsername(customer.getUsername()).getId();

		customerRepository.deleteById(id);

		return true;
	}

	@Override
	public Customer findById(Long customerId) {
		Customer customer = this.customerRepository.findById(customerId).orElseGet(null);
		return customer;
	}

	@Override
	public Iterable<Customer> findAll() {
		Iterable<Customer> lists = this.customerRepository.findAll();
		return lists;
	}

}
