package com.example.masterglccfinalproject.entities;


import javax.persistence.*;

@Table(name = "personnes")
@MappedSuperclass
@Inheritance(strategy = InheritanceType.JOINED)
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long identifiant;

    private String nom;
    private String prenom;
    private String cin;
    private String photo;
    private String email;
    private String login;
    private String motDePasse;

    public Personne() {
    }

    public Personne(Long identifiant, String nom, String prenom, String cin, String photo, String email, String login, String motDePasse) {
        this.identifiant = identifiant;
        this.nom = nom;
        this.prenom = prenom;
        this.cin = cin;
        this.photo = photo;
        this.email = email;
        this.login = login;
        this.motDePasse = motDePasse;
    }

    public Long getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(Long identifiant) {
        this.identifiant = identifiant;
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

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String  getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getMotDePasse() {
        return motDePasse;
    }

    public void setMotDePasse(String motDePasse) {
        this.motDePasse = motDePasse;
    }
}
