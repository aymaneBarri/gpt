package model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Tache {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int idTache;
	private String nomTache;
	private LocalDateTime dateCreation;
	private LocalDateTime dateEcheance;
	private PrioriteTache prioriteTache;
	private EtatTache etatTache;
	@OneToMany(mappedBy = "tache")
	private List<Commentaire> commentaires = new ArrayList<Commentaire>();
	@ManyToOne  @JoinColumn(name="idChef", nullable=false)
	private Utilisateur utilisateur;
	@ManyToOne @JoinColumn(name="idProjet", nullable=false)
	private Projet projet;

	public Tache() {
		// TODO Auto-generated constructor stub
	}

	public Tache(int idTache, String nomTache, LocalDateTime dateCreation, LocalDateTime dateEcheance,
			PrioriteTache prioriteTache, EtatTache etatTache, ArrayList<Commentaire> commentaires,
			Utilisateur utilisateur) {
		super();
		this.idTache = idTache;
		this.nomTache = nomTache;
		this.dateCreation = dateCreation;
		this.dateEcheance = dateEcheance;
		this.prioriteTache = prioriteTache;
		this.etatTache = etatTache;
		this.commentaires = commentaires;
		this.utilisateur = utilisateur;
	}

	public Projet getProjet() {
		return projet;
	}

	public void setProjet(Projet projet) {
		this.projet = projet;
	}

	public int getIdTache() {
		return idTache;
	}

	public void setIdTache(int idTache) {
		this.idTache = idTache;
	}

	public String getNomTache() {
		return nomTache;
	}

	public void setNomTache(String nomTache) {
		this.nomTache = nomTache;
	}

	public LocalDateTime getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(LocalDateTime dateCreation) {
		this.dateCreation = dateCreation;
	}

	public LocalDateTime getDateEcheance() {
		return dateEcheance;
	}

	public void setDateEcheance(LocalDateTime dateEcheance) {
		this.dateEcheance = dateEcheance;
	}

	public List<Commentaire> getCommentaires() {
		return commentaires;
	}

	public void setCommentaires(ArrayList<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public Utilisateur getUtilisateur() {
		return utilisateur;
	}

	public void setUtilisateur(Utilisateur utilisateur) {
		this.utilisateur = utilisateur;
	}

	public PrioriteTache getPrioriteTache() {
		return prioriteTache;
	}

	public void setPrioriteTache(PrioriteTache prioriteTache) {
		this.prioriteTache = prioriteTache;
	}

	public void setCommentaires(List<Commentaire> commentaires) {
		this.commentaires = commentaires;
	}

	public EtatTache getEtatTache() {
		return etatTache;
	}

	public void setEtatTache(EtatTache etatTache) {
		this.etatTache = etatTache;
	}

	@Override
	public String toString() {
		return "Tache [idTache=" + idTache + ", nomTache=" + nomTache + ", dateCreation=" + dateCreation
				+ ", dateEcheance=" + dateEcheance + ", prioriteTache=" + prioriteTache + ", etatTache=" + etatTache
				+ ", commentaires=" + commentaires + ", utilisateur=" + utilisateur + "]";
	}
}
