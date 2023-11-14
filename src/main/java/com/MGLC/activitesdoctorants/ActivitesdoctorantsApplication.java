package com.MGLC.activitesdoctorants;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entities")
public class ActivitesdoctorantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitesdoctorantsApplication.class, args);
	}

}
