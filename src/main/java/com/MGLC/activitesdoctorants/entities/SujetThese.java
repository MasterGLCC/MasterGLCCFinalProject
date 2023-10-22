package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class SujetThese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer sujetTheseID;
    private String titre;
    private String description;
    private String motCles;
    @OneToMany
    private List<Reference> listReferences = new ArrayList<>();
    @OneToOne
    private DossierDoctorant dossierDoctorant;
    @OneToOne
    private Doctorant doctorant;
    @ManyToOne
    private Professeur professeur;
    @ManyToOne
    private Reunion reunion;
    @OneToOne
    private SoutenanceThese soutenanceThese;
    @OneToMany
    private List<EtatAvancement> etatAvancements;
}
