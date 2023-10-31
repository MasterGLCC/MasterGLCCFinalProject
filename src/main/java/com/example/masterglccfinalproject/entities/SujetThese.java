package com.example.masterglccfinalproject.entities;



import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "sujetsThese")
public class SujetThese {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long sujetTheseID;

    private String titre;
    private String description;
    private String motsCles;


    public SujetThese(Long sujetTheseID, String titre, String description, String motsCles) {
        this.sujetTheseID = sujetTheseID;
        this.titre = titre;
        this.description = description;
        this.motsCles = motsCles;
    }

    public SujetThese() {

    }

    public Long getSujetTheseID() {
        return sujetTheseID;
    }

    public void setSujetTheseID(Long sujetTheseID) {
        this.sujetTheseID = sujetTheseID;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }


}
