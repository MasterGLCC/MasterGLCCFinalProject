package com.These.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Sujet {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "sujetTheseID")
	private int sujetTheseID;
	private String titre;
	private String description;
	private String motsCles;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sujet")
	private List<Reference> listeReferences;
	
	public Sujet() {
		super();
	}
	public Sujet(int sujetTheseID, String titre, String description, String motsCles, List<Reference> listeReferences) {
		super();
		this.sujetTheseID = sujetTheseID;
		this.titre = titre;
		this.description = description;
		this.motsCles = motsCles;
		this.listeReferences = listeReferences;
	}
	public int getSujetTheseID() {
		return sujetTheseID;
	}
	public void setSujetTheseID(int sujetTheseID) {
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
	public List<Reference> getListeReferences() {
		return listeReferences;
	}
	public void setListeReferences(List<Reference> listeReferences) {
		this.listeReferences = listeReferences;
	};
	
    
}
