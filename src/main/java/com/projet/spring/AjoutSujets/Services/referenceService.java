package com.projet.spring.AjoutSujets.Services;

import com.projet.spring.AjoutSujets.Repositories.referenceRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class referenceService {

    @Autowired
    private final referenceRepository referenceRep;
    public referenceService(referenceRepository referenceRep){
        this.referenceRep=referenceRep;
    }

}
