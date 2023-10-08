package com.MGLC.activitesdoctorants.services;


import com.MGLC.activitesdoctorants.entities.EtatAvancement;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import com.MGLC.activitesdoctorants.repositories.EtatAvancementRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SujetTheseService {
    private final EtatAvancementRepo etatAvancementRepo;

    public List<EtatAvancement> getEtatsAvancementForSujetThese(SujetThese sujetThese) {
        return etatAvancementRepo.findBySujetThese(sujetThese);
    }
}
