package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Professeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfesseurRepository extends JpaRepository<Professeur, Long> {
    // Add custom query methods if needed
}
