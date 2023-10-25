package com.glcc.models;

import java.util.Base64;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Table;
import jakarta.transaction.Transactional;

@MappedSuperclass
public class Personne {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long identifiant;
	@Column
	private String nom;
	@Column
	private String email; 
	
	@Lob
	@Column(columnDefinition = "MEDIUMBLOB")
	private byte[] photo;
	@Column
	private String phone;
	@Column
	private String cin;
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	@Column
	private String login;
	@Column
	private String pwd;
	
	
	public Personne(Long identifiant, String nom, String email, String phone, String cin, byte[] photo, String login,
			String pwd) {
		super();
		this.identifiant = identifiant;
		this.nom = nom;
		this.email = email;
		this.phone = phone;
		this.cin = cin;
		this.photo = photo;
		this.login = login;
		this.pwd = pwd;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public byte[] getPhoto() {
		return photo;
	}
	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}
	
	public Personne() {
		super();
	}
	public Long getIdentifiant() {
		return identifiant;
	}
	public void setIdentifiant(Long identifiant) {
		this.identifiant = identifiant;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public String getCin() {
		return cin;
	}
	public void setCin(String cin) {
		this.cin = cin;
	}
	/*
	@PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public String getBase64Photo(Long personneId) {
        // Récupérez l'entité Personne depuis la base de données
        Personne personne = entityManager.find(Personne.class, personneId);

        if (personne != null && personne.getPhoto() != null) {
            // Récupérez les données binaires de la colonne "photo" de l'entité
            byte[] photoData = personne.getPhoto();

            // Convertissez les données binaires en une chaîne base64
            String base64Photo = Base64.getEncoder().encodeToString(photoData);

            return base64Photo;
        }

        return null; // Retournez null si la personne n'existe pas ou si la photo est vide
    }*/
	

}
