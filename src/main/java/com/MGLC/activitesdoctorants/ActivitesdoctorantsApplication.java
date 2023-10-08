package com.MGLC.activitesdoctorants;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ActivitesdoctorantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitesdoctorantsApplication.class, args);
	}
	@Bean
	CommandLineRunner coomandLineRunner() {
		return args -> {
		};
	}

}
