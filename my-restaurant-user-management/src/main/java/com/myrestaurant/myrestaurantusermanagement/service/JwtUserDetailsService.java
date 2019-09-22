package com.myrestaurant.myrestaurantusermanagement.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myrestaurant.myrestaurantusermanagement.entity.Customer;
import com.myrestaurant.myrestaurantusermanagement.repository.CustomerRepository;
import com.myrestaurant.myrestaurantusermanagement.repository.JwtUserRepository;

@Service
public class JwtUserDetailsService implements UserDetailsService {


	@Autowired
	JwtUserRepository swtUserRepository;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{		
		Customer customer= swtUserRepository.findByUsername(username);
		if (customer == null) {
			throw new UsernameNotFoundException("User not found with username: " + customer);
		}
		return new org.springframework.security.core.userdetails.User(customer.getUsername(), customer.getPassword(),
				new ArrayList<>());	
	}
	
	

	
}
