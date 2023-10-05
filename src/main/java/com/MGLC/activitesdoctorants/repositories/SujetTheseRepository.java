package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.SujetThese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SujetTheseRepository extends JpaRepository<SujetThese, Long> {
    // Add custom query methods if needed
}
