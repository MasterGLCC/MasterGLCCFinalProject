package com.example.masterglccfinalproject.services;

import com.example.masterglccfinalproject.entities.Doctorant;
import com.example.masterglccfinalproject.entities.SujetThese;
import com.example.masterglccfinalproject.repositories.DoctorantRepository;
import com.example.masterglccfinalproject.repositories.SujetTheseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SujetTheseService {

    private final SujetTheseRepository sujetTheseRepository;
    @Autowired
    public SujetTheseService(SujetTheseRepository sujetTheseRepository) {
        this.sujetTheseRepository = sujetTheseRepository;
    }

    public List<SujetThese> getAllSujetThese() {

        return sujetTheseRepository.findAll();
    }

    public SujetThese enregistrerSujetThese(SujetThese sujetThese) {
        return sujetTheseRepository.save(sujetThese);
    }

    public SujetThese getSujetTheseById(Long id) {

        return sujetTheseRepository.findById(id).get();
    }

    public SujetThese modifierSujetThese(SujetThese sujetThese) {

        return sujetTheseRepository.save(sujetThese);
    }


    public void supprimerSujetTheseById(Long id) {

        sujetTheseRepository.deleteById(id);
    }
}
