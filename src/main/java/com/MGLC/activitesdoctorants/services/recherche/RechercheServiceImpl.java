package com.MGLC.activitesdoctorants.services.recherche;

import com.MGLC.activitesdoctorants.dto.RechercheResponse;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.Personne;
import com.MGLC.activitesdoctorants.entities.Professeur;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import com.MGLC.activitesdoctorants.repositories.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import java.util.Arrays;
import java.util.List;

@Service
@AllArgsConstructor
public class RechercheServiceImpl implements RechercheService{
    private final AxeRechercheRepository axeRechercheRepository;
    private final EntityManager entityManager;
    private final DoctorantRepository doctorantRepository;
    private final SujetTheseRepository sujetTheseRepository;
    private final ProfesseurRepository professeurRepository;

    @Override
    public RechercheResponse recherche(String cle, int firstResult, int maxResult){
        RechercheResponse rechercheResponse = new RechercheResponse();
        String[] cles = cle.split(" ");
        if (cles.length == 1) {
            String c1 = cles[0];
            List<Doctorant> doctorants = doctorantRepository.findByNomOrPrenom(entityManager, c1, null, firstResult, maxResult);
            rechercheResponse.setDoctorants(doctorants);
            List<Professeur> professeurs = professeurRepository.findByNomOrPrenom(entityManager, c1, null, firstResult, maxResult);
            rechercheResponse.setProfesseurs(professeurs);
            List<SujetThese> sujetTheses = sujetTheseRepository.findByMotCles(entityManager, c1, null, firstResult, maxResult);
            rechercheResponse.getSujetThese().addAll(sujetTheses);
        }
        if (cles.length > 1) {
            String c1 = cles[0];
            String c2 = cles[1];
            List<Doctorant> doctorants = doctorantRepository.findByNomOrPrenom(entityManager, c1, c2, firstResult, maxResult);
            rechercheResponse.setDoctorants(doctorants);
            List<Professeur> professeurs = professeurRepository.findByNomOrPrenom(entityManager, c1, c2, firstResult, maxResult);
            rechercheResponse.setProfesseurs(professeurs);
            List<SujetThese> sujetTheses = sujetTheseRepository.findByMotCles(entityManager, c1, c2, firstResult, maxResult);
            rechercheResponse.getSujetThese().addAll(sujetTheses);
        }
        return rechercheResponse;
    }

    @Override
    public Long count(String cle, String type){
        Long count = 0L;
        String[] cles = cle.split(" ");
        if (cles.length == 1) {
            String c = cles[0];
            switch (type){
                case "p" :
                    count = (Long) professeurRepository.count(entityManager, c, null);
                    break;
                case "d" :
                    count = (Long) doctorantRepository.count(entityManager, c, null);
                    break;
                case "t":
                    count = (Long) sujetTheseRepository.count(entityManager, c, null);
                    break;
            }
            return (count / 15) + 1;
        } else {
            String c1 = cles[0];
            String c2 = cles[1];
            switch (type){
                case "p" :
                    count = (Long) professeurRepository.count(entityManager, c1, c2);
                    break;
                case "d" :
                    count = (Long) doctorantRepository.count(entityManager, c1, c2);
                    break;
                case "t":
                    count = (Long) sujetTheseRepository.count(entityManager, c1, c2);
                    break;
            }
            return (count / 15) + 1;
        }
    }
}
