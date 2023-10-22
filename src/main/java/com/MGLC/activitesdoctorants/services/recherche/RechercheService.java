package com.MGLC.activitesdoctorants.services.recherche;

import com.MGLC.activitesdoctorants.dto.RechercheResponse;

public interface RechercheService {
    RechercheResponse recherche(String cle, int firstResult, int maxResult);

    Long count(String cle, String type);
}
