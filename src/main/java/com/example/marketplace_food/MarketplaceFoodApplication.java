package com.example.marketplace_food;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
@EnableAutoConfiguration
public class MarketplaceFoodApplication {

	public static void main(String[] args) {
		SpringApplication.run(MarketplaceFoodApplication.class, args);
	}

}
