package com.MGLC.activitesdoctorants.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "personne_type")
@AllArgsConstructor @NoArgsConstructor @Data
public class Personne {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer identifiant;
    private String nom;
    private String prenom;
    private String photo;
    private String email;
    private String login;
    private String motDePasse;
    private String adresse;
    @OneToMany
    private List<AxeRecherche> axeRecherches;
    @OneToMany
    private List<Message> messages;

    public Personne(String nom,String prenom,String photo,String email,String login,String motDePasse,String adresse){
        this.nom=nom;
        this.prenom=prenom;
        this.photo=photo;
        this.email=email;
        this.login=login;
        this.motDePasse=motDePasse;
        this.adresse=adresse;
    }
}
