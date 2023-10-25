package com.glcc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="professeur")
public class Professeur extends Personne {
	
	@Column
	@Enumerated(EnumType.STRING)
	private Grade grade;
	@Column
	private String etablissement;
	@Column
	private String specialite;
	
	
	
	public Professeur(Long identifiant,String nom, String email, String phone, String cin, byte[] photo, String login,
			String pwd) {
		super(identifiant, nom, email, phone, cin, photo, login, pwd);
		// TODO Auto-generated constructor stub
	}
	


	public Professeur() {
		
	}

	public Grade getGrade() {
		return grade;
	}

	public void setGrade(Grade grade) {
		this.grade = grade;
	}

	public String getEtablissement() {
		return etablissement;
	}

	public void setEtablissement(String etablissement) {
		this.etablissement = etablissement;
	}

	public String getSpecialite() {
		return specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}

	

}