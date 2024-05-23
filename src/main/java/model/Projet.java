package model;

import java.time.LocalDateTime;
import java.util.ArrayList;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Projet {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idProjet;
	private int nbrMax;
	private String nomProjet;
	private String chef;
	public Projet(int nbrMax, String nomProjet, String chefProjet) {
		super();
		this.nbrMax = nbrMax;
		this.nomProjet = nomProjet;
		this.chef = chefProjet;
	}
	private LocalDateTime dateDebut,dateFin;
	private ArrayList<Tache> taches ;
	public Projet(int idProjet,int nbrMax, String nomProjet, LocalDateTime dateDebut, LocalDateTime dateFin,
			ArrayList<Tache> taches) {
		super();
		this.idProjet = idProjet;
		this.nbrMax=nbrMax;
		this.nomProjet = nomProjet;
		this.dateDebut = dateDebut;
		this.dateFin = dateFin;
		this.taches = taches;
	}
	public Projet(String nomProjet,int nbrMax, LocalDateTime dateDebut, LocalDateTime dateFin, ArrayList<Tache> taches) {
		super();
		this.nbrMax=nbrMax;
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
	public String getChef() {
		return chef;
	}
	public void setChef(String chef) {
		this.chef = chef;
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