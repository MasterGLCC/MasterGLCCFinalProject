package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class SoutenanceThese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer soutenanceID;
    private Date dateSoutenance;
    @ManyToMany
    private List<Professeur> listJury;
    private float noteSoutenance;
    @OneToMany
    private List<MembreJury> membreJuries;
    @OneToOne
    private SujetThese sujetThese;

    public SoutenanceThese(Date date){
        dateSoutenance = date;
    }
}
