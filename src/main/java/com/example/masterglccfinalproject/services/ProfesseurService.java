package com.example.masterglccfinalproject.services;

import com.example.masterglccfinalproject.entities.Doctorant;
import com.example.masterglccfinalproject.entities.Professeur;
import com.example.masterglccfinalproject.repositories.DoctorantRepository;
import com.example.masterglccfinalproject.repositories.ProfesseurRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfesseurService {
    private final ProfesseurRepository professeurRepository;
    @Autowired
    public ProfesseurService(ProfesseurRepository professeurRepository) {
        this.professeurRepository = professeurRepository;
    }

    public List<Professeur> getAllProfesseurs() {

        return professeurRepository.findAll();
    }

    public Professeur enregistrerProfesseur(Professeur professeur) {

        return professeurRepository.save(professeur);
    }

    public Professeur getProfesseurById(Long id) {

        return professeurRepository.findById(id).get();
    }

    public Professeur modifierProfesseur(Professeur professeur) {

        return professeurRepository.save(professeur);
    }

    public void supprimerProfesseurById(Long id) {

     professeurRepository.deleteById(id);
    }

}
