package com.MGLC.activitesdoctorants.services;

import com.MGLC.activitesdoctorants.dto.SujetTheseDto;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import com.MGLC.activitesdoctorants.repositories.SujetTheseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SujetTheseService {

    @Autowired
    private SujetTheseRepository sujetTheseRepository;

    public SujetThese createSujetThese(SujetTheseDto sujetTheseDto) {
        SujetThese sujetThese = new SujetThese();
        // Map properties from SujetTheseDto to SujetThese
        sujetThese.setTitre(sujetTheseDto.getTitre());
        sujetThese.setDescription(sujetTheseDto.getDescription());
        // Set other properties as needed

        return sujetTheseRepository.save(sujetThese);
    }

    public SujetThese getSujetTheseById(Long id) {
        Optional<SujetThese> optionalSujetThese = sujetTheseRepository.findById(id);
        return optionalSujetThese.orElse(null);
    }

    public List<SujetThese> getAllSujetThese() {
        return sujetTheseRepository.findAll();
    }

    public SujetThese updateSujetThese(Long id, SujetTheseDto updatedSujetTheseDto) {
        Optional<SujetThese> optionalSujetThese = sujetTheseRepository.findById(id);
        if (optionalSujetThese.isPresent()) {
            SujetThese sujetThese = optionalSujetThese.get();
            // Update properties of the SujetThese entity with values from the updatedSujetTheseDto
            sujetThese.setTitre(updatedSujetTheseDto.getTitre());
            sujetThese.setDescription(updatedSujetTheseDto.getDescription());
            // Update other properties as needed

            return sujetTheseRepository.save(sujetThese);
        }
        return null; // SujetThese not found
    }

    public boolean deleteSujetThese(Long id) {
        Optional<SujetThese> optionalSujetThese = sujetTheseRepository.findById(id);
        if (optionalSujetThese.isPresent()) {
            SujetThese sujetThese = optionalSujetThese.get();
            // Remove any associations (e.g., doctorants) before deleting if needed
            // sujetThese.getDoctorants().clear();
            sujetTheseRepository.delete(sujetThese);
            return true;
        }
        return false; // SujetThese not found
    }

    // Add more methods as needed for business logic related to SujetThese
}
