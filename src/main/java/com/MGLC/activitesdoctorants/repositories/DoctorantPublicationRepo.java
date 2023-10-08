package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.DoctorantPublication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DoctorantPublicationRepo extends JpaRepository<DoctorantPublication, Long> {
}
