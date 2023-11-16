package com.MGLC.activitesdoctorants.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Doctorant {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apogee;

    @Column(name = "CNE", nullable = false, columnDefinition = "VARCHAR(255) DEFAULT 'DefaultCNEValue'")
    private String CNE;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "directeur_id")
    @JsonIgnore
    private Professeur directeurThese;

    @OneToMany(mappedBy = "doctorant")
    @JsonIgnore
    private List<Meeting> meetings;

    @OneToMany(mappedBy = "doctorant")
    @JsonIgnore
    private List<Absence> absences;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "doctorant_sujet",
            joinColumns = @JoinColumn(name = "doctorant_id"),
            inverseJoinColumns = @JoinColumn(name = "sujet_id")
    )
    @JsonIgnore
    private List<SujetThese> sujetsThese;


    @Override
    public String toString() {
        return "Doctorant{" +
                "id=" + id +
                ", apogee='" + apogee + '\'' +
                ", CNE='" + CNE + '\'' +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", directeurThese=" + directeurThese +
                ", meetings=" + meetings +
                ", absences=" + absences +
                ", sujetsThese=" + sujetsThese +
                '}';
    }
}
