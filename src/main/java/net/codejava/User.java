package net.codejava;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "cin",nullable = true, length = 10,unique = true)
	 private String cin;
	
	@Column(name = "adresse",nullable = true, length = 255)
	 private String adresse;
	 
	 @Column(name = "photo",nullable = true, length = 255)
	 private String photo;
	 
	@Column(name = "login",nullable = false, unique = true, length = 45)
	private String username;
	
	@Column(nullable = false, unique = true, length = 255)
	private String email;
	
	@Column(nullable = false, length = 255)
	private String password;
	
	@Column(name = "prenom", nullable = false, length = 45)
	private String firstName;
	
	@Column(name = "nom", nullable = false, length = 45)
	private String lastName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getCin() {
			return cin;
		}

	public void setCin(String cin) {
			this.cin = cin;
		}

	public String getAdresse() {
			return adresse;
		}

	public void setAdresse(String adresse) {
			this.adresse = adresse;
		}

	public String getPhoto() {
			return photo;
		}

	public void setPhoto(String photo) {
			this.photo = photo;
		}
	
	
	
}
