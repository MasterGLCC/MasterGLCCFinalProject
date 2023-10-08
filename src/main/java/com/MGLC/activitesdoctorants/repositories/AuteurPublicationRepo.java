package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.AuteurPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuteurPublicationRepo extends JpaRepository<AuteurPublication, Long> {

}
