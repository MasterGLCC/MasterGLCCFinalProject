package com.MGLC.activitesdoctorants.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Doctorant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String apogee;

    @Column(nullable = false)
    private String CNE;

    // Add more fields as needed
    // For example:
    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    // Define other fields here...

    @ManyToOne
    @JoinColumn(name = "directeur_id")
    private Professeur directeurThese;

    @ManyToMany(mappedBy = "doctorants")
    private List<SujetThese> sujetsThese;

    // Constructors, getters, setters, and any other methods

    public Doctorant() {
        // Default constructor
    }

    // Add other constructors as needed
    public Doctorant(String apogee, String CNE, String nom, String prenom) {
        this.apogee = apogee;
        this.CNE = CNE;
        this.nom = nom;
        this.prenom = prenom;
    }

    // Getter and Setter methods for other fields
    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    // Implement getter and setter methods for other fields

    public String getApogee() {
        return apogee;
    }

    public void setApogee(String apogee) {
        this.apogee = apogee;
    }

    public String getCNE() {
        return CNE;
    }

    public void setCNE(String CNE) {
        this.CNE = CNE;
    }

    public Professeur getDirecteurThese() {
        return directeurThese;
    }

    public void setDirecteurThese(Professeur directeurThese) {
        this.directeurThese = directeurThese;
    }

    public List<SujetThese> getSujetsThese() {
        return sujetsThese;
    }

    public void setSujetsThese(List<SujetThese> sujetsThese) {
        this.sujetsThese = sujetsThese;
    }
}
