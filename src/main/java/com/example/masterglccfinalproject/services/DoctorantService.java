package com.example.masterglccfinalproject.services;

import com.example.masterglccfinalproject.entities.Doctorant;
import com.example.masterglccfinalproject.repositories.DoctorantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorantService {
    private final DoctorantRepository doctorantRepository;
    @Autowired
    public DoctorantService(DoctorantRepository doctorantRepository) {
        this.doctorantRepository = doctorantRepository;
    }

    public List<Doctorant> getAllDoctorants() {

        return doctorantRepository.findAll();
    }

    public Doctorant enregistrerDoctorant(Doctorant doctorant) {

        return doctorantRepository.save(doctorant);
    }

    public Doctorant getDoctorantById(Long id) {

        return doctorantRepository.findById(id).get();
    }

    public Doctorant modifierDoctorant(Doctorant doctorant) {

        return doctorantRepository.save(doctorant);
    }


    public void supprimerDoctorantById(Long id) {

        doctorantRepository.deleteById(id);
    }

}
