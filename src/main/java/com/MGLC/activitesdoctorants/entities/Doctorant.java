package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "DOCTORANT")
@AllArgsConstructor @NoArgsConstructor @Data
public class Doctorant extends Personne{
    private String apogee;
    private String cne;
    @ManyToOne
    private Departement departement;
    @ManyToMany
    private List<Reunion> reunions = new ArrayList<>();
    @OneToOne
    private DossierDoctorant dossierDoctorant;
    @OneToOne
    private SujetThese sujetThese;
}
