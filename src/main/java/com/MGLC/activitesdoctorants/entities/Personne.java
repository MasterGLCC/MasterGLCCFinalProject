package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(builderMethodName = "personneBuilder")
@Data
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "entity_type")
@DiscriminatorValue("personne")
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "Identifiant")
    private Long id;

    @Column(name = "Nom")
    private String fname;
    @Column(name = "Prenom")
    private String lname;
    @Column(name = "CIN")
    private String cin;

    @Column(name = "Photo")
    private String picture;
    @Column(name = "Email")
    private String email;
    @Column(name = "Login")
    private String login;
    @Column(name = "MotDePasse")
    private String password;
    @Column(name = "Adresse")
    private String adresse;
    @ManyToMany
    private List<Publication> publications = new ArrayList<Publication>();
}
