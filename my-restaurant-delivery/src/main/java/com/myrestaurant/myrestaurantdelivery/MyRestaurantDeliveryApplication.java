package com.myrestaurant.myrestaurantdelivery;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MyRestaurantDeliveryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyRestaurantDeliveryApplication.class, args);
	}

}
