package com.glcc.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Commentaire")
public class Commentaire {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long IdCmnt;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name="idEtat")
	private Etat_avancement etat;
	
	@Column(nullable=false,columnDefinition="VARCHAR(255) DEFAULT ''")
	private String commentaire;

	public Commentaire() {
		super();
		
	}

	public Long getIdCmnt() {
		return IdCmnt;
	}

	public void setIdCmnt(Long idCmnt) {
		IdCmnt = idCmnt;
	}

	public Etat_avancement getEtat() {
		return etat;
	}

	public void setEtat(Etat_avancement etat) {
		this.etat = etat;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}
	
	public Long getIdEtat() {
		  if (etat != null) {
		        return etat.getIdEtat();
		    } else {
		        return  null;  // ou une autre valeur par défaut selon votre logique
		    }
	}
}
