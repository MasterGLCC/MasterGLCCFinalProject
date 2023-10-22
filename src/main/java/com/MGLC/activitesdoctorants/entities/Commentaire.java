package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import java.util.List;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Commentaire {
    @Id
    private Integer commentaireID;
    private String comentaire;
    @ManyToOne
    private Professeur professeur;
    @ManyToMany
    private List<EtatAvancement> etatAvancements;
}
