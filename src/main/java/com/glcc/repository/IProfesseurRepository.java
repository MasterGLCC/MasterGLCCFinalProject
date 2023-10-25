package com.glcc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.glcc.models.Professeur;

@Repository
public interface IProfesseurRepository extends JpaRepository<Professeur, Long> {

}
