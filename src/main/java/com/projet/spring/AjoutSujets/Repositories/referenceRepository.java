package com.projet.spring.AjoutSujets.Repositories;

import com.projet.spring.AjoutSujets.Entities.reference;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface referenceRepository extends JpaRepository<reference,Long> {
}
