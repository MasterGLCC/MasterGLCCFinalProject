package com.MGLC.activitesdoctorants.services;


import com.MGLC.activitesdoctorants.dto.AbsenceDTO;
import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.Publication;
import com.MGLC.activitesdoctorants.repositories.DoctorantRepo;
import com.MGLC.activitesdoctorants.repositories.PublicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoctorantServiceImp implements DoctorantService {
    @Autowired
    private DoctorantRepo doctorantRepo;
    @Autowired
    private PublicationRepo publicationRepo;

    @Override
    public List<Doctorant> loadDoctorants() {
        return doctorantRepo.findAll();
    }

    @Override
    public List<Publication> loadPublications(Long docid) {
        return publicationRepo.findByAuteurId(docid);
    }

    @Override
    public List<AbsenceDTO> absence(int id) {
        int nombreAbsence;
        int nombreReunion;
        // getAllReunion by year
        // iterate over all reunions and check if Doctorant is absent if so incrment
        // nombreAbsence
        return null;
    }
}
