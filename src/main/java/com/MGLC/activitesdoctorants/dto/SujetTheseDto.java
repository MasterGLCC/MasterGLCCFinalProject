package com.MGLC.activitesdoctorants.dto;

import lombok.Getter;

@Getter
public class SujetTheseDto {

    private String titre;
    private String description;
    private String motsCles;

    public SujetTheseDto() {
        // Default constructor
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setMotsCles(String motsCles) {
        this.motsCles = motsCles;
    }

    // Implement getters and setters for other properties if needed

    @Override
    public String toString() {
        return "SujetTheseDto{" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", motsCles='" + motsCles + '\'' +
                '}';
    }
}
