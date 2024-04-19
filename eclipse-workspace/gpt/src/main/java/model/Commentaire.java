package model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Commentaire {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idCommentaire;
	private String commentaire;
	private String commentateur;
	private LocalDateTime dateCommentaire;
	@ManyToOne @JoinColumn(name="idTache", nullable=false)
	private Tache tache;
	
	public Commentaire() {
		// TODO Auto-generated constructor stub
	}

	public Commentaire(int idCommentaire, String commentaire, String commentateur, LocalDateTime dateCommentaire) {
		super();
		this.idCommentaire = idCommentaire;
		this.commentaire = commentaire;
		this.commentateur = commentateur;
		this.dateCommentaire = dateCommentaire;
	}

	public int getIdCommentaire() {
		return idCommentaire;
	}

	public void setIdCommentaire(int idCommentaire) {
		this.idCommentaire = idCommentaire;
	}

	public String getCommentaire() {
		return commentaire;
	}

	public void setCommentaire(String commentaire) {
		this.commentaire = commentaire;
	}

	public String getCommentateur() {
		return commentateur;
	}

	public void setCommentateur(String commentateur) {
		this.commentateur = commentateur;
	}

	public LocalDateTime getDateCommentaire() {
		return dateCommentaire;
	}

	public void setDateCommentaire(LocalDateTime dateCommentaire) {
		this.dateCommentaire = dateCommentaire;
	}

	public Tache getTache() {
		return tache;
	}

	public void setTache(Tache tache) {
		this.tache = tache;
	}

	@Override
	public String toString() {
		return "Commentaire [idCommentaire=" + idCommentaire + ", commentaire=" + commentaire + ", commentateur="
				+ commentateur + ", dateCommentaire=" + dateCommentaire + "]";
	}
}
