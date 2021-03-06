package com.myrestauran.apigateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringBootApplication
@EnableEurekaClient
@EnableZuulProxy

public class RestaurantApiGatewayApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApiGatewayApplication.class, args);
	}

}
