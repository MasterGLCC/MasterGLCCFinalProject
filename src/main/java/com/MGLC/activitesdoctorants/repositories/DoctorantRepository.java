package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Doctorant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantRepository extends JpaRepository<Doctorant, Long> {
    // Add custom query methods if needed
}
