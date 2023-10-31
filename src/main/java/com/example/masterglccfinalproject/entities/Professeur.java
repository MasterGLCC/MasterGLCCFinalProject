package com.example.masterglccfinalproject.entities;


import com.example.masterglccfinalproject.enums.Grade;

import javax.persistence.*;


@Entity
@Table(name = "professeurs")
@PrimaryKeyJoinColumn(name = "personne_id")

public class Professeur extends Personne{
    private String etablissement;

    @Enumerated(EnumType.STRING)
    private Grade grade;

    private String specialite;

    public Professeur(String etablissement, Grade grade, String specialite) {
        this.etablissement = etablissement;
        this.grade = grade;
        this.specialite = specialite;
    }

    public Professeur(Long identifiant, String nom, String prenom, String cin, String photo, String email, String login, String motDePasse, String etablissement, Grade grade, String specialite) {
        super(identifiant, nom, prenom, cin, photo, email, login, motDePasse);
        this.etablissement = etablissement;
        this.grade = grade;
        this.specialite = specialite;
    }

    public Professeur() {

    }

    public String getEtablissement() {
        return etablissement;
    }

    public void setEtablissement(String etablissement) {
        this.etablissement = etablissement;
    }

    public Grade getGrade() {
        return grade;
    }

    public void setGrade(Grade grade) {
        this.grade = grade;
    }

    public String getSpecialite() {
        return specialite;
    }

    public void setSpecialite(String specialite) {
        this.specialite = specialite;
    }
}
