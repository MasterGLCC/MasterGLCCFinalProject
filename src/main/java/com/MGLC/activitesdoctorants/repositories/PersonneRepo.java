package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepo extends JpaRepository<Personne, Long> {
}
