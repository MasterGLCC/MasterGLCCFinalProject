package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.Instant;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@DiscriminatorValue("auteur")
public class Auteur extends Personne{
    @Column(name = "Role")
    private String role;
    @Column(name = "DateContribution")
    private Instant dateContribution;
    // @OneToMany(mappedBy = "auteur")
    // private List<AuteurPublication> publications = new ArrayList<>();


}
