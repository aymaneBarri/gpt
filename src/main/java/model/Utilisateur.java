package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Utilisateur {
	@Id
	private String nomUtilisateur;
	private String email;
	private String motDePasse;
	@Column(name = "is_admin")
	private boolean isAdmin;
	
	public Utilisateur() {
		// TODO Auto-generated constructor stub
	}

	public Utilisateur(String nomUtilisateur, String email, String motDePasse,boolean isAdmin) {
		super();
		this.nomUtilisateur = nomUtilisateur;
		this.email = email;
		this.motDePasse = motDePasse;
		this.isAdmin  = isAdmin;
	}

	public String getNomUtilisateur() {
		return nomUtilisateur;
	}

	public void setNomUtilisateur(String nomUtilisateur) {
		this.nomUtilisateur = nomUtilisateur;
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
	
	
	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "Utilisateur [nomUtilisateur=" + nomUtilisateur + ", email=" + email + ", motDePasse=" + motDePasse
				+ "]";
	}
}
