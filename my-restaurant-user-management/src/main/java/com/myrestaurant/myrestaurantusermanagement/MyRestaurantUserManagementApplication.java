package com.myrestaurant.myrestaurantusermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.myrestaurant.*")
public class MyRestaurantUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurantUserManagementApplication.class, args);
	}

}
