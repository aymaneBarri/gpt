package model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idAdmin;
	private String nom;
	private String email;
	private String motDePasse;
	public Admin(String nom, String email, String motDePasse) {
		super();
		this.nom = nom;
		this.email = email;
		this.motDePasse = motDePasse;
	}
	public Admin() {
		super();
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
	public String getMotDePasse() {
		return motDePasse;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = motDePasse;
	}
	@Override
	public String toString() {
		return "Admin [nom=" + nom + ", email=" + email + ", motDePasse=" + motDePasse + "]";
	}	
	
	
}
