package com.MGLC.activitesdoctorants.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class Professeur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nom;

    @Column(nullable = false)
    private String prenom;

    // Add more fields as needed
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    // Constructors, getters, setters, and any other methods

    public Professeur() {
        // Default constructor
    }

    // Add other constructors as needed
    public Professeur(String nom, String prenom, String email, String phoneNumber) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

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

    @OneToMany(mappedBy = "directeurThese")
    private List<Doctorant> doctorantsDirectes;

    @OneToMany(mappedBy = "coDirecteurThese")
    private List<Doctorant> doctorantsCoDirectes;

    public List<Doctorant> getDoctorantsDirectes() {
        return doctorantsDirectes;
    }

    public void setDoctorantsDirectes(List<Doctorant> doctorantsDirectes) {
        this.doctorantsDirectes = doctorantsDirectes;
    }

    public List<Doctorant> getDoctorantsCoDirectes() {
        return doctorantsCoDirectes;
    }

    public void setDoctorantsCoDirectes(List<Doctorant> doctorantsCoDirectes) {
        this.doctorantsCoDirectes = doctorantsCoDirectes;
    }

    // Implement getter and setter methods for other fields
}
