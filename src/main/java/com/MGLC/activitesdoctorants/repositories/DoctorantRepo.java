package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantRepo extends JpaRepository<Doctorant, Long> {

}
