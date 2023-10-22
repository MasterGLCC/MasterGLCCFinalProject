package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class DossierDoctorant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer dossierID;
    private String numeroReference;
    @OneToOne
    private SujetThese sujetThese;
    @OneToOne
    private Doctorant doctorant;
    @OneToMany
    private List<Diplome> diplomes;

    public DossierDoctorant(String n){
        this.numeroReference = n;
    }
}
