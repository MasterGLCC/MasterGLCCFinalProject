package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class AuteurPublication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    // @ManyToOne
    // @JoinColumn(name = "pub")
    // private Publication publication;
    // @ManyToOne
    // @JoinColumn(name = "auteur")
    // private Auteur auteur;

}
