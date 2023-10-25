package com.glcc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="doctorant")
public class Doctorant extends Personne {
	

	@Column
	private String cne;
	@Column
	private String apoge; 
	

	public Doctorant() {
		super();
	}

	

	public Doctorant(Long identifiant, String nom, String email, String phone, String cin, byte[] photo, String login,
			String pwd) {
		super(identifiant, nom, email, phone, cin, photo, login, pwd);
		// TODO Auto-generated constructor stub
	}



	public String getCne() {
		return cne;
	}

	public void setCne(String cne) {
		this.cne = cne;
	}

	public String getApoge() {
		return apoge;
	}

	public void setApoge(String apoge) {
		this.apoge = apoge;
	}

	
	

}