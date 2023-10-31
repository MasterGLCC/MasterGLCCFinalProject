package com.example.masterglccfinalproject.entities;



import javax.lang.model.type.ReferenceType;
import javax.persistence.*;

@Entity
@Table(name = "references")
public class Reference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long referenceID;

    private String auteur;
    private String titre;
    private String anneEdition;



    public Reference(Long referenceID, String auteur, String titre, String anneEdition) {
        this.referenceID = referenceID;
        this.auteur = auteur;
        this.titre = titre;
        this.anneEdition = anneEdition;
    }

    public Reference() {

    }

    public Long getReferenceID() {
        return referenceID;
    }

    public void setReferenceID(Long referenceID) {
        this.referenceID = referenceID;
    }

    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getAnneEdition() {
        return anneEdition;
    }

    public void setAnneEdition(String anneEdition) {
        this.anneEdition = anneEdition;
    }



}
