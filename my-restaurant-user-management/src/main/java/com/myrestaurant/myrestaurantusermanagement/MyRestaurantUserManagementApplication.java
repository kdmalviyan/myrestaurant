package com.myrestaurant.myrestaurantusermanagement;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.myrestaurant.*")
@EnableEurekaClient
public class MyRestaurantUserManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurantUserManagementApplication.class, args);
	}

}
