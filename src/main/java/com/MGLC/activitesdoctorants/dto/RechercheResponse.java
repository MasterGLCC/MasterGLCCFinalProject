package com.MGLC.activitesdoctorants.dto;

import com.MGLC.activitesdoctorants.entities.Doctorant;
import com.MGLC.activitesdoctorants.entities.Professeur;
import com.MGLC.activitesdoctorants.entities.SujetThese;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor @Data
public class RechercheResponse {
    List<Professeur> professeurs = new ArrayList<>();
    List<Doctorant> doctorants = new ArrayList<>();
    List<SujetThese> sujetThese = new ArrayList<>();
}
