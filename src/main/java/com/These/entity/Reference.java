package com.These.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Reference {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(insertable = false, updatable = false)
	private int referenceId;
	private String auteur;
	private String titre;
	private String anneeEdition;
	private ReferenceType referenceType;
	
	@ManyToOne
    @JoinColumn(name = "sujetTheseID")
	private Sujet sujet;
	

	
	public enum ReferenceType {
        LIVRE,
        ARTICLE,
        VIDEO
    }

	public Reference() {
		super();
	}

	public void setSujet(Sujet sujet) {
        this.sujet = sujet;
    }
	
	
	
	public Reference(int referenceId, String auteur, String titre, String anneeEdition, ReferenceType referenceType) {
		super();
		this.referenceId = referenceId;
		this.auteur = auteur;
		this.titre = titre;
		this.anneeEdition = anneeEdition;
		this.referenceType = referenceType;
	}

	public int getReferenceId() {
		return referenceId;
	}

	public void setReferenceId(int referenceId) {
		this.referenceId = referenceId;
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

	public String getAnneeEdition() {
		return anneeEdition;
	}

	public void setAnneeEdition(String anneeEdition) {
		this.anneeEdition = anneeEdition;
	}

	public ReferenceType getReferenceType() {
		return referenceType;
	}

	public void setReferenceType(ReferenceType referenceType) {
		this.referenceType = referenceType;
	}
	
	
	
}
