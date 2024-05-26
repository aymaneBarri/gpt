package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import jakarta.inject.Inject;
import model.Commentaire;
import model.EtatTache;
import model.Projet;
import model.Tache;

public class TacheDao {
	private Configuration configuration;
	private SessionFactory sessionFactory;
	private Session session;
	
	@Inject public TacheDao() {
		// TODO Auto-generated constructor stub
		this.configuration = new Configuration().configure();
		this.sessionFactory = configuration.buildSessionFactory();
		this.session = sessionFactory.openSession();
	}
	
	public List<Tache> getAll(){
		return this.session.createQuery("FROM Tache", Tache.class).getResultList();
	}
	
	public Tache getById(String idTache) {
		return session.find(Tache.class, idTache);
	}
	
	public List<Tache> getTasksByUser(String nomUtilisateur){
		Query<Tache> query = this.session.createQuery("FROM Tache t WHERE t.utilisateur.nomUtilisateur = :nomUtilisateur", Tache.class);
		query.setParameter("nomUtilisateur",nomUtilisateur);
		return query.getResultList();
	}
	
	public void insert(Tache tache) {
		Transaction transaction = session.beginTransaction();
		session.persist(tache);
		transaction.commit();
//		session.close();
//		sessionFactory.close();
	}
	
	public void updateTaskStatus(String idTache, String etat) {
		Transaction transaction = session.beginTransaction();
		Tache tache = session.find(Tache.class, idTache);
		tache.setEtatTache(EtatTache.valueOf(etat));
		session.persist(tache);
		transaction.commit();
//		session.close();
//		sessionFactory.close();
	}
}
