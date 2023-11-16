package com.MGLC.activitesdoctorants;

import com.MGLC.activitesdoctorants.entities.*;
import com.MGLC.activitesdoctorants.repositories.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;

import javax.persistence.*;
import javax.print.Doc;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootApplication
@EntityScan(basePackages = "com/MGLC/activitesdoctorants/entities")
public class ActivitesdoctorantsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ActivitesdoctorantsApplication.class, args);
	}
	@Bean
	CommandLineRunner start(AbsenceRepository absenceRepository, DoctorantRepository doctorantRepository, MeetingRepository meetingRepository, ProfesseurRepository professeurRepository, SujetTheseRepository sujetTheseRepository){
		return args->{
			professeurRepository.deleteAll();
			Professeur p = professeurRepository.save(new Professeur(null,"prof1","prof2","prof1@gmail.com","012345698",null));
			Professeur p1 = professeurRepository.save(new Professeur(null,"prof2","prof2","prof2@gmail.com","044345688",null));
			Professeur p2 = professeurRepository.save(new Professeur(null,"prof3","prof3","prof3@gmail.com","033345648",null));
			Professeur p3 = professeurRepository.save(new Professeur(null,"prof4","prof4","prof4@gmail.com","022346398",null));

			doctorantRepository.deleteAll();
			Doctorant d = doctorantRepository.save(new Doctorant(null,"123","Pa11223","moussa","mou",p,null,null,null));
			Doctorant d1 = doctorantRepository.save(new Doctorant(null,"123","Pa11223","mehdo","mehdi",p1,null,null,null));
			Doctorant d2 = doctorantRepository.save(new Doctorant(null,"123","Pa11223","redi","redaaa",p2,null,null,null));
			Doctorant d3 = doctorantRepository.save(new Doctorant(null,"123","Pa11223","ali","aliilo",p3,null,null,null));
			sujetTheseRepository.deleteAll();
			List<Doctorant> l = new ArrayList<>();
			l.add(d);
			SujetThese s1 = sujetTheseRepository.save(new SujetThese(null,"sujetthese1","description sujet 1 these","sujet these 1 ",null));
			SujetThese s2 = sujetTheseRepository.save(new SujetThese(null,"sujetthese2","description sujet 2 these","sujet these 2 ",null));
			SujetThese s3 = sujetTheseRepository.save(new SujetThese(null,"sujetthese3","description sujet 3 these","sujet these 3 ",null));
			SujetThese s4 = sujetTheseRepository.save(new SujetThese(null,"sujetthese4","description sujet 4 these","sujet these 4 ",null));
			SujetThese s5 = sujetTheseRepository.save(new SujetThese(null,"sujetthese5","description sujet 5 these","sujet these 5 ",null));

			meetingRepository.deleteAll();
			Date date = new Date();
			Instant instant = date.toInstant();
			LocalDateTime localDateTime = instant.atZone(ZoneId.systemDefault()).toLocalDateTime();

			Meeting m1 = meetingRepository.save(new Meeting(null,"sujet meeting 1 ",localDateTime,"ddepartement informatique1","description meeting1","compte rendu1",d1));
			Meeting m2 = meetingRepository.save(new Meeting(null,"sujet meeting 2 ",localDateTime,"ddepartement informatique1","description meeting1","compte rendu1",d1));
			Meeting m3 = meetingRepository.save(new Meeting(null,"sujet meeting 3 ",localDateTime,"ddepartement informatique1","description meeting1","compte rendu1",d1));
			Meeting m4 = meetingRepository.save(new Meeting(null,"sujet meeting 4 ",localDateTime,"ddepartement informatique1","description meeting1","compte rendu1",d1));

			absenceRepository.deleteAll();
			absenceRepository.save(new Absence(null,m1,d1,localDateTime,"raison absence1","raison absence1"));
			absenceRepository.save(new Absence(null,m2,d1,localDateTime,"raison absence2","raison absence2"));
			absenceRepository.save(new Absence(null,m3,d1,localDateTime,"raison absence3","raison absence3"));
			absenceRepository.save(new Absence(null,m4,d1,localDateTime,"raison absence4","raison absence4"));


		};
	}


}
