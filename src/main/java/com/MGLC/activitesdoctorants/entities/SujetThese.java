package com.MGLC.activitesdoctorants.entities;

import javax.persistence.*;
import java.util.List;

@Entity
public class SujetThese {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titre;

    @Column(nullable = false)
    private String description;

    // Add more fields as needed
    // For example:
    @Column(nullable = false)
    private String motsCles;

    @ManyToMany(mappedBy = "sujetsThese")
    private List<Doctorant> doctorants;

    // Constructors, getters, setters, and any other methods

    public SujetThese() {
        // Default constructor
    }

    // Add other constructors as needed
    public SujetThese(String titre, String description, String motsCles) {
        this.titre = titre;
        this.description = description;
        this.motsCles = motsCles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMotsCles() {
        return motsCles;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
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

    public List<Doctorant> getDoctorants() {
        return doctorants;
    }

    public void setDoctorants(List<Doctorant> doctorants) {
        this.doctorants = doctorants;
    }
}
