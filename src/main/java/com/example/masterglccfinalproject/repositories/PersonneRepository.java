package com.example.masterglccfinalproject.repositories;

import com.example.masterglccfinalproject.entities.Personne;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonneRepository extends JpaRepository<Personne, Long> {
}
