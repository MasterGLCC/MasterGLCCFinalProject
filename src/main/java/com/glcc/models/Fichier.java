package com.glcc.models;

import jakarta.persistence.Table;



import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import lombok.Data;

@Entity
@Table(name="Fichier")
@Data
public class Fichier  {
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private long id;

	  private String name;

	  private String type;

	  @Lob // Cette annotation est utilisée pour déclarer une colonne de type BLOB ou CLOB.
	  @Column(name = "data", columnDefinition = "LONGBLOB")
	  private byte[] data;
	  
	  @ManyToOne(fetch = FetchType.EAGER)
		@JoinColumn(name="idEtat")
		private Etat_avancement etat;
	

	public Etat_avancement getEtat() {
		return etat;
	}

	public void setEtat(Etat_avancement etat) {
		this.etat = etat;
	}

	public Fichier() {
		    // Constructeur par défaut sans arguments
		}

	public Fichier(long id, String name, byte[] data,Etat_avancement etat) {
		super();
		this.id = id;
		this.name = name;
		this.type = "";
		this.data = data;
		this.etat = etat;
	}

	public long getId() {
		return id;
	}

	public void setId(long l) {
		this.id = l;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}

	
	
}
