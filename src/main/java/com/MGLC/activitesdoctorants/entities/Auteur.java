package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
@DiscriminatorValue(value = "AUTEUR")
@AllArgsConstructor @NoArgsConstructor @Data
public class Auteur extends Personne{
    private String role;
    private String dateContribution;
    @ManyToMany
    private List<Publication> publications = new ArrayList<>();
}
