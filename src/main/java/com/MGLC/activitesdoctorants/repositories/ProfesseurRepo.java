package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepo extends JpaRepository<Professeur, Long> {
}
