package com.MGLC.activitesdoctorants.dto;

import lombok.Data;

@Data
public class DoctorantDto {

    private String apogee;
    private String CNE;
    private String nom; // Add more properties as needed
    private String prenom;
    private Long DirecteurThese;
    private Long idThese;

    // Constructors, getters, setters, and any other methods

    public DoctorantDto() {
        // Default constructor
    }

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

    // Add getters and setters for the new properties
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

    // Constructors, getters, setters, and any other methods
}
