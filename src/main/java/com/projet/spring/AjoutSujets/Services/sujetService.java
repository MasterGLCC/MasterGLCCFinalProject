package com.projet.spring.AjoutSujets.Services;

import com.projet.spring.AjoutSujets.DTO.sujetResponse;
import com.projet.spring.AjoutSujets.Entities.sujetThese;
import com.projet.spring.AjoutSujets.Repositories.sujetRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.Optional;

@Service
public class sujetService {
    private final sujetRepository sujetRep;

    @Autowired
    public sujetService(sujetRepository sujetRep) {
        this.sujetRep = sujetRep;
    }
    @Transactional
    public sujetThese createSujet(sujetThese sujetThese) {
        return sujetRep.save(sujetThese);
    }
    private sujetResponse mapToSujetResponse(sujetThese sujetThese) {
        return sujetResponse.builder()
                .titre(sujetThese.getTitre())
                .description(sujetThese.getDescription())
                .mots_cles(sujetThese.getMots_cles())
                .References(sujetThese.getReferences())
                .build();

    }
    public List<sujetResponse> getAllSujet() {
        List <sujetThese> Sujets=sujetRep.findAll();
        return Sujets.stream().map(this::mapToSujetResponse).toList();

    }
    public void updateSujet(sujetThese sujetThese) {
        Long sujet_id =  sujetThese.getSujet_id();

        Optional<sujetThese> existingSujetOptional = sujetRep.findById(sujet_id);

        if (existingSujetOptional.isPresent()) {
            sujetThese existingSujet = existingSujetOptional.get();

            existingSujet.setTitre(sujetThese.getTitre());
            existingSujet.setDescription(sujetThese.getDescription());
            existingSujet.setMots_cles(sujetThese.getMots_cles());

            sujetRep.save(existingSujet);
        } else {
            throw new NotFoundException("SujetThese not found with ID: " + sujet_id);
        }
    }

    public sujetThese getSujetById(Long sujet_id) {
        Optional<sujetThese> sujetOptional = sujetRep.findById(sujet_id);
        if (sujetOptional.isPresent()) {
            return sujetOptional.get();
        } else {
            throw new NotFoundException("SujetThese not found with ID: " + sujet_id);
        }
    }
    @Transactional
    public void deleteSujet(Long sujetId) {
        sujetRep.deleteById(sujetId);
    }



}
