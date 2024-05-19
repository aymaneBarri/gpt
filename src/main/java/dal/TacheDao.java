package dal;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import jakarta.inject.Inject;
import model.EtatTache;
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
