package com.MGLC.activitesdoctorants.services;


import com.MGLC.activitesdoctorants.dto.DoctorantDto;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import com.MGLC.activitesdoctorants.repositories.ProfesseurRepository;
import com.MGLC.activitesdoctorants.repositories.SujetTheseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.MGLC.activitesdoctorants.repositories.DoctorantRepository;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorantService {

    @Autowired
    private DoctorantRepository doctorantRepository;
    @Autowired
    private SujetTheseRepository sujetTheseRepository;

    @Autowired
    private ProfesseurRepository professeurRepository;

    public Doctorant addDoctorant(DoctorantDto doctorantDto) {
        // Convert DoctorantDto to Doctorant entity
        Doctorant doctorant = new Doctorant();
        doctorant.setApogee(doctorantDto.getApogee());
        doctorant.setCNE(doctorantDto.getCNE());
        doctorant.setNom(doctorantDto.getNom());
        doctorant.setPrenom(doctorantDto.getPrenom());
        doctorant.setDirecteurThese(professeurRepository.findById(doctorantDto.getDirecteurThese()).get());
        return doctorantRepository.save(doctorant);
    }

    public List<Doctorant> getAllDoctorants() {
        return doctorantRepository.findAll();
    }

    public Doctorant getDoctorantById(Long id) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        return optionalDoctorant.orElse(null);
    }

    public Doctorant updateDoctorant(Long id, DoctorantDto updatedDoctorantDto) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        if (optionalDoctorant.isPresent()) {
            Doctorant doctorant = optionalDoctorant.get();
            doctorant.setApogee(updatedDoctorantDto.getApogee());
            doctorant.setCNE(updatedDoctorantDto.getCNE());
            // Update other properties if needed

            return doctorantRepository.save(doctorant);
        }
        return null; // Doctorant not found
    }

    public boolean deleteDoctorant(Long id) {
        Optional<Doctorant> optionalDoctorant = doctorantRepository.findById(id);
        if (optionalDoctorant.isPresent()) {
            doctorantRepository.delete(optionalDoctorant.get());
            return true;
        }
        return false; // Doctorant not found
    }
}
