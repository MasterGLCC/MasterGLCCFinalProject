package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Departement {
    @Id
    private Integer departementID;
    @OneToMany
    private List<Professeur> professeurs = new ArrayList<>();
    @OneToMany
    private List<Doctorant> doctorants = new ArrayList<>();
}
