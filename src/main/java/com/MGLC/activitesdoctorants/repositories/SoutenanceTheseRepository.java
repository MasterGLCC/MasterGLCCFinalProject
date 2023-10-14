package com.MGLC.activitesdoctorants.repositories;

import com.MGLC.activitesdoctorants.entities.SoutenanceThese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SoutenanceTheseRepository extends JpaRepository<SoutenanceThese, Integer> {
}
