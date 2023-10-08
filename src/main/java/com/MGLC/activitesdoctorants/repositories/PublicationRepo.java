package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.Publication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepo extends JpaRepository<Publication, Long> {

    // @Query("SELECT p FROM Publication p JOIN p.auteur ap WHERE ap.auteur.id =
    // :doctorantId")
    // List<Publication> findPublicationsByDoctorantId(@Param("doctorantId") Long
    // doctorantId);

    List<Publication> findByAuteurId(Long doctorantId);

}
