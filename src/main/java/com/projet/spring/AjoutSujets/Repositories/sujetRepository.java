package com.projet.spring.AjoutSujets.Repositories;
import com.projet.spring.AjoutSujets.Entities.sujetThese;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface sujetRepository extends JpaRepository<sujetThese,Long> {


}
