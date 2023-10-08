package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.DossierDoctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DossierDoctorantRepo extends JpaRepository<DossierDoctorant, Long> {
}
