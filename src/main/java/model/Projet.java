package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idProjet;
	private int nbrMax;
	private String nomProjet;
	@ManyToMany
	private List<Utilisateur> membres;
	@OneToOne
	private Utilisateur chef;

	public Projet(int nbrMax, String nomProjet, Utilisateur chefProjet, List<Utilisateur> membres) {
		super();
		this.nbrMax = nbrMax;
		this.nomProjet = nomProjet;
		this.chef = chefProjet;
		this.membres = membres;
	}

	private LocalDateTime dateDebut, dateFin;
	public List<Utilisateur> getMembres() {
		return membres;
	}

	public void setMembres(List<Utilisateur> membres) {
		this.membres = membres;
	}
	
	public Utilisateur getChef() {
		return chef;
	}

	public void setChef(Utilisateur chef) {
		this.chef = chef;
	}

	private ArrayList<Tache> taches;

	public Projet(int idProjet, int nbrMax, String nomProjet, LocalDateTime dateDebut, LocalDateTime dateFin,
			ArrayList<Tache> taches) {
		super();
		this.idProjet = idProjet;
		this.nbrMax = nbrMax;
		this.nomProjet = nomProjet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.taches = taches;
	}

	public Projet(String nomProjet, int nbrMax, LocalDateTime dateDebut, LocalDateTime dateFin,
			ArrayList<Tache> taches) {
		super();
		this.nbrMax = nbrMax;
		this.nomProjet = nomProjet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.taches = taches;
	}

	public Projet() {
		super();
	}

	public int getIdProjet() {
		return idProjet;
	}

	public void setIdProjet(int idProjet) {
		this.idProjet = idProjet;
	}

	public int getNbrMax() {
		return nbrMax;
	}

	public void setNbrMax(int nbrMax) {
		this.nbrMax = nbrMax;
	}

	public String getNomProjet() {
		return nomProjet;
	}

	public void setNomProjet(String nomProjet) {
		this.nomProjet = nomProjet;
	}

	public LocalDateTime getDateDebut() {
		return dateDebut;
	}

	public void setDateDebut(LocalDateTime dateDebut) {
		this.dateDebut = dateDebut;
	}

	public LocalDateTime getDateFin() {
		return dateFin;
	}

	public void setDateFin(LocalDateTime dateFin) {
		this.dateFin = dateFin;
	}

	public ArrayList<Tache> getTaches() {
		return taches;
	}

	public void setTaches(ArrayList<Tache> taches) {
		this.taches = taches;
	}

	@Override
	public String toString() {
		return "Projet [idProjet=" + idProjet + ", nomProjet=" + nomProjet + ", dateDebut=" + dateDebut + ", dateFin="
				+ dateFin + ", taches=" + taches + "]";
	}

}