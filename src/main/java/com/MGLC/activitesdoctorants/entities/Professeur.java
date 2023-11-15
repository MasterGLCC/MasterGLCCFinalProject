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

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String phoneNumber;

    @OneToMany(mappedBy = "directeurThese", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Doctorant> doctorantsDirectes;

    // Constructors, getters, setters, and any other methods

    public Professeur() {
        // Default constructor
    }

    // Add other constructors as needed

    // Getter and Setter methods for other fields
    // Implement getter and setter methods for other fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<Doctorant> getDoctorantsDirectes() {
        return doctorantsDirectes;
    }

    public void setDoctorantsDirectes(List<Doctorant> doctorantsDirectes) {
        this.doctorantsDirectes.clear();
        if (doctorantsDirectes != null) {
            this.doctorantsDirectes.addAll(doctorantsDirectes);
        }
    }
}
