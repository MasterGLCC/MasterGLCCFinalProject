package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Absence {
    @Id
    private Integer absenceID;
    private Integer reunionID;
    private Integer doctorantID;
    private String raisonAbsence;
    @ManyToOne
    private Reunion reunion;
    @ManyToOne
    private SujetThese sujetThese;
}
