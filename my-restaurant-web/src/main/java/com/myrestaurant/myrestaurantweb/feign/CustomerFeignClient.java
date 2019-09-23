package com.myrestaurant.myrestaurantweb.feign;

import java.util.List;

import com.myrestaurant.myrestaurantweb.customer.CustomerAccountDTO;

import feign.Headers;
import feign.Param;
import feign.RequestLine;

public interface CustomerFeignClient {

	@RequestLine("GET /{id}")
	CustomerResponse findById(@Param("id") String id);

	@RequestLine("GET")
	List<CustomerResponse> findAll();

	@RequestLine("POST")
	@Headers("Content-Type: application/json")
	CustomerResponse create(CustomerAccountDTO customerAccountDTO);

}
