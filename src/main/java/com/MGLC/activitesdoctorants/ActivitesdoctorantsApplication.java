package com.MGLC.activitesdoctorants;

import com.MGLC.activitesdoctorants.entities.*;
import com.MGLC.activitesdoctorants.enums.Grade;
import com.MGLC.activitesdoctorants.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@AllArgsConstructor
public class ActivitesdoctorantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitesdoctorantsApplication.class, args);
	}

}
