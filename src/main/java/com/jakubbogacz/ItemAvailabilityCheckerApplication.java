package com.jakubbogacz;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ItemAvailabilityCheckerApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemAvailabilityCheckerApplication.class, args);
	}
}
