package com.example.masterglccfinalproject.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "doctorants")
@PrimaryKeyJoinColumn(name = "personne_id")
public class Doctorant extends Personne {
    private String adresse;
    private String apogee;
    private String cne;

    @ManyToOne
    private Professeur encadrant;

    @ManyToMany
    private List<Professeur> coEncadrants;

    @ManyToOne
    private SujetThese sujetThese;

    public Doctorant(String adresse, String apogee, String cne, Professeur encadrant, List<Professeur> coEncadrants, SujetThese sujetThese) {
        this.adresse = adresse;
        this.apogee = apogee;
        this.cne = cne;
        this.encadrant = encadrant;
        this.coEncadrants = coEncadrants;
        this.sujetThese = sujetThese;
    }

    public Doctorant(Long identifiant, String nom, String prenom, String cin, String photo, String email, String login, String motDePasse, String adresse, String apogee, String cne, Professeur encadrant, List<Professeur> coEncadrants, SujetThese sujetThese) {
        super(identifiant, nom, prenom, cin, photo, email, login, motDePasse);
        this.adresse = adresse;
        this.apogee = apogee;
        this.cne = cne;
        this.encadrant = encadrant;
        this.coEncadrants = coEncadrants;
        this.sujetThese = sujetThese;
    }

    public Doctorant() {

    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getApogee() {
        return apogee;
    }

    public void setApogee(String apogee) {
        this.apogee = apogee;
    }

    public String getCne() {
        return cne;
    }

    public void setCne(String cne) {
        this.cne = cne;
    }

    public Professeur getEncadrant() {
        return encadrant;
    }

    public void setEncadrant(Professeur encadrant) {
        this.encadrant = encadrant;
    }

    public List<Professeur> getCoEncadrants() {
        return coEncadrants;
    }

    public void setCoEncadrants(List<Professeur> coEncadrants) {
        this.coEncadrants = coEncadrants;
    }

    public SujetThese getSujetThese() {
        return sujetThese;
    }

    public void setSujetThese(SujetThese sujetThese) {
        this.sujetThese = sujetThese;
    }
}
