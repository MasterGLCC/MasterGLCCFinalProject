package com.MGLC.activitesdoctorants.repositories;


import com.MGLC.activitesdoctorants.entities.Absence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AbsenceRepo extends JpaRepository<Absence, Long> {

    List<Absence> findByDoctorant(Long doctorantId);

    @Query("SELECT YEAR(r.date) AS year, COUNT(a.id) AS absenceCount, COUNT(r.id) AS totalReunions " +
            "FROM Reunion r " +
            "LEFT JOIN Absence a ON r = a.reunion AND a.doctorant.id = :doctorantId " +
            "GROUP BY YEAR(r.date)")
    List<Object[]> countAbsencesByYear(@Param("doctorantId") Long doctorantId);

}
