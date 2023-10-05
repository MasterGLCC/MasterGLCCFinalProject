package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AbsenceRepository extends JpaRepository<Absence, Long> {
    // Add custom query methods if needed
}
