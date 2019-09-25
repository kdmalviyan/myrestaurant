package com.myrestaurant.myrestaurantinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyRestaurantInventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurantInventoryApplication.class, args);
	}

}
