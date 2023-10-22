package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.AxeRecherche;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AxeRechercheRepository extends JpaRepository<AxeRecherche, Integer> {
}
