package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.EtatAvancement;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EtatAvancementRepo extends JpaRepository<EtatAvancement, Long> {
    @Query("SELECT e FROM EtatAvancement e INNER JOIN e.sujetThese s WHERE s.doctorant = :doctorantIdentifiant")
    List<EtatAvancement> findEtatAvancementByDoctorantIdentifiant(
            @Param("doctorantIdentifiant") Long doctorantIdentifiant);

    List<EtatAvancement> findBySujetThese(SujetThese sujetThese);
}
