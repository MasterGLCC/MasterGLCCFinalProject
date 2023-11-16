package com.MGLC.activitesdoctorants.services;

import com.MGLC.activitesdoctorants.dto.ProfesseurDto;
import com.MGLC.activitesdoctorants.entities.Professeur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MGLC.activitesdoctorants.repositories.ProfesseurRepository;

import java.util.List;
import java.util.Optional;

@Service
public class ProfesseurService {

    @Autowired
    private ProfesseurRepository professeurRepository;

    public Professeur createProfesseur(ProfesseurDto professeurDto) {
        Professeur professeur = new Professeur();
        // Map properties from ProfesseurDto to Professeur
        professeur.setNom(professeurDto.getNom());
        professeur.setPrenom(professeurDto.getPrenom());
        // Set other properties as needed

        return professeurRepository.save(professeur);
    }

    public Professeur getProfesseurById(Long id) {
        Optional<Professeur> optionalProfesseur = professeurRepository.findById(id);
        return optionalProfesseur.orElse(null);
    }

    public List<Professeur> getAllProfesseurs() {
        return professeurRepository.findAll();
    }

    public Professeur updateProfesseur(Long id, ProfesseurDto updatedProfesseurDto) {
        Optional<Professeur> optionalProfesseur = professeurRepository.findById(id);
        if (optionalProfesseur.isPresent()) {
            Professeur professeur = optionalProfesseur.get();
            // Update properties of the Professeur entity with values from the updatedProfesseurDto
            professeur.setNom(updatedProfesseurDto.getNom());
            professeur.setPrenom(updatedProfesseurDto.getPrenom());
            // Update other properties as needed

            return professeurRepository.save(professeur);
        }
        return null; // Professeur not found
    }

    public boolean deleteProfesseur(Long id) {
        Optional<Professeur> optionalProfesseur = professeurRepository.findById(id);
        if (optionalProfesseur.isPresent()) {
            Professeur professeur = optionalProfesseur.get();
            // Remove any associations (e.g., doctorants) before deleting if needed
            // professeur.getDoctorants().clear();
            professeurRepository.delete(professeur);
            return true;
        }
        return false; // Professeur not found
    }

    // Add more methods as needed for business logic related to Professeurs
}
